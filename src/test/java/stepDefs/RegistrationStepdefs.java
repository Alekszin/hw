package stepDefs;

import io.cucumber.java.en.Given;
import lombok.AllArgsConstructor;
import steps.OnboardingSteps;
import steps.RegistrationSteps;

@AllArgsConstructor
public class RegistrationStepdefs {

    private OnboardingSteps onboardingSteps;
    private RegistrationSteps registrationSteps;

    @Given("user creates an account")
    public void userCreatesAnAccount() {
        onboardingSteps.skipOnboarding();
        registrationSteps.register();
    }
}
