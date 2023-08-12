package co.com.falabella.tasks;

import co.com.falabella.interactions.RandomQuantity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ProductDetailsTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                RandomQuantity.click()
        );
    }

    public static ProductDetailsTask on(){
        return instrumented(ProductDetailsTask.class);
    }
}
