package steps;

import lombok.AllArgsConstructor;
import screens.OnboardingScreen;
import screens.RegistrationScreen;

import java.util.stream.IntStream;

@AllArgsConstructor
public class OnboardingSteps {

    private OnboardingScreen onboardingScreen;
    private RegistrationScreen registrationScreen;

    public void skipOnboarding() {

        if (!onboardingScreen.isElementPresentSafe(registrationScreen.fullnameField, 30)) {
            IntStream.range(0, 5)
                    .forEach(index -> onboardingScreen.nextButton.click());
        }
        onboardingScreen.click(onboardingScreen.nextButton);
    }
}
