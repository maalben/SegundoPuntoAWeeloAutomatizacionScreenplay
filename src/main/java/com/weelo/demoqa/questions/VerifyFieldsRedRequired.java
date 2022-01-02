package com.weelo.demoqa.questions;

import com.weelo.demoqa.models.TestData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.assertj.core.api.SoftAssertions;
import static com.weelo.demoqa.userinterfaces.DemoqaUserInterfaces.*;

public class VerifyFieldsRedRequired implements Question<Boolean> {

    private final SoftAssertions validateSendValues = new SoftAssertions();

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean flag = false;

        if (TEXTFIELD_NAME.resolveFor(actor).isPresent()) {
            flag = true;

            validateSendValues.assertThat(TEXTFIELD_NAME.resolveFor(actor).getCssValue("border-top-color").trim()).isEqualTo(TestData.getData().get("expected").toString().trim());
            validateSendValues.assertThat(TEXTFIELD_LAST_NAME.resolveFor(actor).getCssValue("border-top-color").trim()).isEqualTo(TestData.getData().get("expected").toString().trim());
            validateSendValues.assertThat(TEXTFIELD_MOBILE_NUMBER.resolveFor(actor).getCssValue("border-top-color").trim()).isEqualTo(TestData.getData().get("expected").toString().trim());
            validateSendValues.assertThat(OPTION_RADIO_GENDER_1.resolveFor(actor).getCssValue("color").trim()).isEqualTo(TestData.getData().get("expected").toString().trim());
            validateSendValues.assertThat(OPTION_RADIO_GENDER_2.resolveFor(actor).getCssValue("color").trim()).isEqualTo(TestData.getData().get("expected").toString().trim());
            validateSendValues.assertThat(OPTION_RADIO_GENDER_3.resolveFor(actor).getCssValue("color").trim()).isEqualTo(TestData.getData().get("expected").toString().trim());

            validateSendValues.assertAll();
        }

        return flag;
    }

    public static VerifyFieldsRedRequired areVisible() {
        return new VerifyFieldsRedRequired();
    }

}
