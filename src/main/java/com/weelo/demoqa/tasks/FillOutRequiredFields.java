package com.weelo.demoqa.tasks;

import com.weelo.demoqa.interactions.*;
import com.weelo.demoqa.models.TestData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import static com.weelo.demoqa.userinterfaces.DemoqaUserInterfaces.*;
import static com.weelo.demoqa.util.constant.Constants.UP;

public class FillOutRequiredFields implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(TestData.getData().get("firstName").toString()).into(TEXTFIELD_NAME));
        actor.attemptsTo(Enter.theValue(TestData.getData().get("lastName").toString()).into(TEXTFIELD_LAST_NAME));
        actor.attemptsTo(SelectRadio.option(RADIO_GENDER_OPTION, TestData.getData().get("gender").toString()));
        actor.attemptsTo(Enter.theValue(TestData.getData().get("mobileNumber").toString()).into(TEXTFIELD_MOBILE_NUMBER));
        actor.attemptsTo(DisplaceScreen.withDirection(UP));
        actor.attemptsTo(Click.on(BUTTON_SUBMIT));
    }

    public static FillOutRequiredFields form() {
        return Tasks.instrumented(FillOutRequiredFields.class);
    }
}
