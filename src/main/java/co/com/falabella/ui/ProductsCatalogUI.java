package co.com.falabella.ui;

import net.serenitybdd.screenplay.targets.Target;

public class ProductsCatalogUI {

    public static Target LNK_PRODUCT=Target.the("Link product")
            .locatedBy("//a[contains(@class,'jsx-1576191951 section-body pod-link')]");

}
