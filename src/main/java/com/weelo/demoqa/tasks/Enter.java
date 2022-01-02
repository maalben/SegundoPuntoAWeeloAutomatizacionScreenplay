package com.weelo.demoqa.tasks;

import com.weelo.demoqa.userinterfaces.DemoqaUserInterfaces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Enter implements Task {

    private DemoqaUserInterfaces demoqaUserInterfaces;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(demoqaUserInterfaces));
    }

    public static Enter toThePageDemoqa() {
        return instrumented(Enter.class);
    }
}
