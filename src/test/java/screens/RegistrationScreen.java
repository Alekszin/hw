package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class RegistrationScreen extends AbstractScreen {

    @AndroidFindBy(id = APP_ID + "profileName")
    public MobileElement fullnameField;

    @AndroidFindBy(id = APP_ID + "radioButtonMale")
    public MobileElement maleRadioButton;

    @AndroidFindBy(id = APP_ID + "profileBirthday")
    public MobileElement profileBirthdayButton;

    @AndroidFindBy(id = APP_ID + "profileSize")
    public MobileElement sizeField;

    @AndroidFindBy(id = APP_ID + "create_newprofil")
    public MobileElement createAccountButton;

    @AndroidFindBy(id = APP_ID + "android:id/date_picker_header_year")
    public MobileElement datePickerHeaderYearButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='2000']")
    public MobileElement yearButton;

    @AndroidFindBy(xpath = "//android.view.View/android.view.View")
    public List<MobileElement> dates;

    @AndroidFindBy(id = APP_ID + "button1")
    public MobileElement okButton;

    @AndroidFindBy(id = APP_ID + "confirm_button")
    public MobileElement profileCreateApprovalButton;


    public RegistrationScreen(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }
}

