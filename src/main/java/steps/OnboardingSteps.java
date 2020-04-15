package steps;

import screens.OnboardingScreen;
import screens.RegistrationScreen;

import java.util.stream.IntStream;

public class OnboardingSteps {

    private OnboardingScreen onboardingScreen;
    private RegistrationScreen registrationScreen;

    public OnboardingSteps(OnboardingScreen onboardingScreen, RegistrationScreen registrationScreen) {
        this.onboardingScreen = onboardingScreen;
        this.registrationScreen = registrationScreen;
    }

    public void skipOnboarding() {

        if (!onboardingScreen.isElementPresentSafe(registrationScreen.fullnameField, 30)) {
            IntStream.range(0, 5)
                    .forEach(index -> onboardingScreen.nextButton.click());
        }
        onboardingScreen.click(onboardingScreen.nextButton);
    }
}
