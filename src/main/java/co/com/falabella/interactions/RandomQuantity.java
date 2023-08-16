package co.com.falabella.interactions;

import co.com.falabella.models.Product;
import co.com.falabella.utils.ProductDao;
import net.serenitybdd.core.pages.WebElementFacade;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Value;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import static co.com.falabella.ui.ProductDetailsUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RandomQuantity implements Interaction {
    ProductDao pd = new ProductDao();

    @Override
    public <T extends Actor> void performAs(T actor) {

        Random random = new Random();
        int randomNumber = random.nextInt(3) + 1;

        for (int j = 0; j < randomNumber; j++) {
            actor.attemptsTo(
                    Click.on(BTN_QUANTITY)
            );
        }

        actor.remember(
                "name",
                Text.of(LBL_NAME)
        );

        actor.remember(
                "quantity",
                Value.of(LBL_QUANTITY).asInteger()
        );

        String name = actor.recall("name");
        int quantity = actor.recall("quantity");
        Product p = Product.builder().nombre(name).cantidad(quantity).build();

        try {
            pd.insertar(p);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        actor.attemptsTo(
                Click.on(BTN_ADD_CART),
                Click.on(BTN_GO_CART)
        );
    }

    public static Performable click(){
        return instrumented(RandomQuantity.class);
    }
}
