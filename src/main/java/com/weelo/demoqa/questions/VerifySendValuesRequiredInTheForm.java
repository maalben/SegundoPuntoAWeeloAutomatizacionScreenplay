package com.weelo.demoqa.questions;

import com.weelo.demoqa.models.TestData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.assertj.core.api.SoftAssertions;
import static com.weelo.demoqa.userinterfaces.DemoqaUserInterfaces.*;

public class VerifySendValuesRequiredInTheForm implements Question<Boolean> {

    private final SoftAssertions validateSendValues = new SoftAssertions();

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean flag = false;

        if (LABEL_VERIFICATION_MESSAGE.resolveFor(actor).isPresent()) {
            flag = true;
            validateSendValues.assertThat(Text.of(LABEL_VERIFICATION_MESSAGE).viewedBy(actor).asString()).isEqualTo(TestData.getData().get("expected").toString());
            validateSendValues.assertThat(Text.of(LABEL_NAME_LASTNAME).viewedBy(actor).asString()).isEqualTo(TestData.getData().get("firstName").toString() + " " + TestData.getData().get("lastName").toString());
            validateSendValues.assertThat(Text.of(LABEL_GENDER).viewedBy(actor).asString()).isEqualTo(TestData.getData().get("gender").toString());
            validateSendValues.assertThat(Text.of(LABEL_MOBILE_NUMBER).viewedBy(actor).asString()).isEqualTo(TestData.getData().get("mobileNumber").toString());
            validateSendValues.assertAll();
        }

        return flag;
    }

    public static VerifySendValuesRequiredInTheForm areCorrect() {
        return new VerifySendValuesRequiredInTheForm();
    }
}
