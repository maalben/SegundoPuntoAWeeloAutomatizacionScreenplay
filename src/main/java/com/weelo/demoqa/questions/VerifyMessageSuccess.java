package com.weelo.demoqa.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.weelo.demoqa.userinterfaces.DemoqaUserInterfaces.LABEL_VERIFICATION_MESSAGE;

public class VerifyMessageSuccess implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return LABEL_VERIFICATION_MESSAGE.resolveFor(actor).getText();
    }

    public static VerifyMessageSuccess is() {
        return new VerifyMessageSuccess();
    }
}
