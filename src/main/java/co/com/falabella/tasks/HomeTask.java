package co.com.falabella.tasks;

import co.com.falabella.interactions.ShadowDom;
import co.com.falabella.utils.ProductDao;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.sql.SQLException;

import static co.com.falabella.ui.HomeUI.BTN_COOKIES;
import static co.com.falabella.ui.HomeUI.TXT_SEARCH;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class HomeTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        ProductDao pd = new ProductDao();
        try {
            actor.attemptsTo(
                    ShadowDom.click(),
                    Click.on(BTN_COOKIES),
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
