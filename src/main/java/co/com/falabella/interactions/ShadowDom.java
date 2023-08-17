package co.com.falabella.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ShadowDom implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        WebElement shadowHost = driver.findElement(By.xpath("//div[@class='airship-html-prompt-shadow']"));

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement shadowButton = (WebElement) jsExecutor.executeScript(
                "return arguments[0].shadowRoot.querySelector(arguments[1]);",
                shadowHost,
                ".airship-btn.airship-btn-deny"
        );

        shadowButton.click();
    }

    public static Performable click(){
        return instrumented(ShadowDom.class);
    }
}
