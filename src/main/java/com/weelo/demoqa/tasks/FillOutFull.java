package com.weelo.demoqa.tasks;

import com.weelo.demoqa.interactions.*;
import com.weelo.demoqa.models.TestData;
import static com.weelo.demoqa.util.constant.Constants.UP;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;
import static com.weelo.demoqa.userinterfaces.DemoqaUserInterfaces.*;
import static com.weelo.demoqa.userinterfaces.DemoqaUserInterfaces.TEXTFIELD_BIRTHDAY;

public class FillOutFull implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(TestData.getData().get("firstName").toString()).into(TEXTFIELD_NAME));
        actor.attemptsTo(Enter.theValue(TestData.getData().get("lastName").toString()).into(TEXTFIELD_LAST_NAME));
        actor.attemptsTo(Enter.theValue(TestData.getData().get("email").toString()).into(TEXTFIELD_EMAIL));
        actor.attemptsTo(SelectRadio.option(RADIO_GENDER_OPTION, TestData.getData().get("gender").toString()));
        actor.attemptsTo(Enter.theValue(TestData.getData().get("mobileNumber").toString()).into(TEXTFIELD_MOBILE_NUMBER));
        actor.attemptsTo(DisplaceScreen.withDirection(UP));
        actor.attemptsTo(Click.on(TEXTFIELD_BIRTHDAY));
        actor.attemptsTo(SelectElement.listDate(TestData.getData().get("dateBirth").toString()));
        actor.attemptsTo(SelectSubjects.option(TEXTFIELD_SUBJECTS, TestData.getData().get("subjects").toString()));
        actor.attemptsTo(SelectHobbies.option(CHECKBOX_HOBBIES_OPTION, TestData.getData().get("hobbies").toString()));
        actor.attemptsTo(ChoosePicture.student(TEXT_FIELD_FILE_PICTURE, TestData.getData().get("file").toString()));
        actor.attemptsTo(Enter.theValue(TestData.getData().get("currentAddress").toString()).into(TEXT_AREA_CURRENT_ADDRESS));
        actor.attemptsTo(Enter.theValue(TestData.getData().get("state").toString()).into(SELECT_STATE).thenHit(Keys.ENTER));
        actor.attemptsTo(Enter.theValue(TestData.getData().get("city").toString()).into(SELECT_CITY).thenHit(Keys.ENTER));
        actor.attemptsTo(Click.on(BUTTON_SUBMIT));
    }

    public static FillOutFull form() {
        return Tasks.instrumented(FillOutFull.class);
    }
}
