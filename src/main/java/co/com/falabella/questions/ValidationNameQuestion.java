package co.com.falabella.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.falabella.ui.ValidationUI.LBL_NAME_CART;

public class ValidationNameQuestion implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {

        WebElementFacade name = LBL_NAME_CART.resolveFor(actor);

        String nameAdd = actor.recall("name");
        String nameCart = name.getText();

        if(!nameCart.contains(nameAdd)){
            return false;
        }

        return true;
    }

    public static Question<Boolean> from(){
        return new ValidationNameQuestion();
    }
}
