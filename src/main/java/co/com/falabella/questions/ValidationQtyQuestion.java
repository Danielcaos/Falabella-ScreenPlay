package co.com.falabella.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.falabella.ui.ValidationUI.LBL_NAME_CART;
import static co.com.falabella.ui.ValidationUI.LBL_QUANTITY_CART;

public class ValidationQtyQuestion implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        WebElementFacade qty = LBL_QUANTITY_CART.resolveFor(actor);

        int qtyAdd = actor.recall("quantity");
        int qtyCart = Integer.parseInt(qty.getValue());

        if(!(qtyAdd == qtyCart)){
            return false;
        }

        return true;
    }

    public static Question<Boolean> from(){
        return new ValidationQtyQuestion();
    }
}
