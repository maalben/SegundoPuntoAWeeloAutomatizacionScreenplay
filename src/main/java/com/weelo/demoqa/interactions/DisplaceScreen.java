package com.weelo.demoqa.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.JavascriptExecutor;

public class DisplaceScreen implements Interaction {

    private String direction;

    public DisplaceScreen(String direction) {
        this.direction = direction;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        JavascriptExecutor js = (JavascriptExecutor) BrowseTheWeb.as(actor).getDriver();
        switch (direction){
            case "UP":
                js.executeScript("javascript:window.scrollBy(0,500)");
                break;

            case "DOWN":
                js.executeScript("javascript:window.scrollBy(0,-500)");
                break;
        }
    }

    public static DisplaceScreen withDirection(String direction) {
        return new DisplaceScreen(direction);
    }
}
