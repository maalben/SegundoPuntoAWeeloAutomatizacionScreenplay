package com.weelo.demoqa.questions;

import com.weelo.demoqa.models.TestData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.assertj.core.api.SoftAssertions;

import static com.weelo.demoqa.userinterfaces.DemoqaUserInterfaces.*;
import static com.weelo.demoqa.util.UtilMonth.dateValidation;

public class VerifySendValuesInTheForm implements Question<Boolean> {

    private final SoftAssertions validateSendValues = new SoftAssertions();

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean flag = false;

        if (LABEL_VERIFICATION_MESSAGE.resolveFor(actor).isPresent()) {
            flag = true;

            validateSendValues.assertThat(Text.of(LABEL_VERIFICATION_MESSAGE).viewedBy(actor).asString()).isEqualTo(TestData.getData().get("expected").toString());
            validateSendValues.assertThat(Text.of(LABEL_NAME_LASTNAME).viewedBy(actor).asString()).isEqualTo(TestData.getData().get("firstName").toString() + " " + TestData.getData().get("lastName").toString());
            validateSendValues.assertThat(Text.of(LABEL_EMAIL).viewedBy(actor).asString()).isEqualTo(TestData.getData().get("email").toString());
            validateSendValues.assertThat(Text.of(LABEL_GENDER).viewedBy(actor).asString()).isEqualTo(TestData.getData().get("gender").toString());
            validateSendValues.assertThat(Text.of(LABEL_MOBILE_NUMBER).viewedBy(actor).asString()).isEqualTo(TestData.getData().get("mobileNumber").toString());
            validateSendValues.assertThat(Text.of(LABEL_DATE_BIRTH).viewedBy(actor).asString()).isEqualTo(dateValidation(TestData.getData().get("dateBirth").toString()));
            validateSendValues.assertThat(Text.of(LABEL_SUBJECTS).viewedBy(actor).asString()).isEqualTo(TestData.getData().get("subjects").toString());
            validateSendValues.assertThat(Text.of(LABEL_HOBBIES).viewedBy(actor).asString()).isEqualTo(TestData.getData().get("hobbies").toString());
            validateSendValues.assertThat(Text.of(LABEL_FILE).viewedBy(actor).asString()).isEqualTo(TestData.getData().get("file").toString());
            validateSendValues.assertThat(Text.of(LABEL_CURRENT_ADDRESS).viewedBy(actor).asString()).isEqualTo(TestData.getData().get("currentAddress").toString());
            validateSendValues.assertThat(Text.of(LABEL_STATE).viewedBy(actor).asString()).isEqualTo(TestData.getData().get("state").toString() + " " + TestData.getData().get("city").toString());
            validateSendValues.assertAll();
        }

        return flag;
    }

    public static VerifySendValuesInTheForm areCorrect() {
        return new VerifySendValuesInTheForm();
    }
}
