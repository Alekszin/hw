package steps;

import screens.OnboardingScreen;

public class OnboardingSteps {

    private OnboardingScreen onboardingScreen;

    public OnboardingSteps(OnboardingScreen onboardingScreen) {
        this.onboardingScreen = onboardingScreen;
    }

    public void skipOnboarding() {
        onboardingScreen.click(onboardingScreen.nextButton);
    }
}
