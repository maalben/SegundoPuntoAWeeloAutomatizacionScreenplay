package com.weelo.demoqa.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectHobbies implements Interaction {

    private Target checkboxHobbiesOption;
    private String hobbies;

    public SelectHobbies(Target checkboxHobbiesOption, String hobbies) {
        this.checkboxHobbiesOption = checkboxHobbiesOption;
        this.hobbies = hobbies;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<String> userList = new ArrayList<>();
        userList.addAll(Arrays.asList(hobbies.split(",")));
        for(int i = 0; i < checkboxHobbiesOption.resolveAllFor(actor).size(); i++){
            for(int j=0; j < userList.size(); j++){
                if(BrowseTheWeb.as(actor).getDriver().findElement(By.xpath("//div[@id='hobbiesWrapper']/div[2]/div["+(i+1)+"]/label")).getText().equals(userList.get(j).trim())){
                    BrowseTheWeb.as(actor).getDriver().findElement(By.xpath("//div[@id='hobbiesWrapper']/div[2]/div["+(i+1)+"]/label")).click();
                    break;
                }
            }
        }
    }

    public static SelectHobbies option(Target checkboxHobbiesOption, String hobbies) {
        return new SelectHobbies(checkboxHobbiesOption, hobbies);
    }
}
