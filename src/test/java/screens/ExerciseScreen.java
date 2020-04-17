package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ExerciseScreen extends AbstractScreen {

    public ExerciseScreen(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(id = APP_ID + "editMachine")
    private MobileElement exerciseName;

    @AndroidFindBy(id = APP_ID + "editSerie")
    private MobileElement setsAmount;

    @AndroidFindBy(id = APP_ID + "editRepetition")
    private MobileElement repetitionAmount;

    @AndroidFindBy(id = APP_ID + "editPoids")
    private MobileElement weightAmount;

    @AndroidFindBy(accessibility = "2")
    private MobileElement digit2;
}

