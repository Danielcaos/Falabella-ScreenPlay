package co.com.falabella.ui;

import net.serenitybdd.screenplay.targets.Target;

public class HomeUI {

    public static Target TXT_SEARCH=Target.the("Field search")
            .locatedBy("//input[@id='testId-SearchBar-Input']");

    public static Target BTN_COOKIES=Target.the("Acept cookies")
            .locatedBy("//button[@id='testId-accept-cookies-btn']");


}
