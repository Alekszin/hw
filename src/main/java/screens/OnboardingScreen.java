package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class OnboardingScreen extends AbstractScreen {

    public OnboardingScreen(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(id = APP_ID + "mi_button_next")
    public MobileElement nextButton;
}
