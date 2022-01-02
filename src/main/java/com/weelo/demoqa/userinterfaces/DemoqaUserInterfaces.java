package com.weelo.demoqa.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;


@DefaultUrl("https://demoqa.com/automation-practice-form")
public class DemoqaUserInterfaces extends PageObject {

    public static final Target TEXTFIELD_NAME = Target.the("Campo de texto nombre").located(By.id("firstName"));
    public static final Target TEXTFIELD_LAST_NAME = Target.the("Campo de texto apellido").located(By.id("lastName"));
    public static final Target TEXTFIELD_EMAIL = Target.the("Campo de texto email").located(By.id("userEmail"));
    public static final Target RADIO_GENDER_OPTION = Target.the("Radio opcion genero").located(By.xpath("//div[@id='genterWrapper']/div[2]/div"));
    public static final Target TEXTFIELD_MOBILE_NUMBER = Target.the("Campo de texto mobile number").located(By.id("userNumber"));
    public static final Target TEXTFIELD_BIRTHDAY = Target.the("Campo de texto fecha de nacimiento").located(By.xpath("//div[@class='react-datepicker__input-container']"));
    public static final Target SELECT_LIST_YEARS = Target.the("Campo de seleccion de anios").located(By.xpath("//select[@class='react-datepicker__year-select']/option"));
    public static final Target SELECT_LIST_MONTH = Target.the("Campo de seleccion de mes").located(By.xpath("//select[@class='react-datepicker__month-select']/option"));
    public static final Target TABLE_HORIZONTAL_DAY = Target.the("Tabla con dias horizontales").located(By.xpath("//div[@class='react-datepicker__month-container']/div[2]/div/div"));
    public static final Target TEXTFIELD_SUBJECTS = Target.the("Campo de texto asuntos").located(By.id("subjectsInput"));
    public static final Target CHECKBOX_HOBBIES_OPTION = Target.the("Checkbox hobbies").located(By.xpath("//div[@id='hobbiesWrapper']/div[2]/div"));
    public static final Target TEXT_FIELD_FILE_PICTURE = Target.the("Campo de texto de foto").located(By.id("uploadPicture"));
    public static final Target TEXT_AREA_CURRENT_ADDRESS = Target.the("Area de texto direccion actual").located(By.id("currentAddress"));
    public static final Target SELECT_STATE = Target.the("Campo seleccion estado").located(By.id("react-select-3-input"));
    public static final Target SELECT_CITY = Target.the("Campo seleccion ciudad").located(By.id("react-select-4-input"));
    public static final Target BUTTON_SUBMIT = Target.the("Boton de formulario").located(By.id("submit"));
    public static final Target LABEL_VERIFICATION_MESSAGE = Target.the("Etiqueta de mensaje exitoso").located(By.id("example-modal-sizes-title-lg"));

    private static final String relativePath = "//div[@class='modal-content']//table/tbody/tr";

    public static final Target LABEL_NAME_LASTNAME =
            Target.the("Label para mostrar el nombre y apellido").located(By.xpath(relativePath+"[1]/td[2]"));
    public static final Target LABEL_EMAIL =
            Target.the("Label para mostrar el correo electronico").located(By.xpath(relativePath+"[2]/td[2]"));
    public static final Target LABEL_GENDER =
            Target.the("Label para mostrar el genero").located(By.xpath(relativePath+"[3]/td[2]"));
    public static final Target LABEL_MOBILE_NUMBER =
            Target.the("Label para mostrar el numero celular").located(By.xpath(relativePath+"[4]/td[2]"));
    public static final Target LABEL_DATE_BIRTH =
            Target.the("Label para mostrar la fecha de nacimiento").located(By.xpath(relativePath+"[5]/td[2]"));
    public static final Target LABEL_SUBJECTS =
            Target.the("Label para mostrar los asuntos").located(By.xpath(relativePath+"[6]/td[2]"));
    public static final Target LABEL_HOBBIES =
            Target.the("Label para mostrar los hobbies").located(By.xpath(relativePath+"[7]/td[2]"));
    public static final Target LABEL_FILE =
            Target.the("Label para mostrar el nombre del archivo").located(By.xpath(relativePath+"[8]/td[2]"));
    public static final Target LABEL_CURRENT_ADDRESS =
            Target.the("Label para mostrar la direccion actual").located(By.xpath(relativePath+"[9]/td[2]"));
    public static final Target LABEL_STATE =
            Target.the("Label para mostrar la direccion actual").located(By.xpath(relativePath+"[10]/td[2]"));
    public static final Target OPTION_RADIO_GENDER_1 = Target.the("Opcion radio genero 1").located(By.xpath("//label[@for='gender-radio-1']"));
    public static final Target OPTION_RADIO_GENDER_2 = Target.the("Opcion radio genero 2").located(By.xpath("//label[@for='gender-radio-2']"));
    public static final Target OPTION_RADIO_GENDER_3 = Target.the("Opcion radio genero 3").located(By.xpath("//label[@for='gender-radio-3']"));
}
