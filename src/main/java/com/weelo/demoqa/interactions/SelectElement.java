package com.weelo.demoqa.interactions;

import static com.weelo.demoqa.userinterfaces.DemoqaUserInterfaces.*;
import static com.weelo.demoqa.util.UtilMonth.getMonth;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;

public class SelectElement implements Interaction {

    private final String dateBirth;

    public SelectElement(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String[] splitDate = dateBirth.split("-");
        String day = splitDate[0];
        int value = Integer.parseInt(day);
        day = String.valueOf(value);
        String month = getMonth(splitDate[1]);
        String year = splitDate[2];

        selectElementListDate(actor, SELECT_LIST_YEARS, year);
        selectElementListDate(actor, SELECT_LIST_MONTH, month);

        for(int horizontal=0; horizontal<TABLE_HORIZONTAL_DAY.resolveAllFor(actor).size(); horizontal++){
            if(horizontal < 11 && TABLE_HORIZONTAL_DAY.resolveAllFor(actor).get(horizontal).getText().equals(day) && Integer.parseInt(day) > 10){
                continue;
            }else{
                if(TABLE_HORIZONTAL_DAY.resolveAllFor(actor).get(horizontal).getText().equals(day)){
                    TABLE_HORIZONTAL_DAY.resolveAllFor(actor).get(horizontal).click();
                    break;
                }
            }
        }
    }

    public static void selectElementListDate(Actor actor, Target element, String value) {
        for(int i=0; i<element.resolveAllFor(actor).size(); i++){
            if(element.resolveAllFor(actor).get(i).getText().equals(value)){
                element.resolveAllFor(actor).get(i).click();
                break;
            }
        }
    }

    public static SelectElement listDate(String dateBirth) {
        return new SelectElement(dateBirth);
    }

}
