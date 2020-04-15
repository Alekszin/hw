package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MainScreen extends AbstractScreen{

    public MainScreen(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(accessibility = "imageProfile")
    public MobileElement profileButton;

}
