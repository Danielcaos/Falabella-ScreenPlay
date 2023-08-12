package co.com.falabella.stepDefinitions;

import co.com.falabella.interactions.ClickRandomProduct;
import co.com.falabella.questions.ValidationNameQuestion;
import co.com.falabella.questions.ValidationQtyQuestion;
import co.com.falabella.tasks.HomeTask;
import co.com.falabella.tasks.ProductDetailsTask;
import co.com.falabella.tasks.ProductsCatalogTask;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class AddProductCartStepDef {

    @Before
    public void setStage(){
        setTheStage(new OnlineCast());
    }

    @Given("that user open page Falabella and search any product")
    public void thatUserOpenPageFalabellaAndSearchAnyProduct() {
        theActorCalled("User").wasAbleTo(
                Open.url("https://www.falabella.com.co/"),
                HomeTask.on()
        );
    }

    @When("user click on product tittle and modify the quantity and user click on add to cart")
    public void userClickOnProductTittleAndModifyTheQuantityAndUserClickOnAddToCart() {
        theActorInTheSpotlight().attemptsTo(
                ProductsCatalogTask.on(),
                ProductDetailsTask.on()
        );
    }

    @Then("user will be able to see the selected product with its quantity")
    public void userWillBeAbleToSeeTheSelectedProductWithItsQuantity() {
        theActorInTheSpotlight().should(
                seeThat(
                        ValidationNameQuestion.from(), Matchers.equalTo(true)
                ),
                seeThat(
                        ValidationQtyQuestion.from(), Matchers.equalTo(true)
                )
        );
    }

}
