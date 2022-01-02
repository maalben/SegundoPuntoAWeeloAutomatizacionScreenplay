package com.weelo.demoqa.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.Keys;

public class SelectSubjects implements Interaction {

    private final Target textfieldSubjects;
    private final String subjects;

    public SelectSubjects(Target textfieldSubjects, String subjects) {
        this.textfieldSubjects = textfieldSubjects;
        this.subjects = subjects;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String[] convertedSubjectsArray = subjects.split(",");
        actor.attemptsTo(Click.on(textfieldSubjects));
        for (String data : convertedSubjectsArray) {
            actor.attemptsTo(Enter.keyValues(data.trim()).into(textfieldSubjects).thenHit(Keys.ENTER));
        }
    }

    public static SelectSubjects option(Target textfieldSubjects, String subjects) {
        return new SelectSubjects(textfieldSubjects, subjects);
    }
}
