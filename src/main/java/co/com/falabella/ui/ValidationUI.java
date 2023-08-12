package co.com.falabella.ui;

import net.serenitybdd.screenplay.targets.Target;

public class ValidationUI {

    public static Target LBL_NAME_CART=Target.the("Label name cart")
            .locatedBy("//a[@class='chakra-link css-qpfo7l']");

    public static Target LBL_QUANTITY_CART=Target.the("Label quantity cart")
            .locatedBy("//input[contains(@id,'qty-')]");

}
