package com.weelo.demoqa.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SelectRadio implements Interaction {

    private final Target radioGenderOption;
    private final String gender;

    public SelectRadio(Target radioGenderOption, String gender) {
        this.radioGenderOption = radioGenderOption;
        this.gender = gender;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for(int i=0; i<radioGenderOption.resolveAllFor(actor).size(); i++){
            if(radioGenderOption.resolveAllFor(actor).get(i).findElement(By.tagName("input")).getAttribute("value").equals(gender)){
                radioGenderOption.resolveAllFor(actor).get(i).findElement(By.tagName("label")).click();
                break;
            }
        }
    }

    public static SelectRadio option(Target radioGenderOption, String gender) {
        return new SelectRadio(radioGenderOption, gender);
    }
}
