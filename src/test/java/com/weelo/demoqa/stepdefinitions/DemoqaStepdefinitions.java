package com.weelo.demoqa.stepdefinitions;

import com.weelo.demoqa.exceptions.AssertionsDemoqa;
import com.weelo.demoqa.models.TestData;
import com.weelo.demoqa.questions.VerifyFieldsRedRequired;
import com.weelo.demoqa.questions.VerifyMessageSuccess;
import com.weelo.demoqa.questions.VerifySendValuesInTheForm;
import com.weelo.demoqa.questions.VerifySendValuesRequiredInTheForm;
import com.weelo.demoqa.tasks.*;
import com.weelo.demoqa.util.Wait;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.IsEqual.equalTo;

public class DemoqaStepdefinitions {

    @Managed(driver ="chrome")
    private WebDriver hisBrowser;
    Actor mario = Actor.named("Mario");

    @Before
    public void setup()
    {
        mario.can(BrowseTheWeb.with(hisBrowser));
    }

    @Given("^Yo Ingreso a la plataforma de registro estudiante demoqa$")
    public void yoIngresoALaPlataformaDeRegistroEstudianteDemoqa() {
        mario.wasAbleTo(Enter.toThePageDemoqa());
    }

    @Given("^Yo cargo los datos del estudiante$")
    public void yoCargoLosDatosDelEstudiante(List<Map<String, String>> studentDetails) {
        mario.wasAbleTo(Load.testData(studentDetails.get(0)));
    }

    @When("^Yo diligencio el formulario de registro$")
    public void yoDiligencioElFormularioDeRegistro() {
        mario.attemptsTo(FillOutFull.form());
    }

    @Then("^Yo verifico que se muestre el mensaje esperado$")
    public void yoVerificoQueSeMuestreElMensajeEsperado() {
        mario.should(seeThat(VerifyMessageSuccess.is(), equalTo(TestData.getData().get("expected")))
                .orComplainWith(AssertionsDemoqa.class, AssertionsDemoqa.NO_FOUND_ELEMENT));
    }

    @Then("^Yo verifico los datos en la ventana de confirmacion$")
    public void yoVerificoLosDatosEnLaVentanaDeConfirmacion() {
        mario.should(seeThat(VerifySendValuesInTheForm.areCorrect())
                .orComplainWith(AssertionsDemoqa.class, AssertionsDemoqa.NO_FOUND_ELEMENT));
    }

    @When("^Yo diligencio el formulario solo con datos obligatorios$")
    public void yoDiligencioElFormularioSoloConDatosObligatorios() {
        mario.attemptsTo(FillOutRequiredFields.form());
    }

    @Then("^Yo verifico los datos obligatorios en la ventana de confirmacion$")
    public void yoVerificoLosDatosObligatoriosEnLaVentanaDeConfirmacion() {
        mario.should(seeThat(VerifySendValuesRequiredInTheForm.areCorrect())
                .orComplainWith(AssertionsDemoqa.class, AssertionsDemoqa.NO_FOUND_ELEMENT));
    }

    @When("^Yo diligencio el formulario con datos no obligatorios$")
    public void yoDiligencioElFormularioConDatosNoObligatorios() {
        mario.attemptsTo(FillOutNotRequiredFields.form());
    }

    @Then("^Yo deberia ver que se muestren los campos obligatorios de color rojo$")
    public void yoDeberiaVerQueSeMuestrenLosCamposObligatoriosDeColorRojo() {
        mario.attemptsTo(Wait.theNext(1));
        mario.should(seeThat(VerifyFieldsRedRequired.areVisible())
                .orComplainWith(AssertionsDemoqa.class, AssertionsDemoqa.COLOR_BORDER_FIELD_NO_EXPECTED));
    }

}
