package com.weelo.demoqa.interactions;

import com.weelo.demoqa.util.constant.Constants;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.targets.Target;

import static com.weelo.demoqa.util.constant.Constants.PATH_PICTURE;

public class ChoosePicture implements Interaction {

    private final Target textFieldFilePicture;
    private final String file;


    public ChoosePicture(Target textFieldFilePicture, String file) {
        this.textFieldFilePicture = textFieldFilePicture;
        this.file = file;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String filePath = PATH_PICTURE + file;
        String directory = System.getProperty("user.dir");
        String fileRute = directory + filePath;
        textFieldFilePicture.resolveFor(actor).sendKeys(fileRute);
    }

    public static ChoosePicture student(Target textFieldFilePicture, String file) {
        return new ChoosePicture(textFieldFilePicture, file);
    }
}
