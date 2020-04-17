package stepDefs;

import steps.OnboardingSteps;
import steps.RegistrationSteps;

public class RegistrationStepdefs {

    private OnboardingSteps onboardingSteps;
    private RegistrationSteps registrationSteps;

    public RegistrationStepdefs(OnboardingSteps onboardingSteps, RegistrationSteps registrationSteps) {
        this.onboardingSteps = onboardingSteps;
        this.registrationSteps = registrationSteps;
    }

    @Given("user creates an account")
    public void userCreatesAnAccount() {
        onboardingSteps.skipOnboarding();
        registrationSteps.register();
    }
}
