package co.com.falabella.tasks;

import co.com.falabella.utils.ProductDao;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import java.sql.SQLException;

import static co.com.falabella.ui.HomeUI.TXT_SEARCH;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class HomeTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        ProductDao pd = new ProductDao();
        try {
            actor.attemptsTo(
                    Enter.theValue(pd.buscar(1)).into(TXT_SEARCH).thenHit(Keys.ENTER)
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static HomeTask on(){
        return  instrumented(HomeTask.class);
    }
}
