package co.com.falabella.ui;

import net.serenitybdd.screenplay.targets.Target;

public class ProductDetailsUI {

    public static Target BTN_QUANTITY=Target.the("Button quantity product")
            .locatedBy("//button[@id='quantity-selector-increment-btn']");

    public static Target BTN_ADD_CART=Target.the("Button add cart")
            .locatedBy("//button[@id='add-to-cart-button']");

    public static Target BTN_GO_CART=Target.the("Button go to cart")
            .locatedBy("//a[@id='linkButton']");

    public static Target LBL_QUANTITY=Target.the("Label quantity product")
            .locatedBy("//input[@id='quantity-selector-increment-input']");

    public static Target LBL_NAME=Target.the("Label name product")
            .locatedBy("//h1[@class='jsx-1680787435 product-name fa--product-name false']");

}
