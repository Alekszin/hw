package stepDefs;

import cucumber.api.java.en.Given;
import steps.OnboardingSteps;

public class RegistrationStepdefs {

    private OnboardingSteps onboardingSteps;

    public RegistrationStepdefs(OnboardingSteps onboardingSteps) {
        this.onboardingSteps = onboardingSteps;
    }

    @Given("user John creates an account")
    public void userJohnCreatesAnAccount() {
        onboardingSteps.skipOnboarding();
    }
}
