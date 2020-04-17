package steps;

import helpers.RandomGenerator;
import helpers.Users;
import io.appium.java_client.MobileElement;
import lombok.AllArgsConstructor;
import screens.RegistrationScreen;

import java.util.NoSuchElementException;

@AllArgsConstructor
public class RegistrationSteps {

    private RegistrationScreen registrationScreen;
    private Users users;
    private RandomGenerator randomGenerator;


    public void register() {
        setUsers();
        registrationScreen.waitAndSetValue(registrationScreen.fullnameField, users.getUsername());
        registrationScreen.click(registrationScreen.maleRadioButton);
        selectYearAndDate();
        registrationScreen.waitAndSetValue(registrationScreen.sizeField, users.getSize());
        registrationScreen.click(registrationScreen.okButton);
        registrationScreen.click(registrationScreen.createAccountButton);
        registrationScreen.click(registrationScreen.profileCreateApprovalButton);
    }

    private void setUsers() {
        users.setUsername(randomGenerator.randomString());
        users.setSize(randomGenerator.randomInt());
    }

    private void selectYearAndDate() {
        registrationScreen.click(registrationScreen.profileBirthdayButton);
        registrationScreen.waitAndSelectElement(registrationScreen.datePickerHeaderYearButton);
        registrationScreen.isElementVisibleInScreen(registrationScreen.yearButton, 60);
        selectDay();
    }

    private void selectDay() {
        MobileElement element = registrationScreen.dates.stream()
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("Element notfound"));
        registrationScreen.click(element);
    }
}
