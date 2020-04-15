package steps;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import screens.MainScreen;

public class MainSteps {

    private MainScreen mainScreen;

    public MainSteps(MainScreen mainScreen) {
        this.mainScreen = mainScreen;
    }

    public void openProfileMenu() {
        mainScreen.click(mainScreen.profileButton);
    }

    public boolean userisLoggedIn(String name) {
        MobileElement azaaza = mainScreen.findElements(By.xpath("//android.widget.TextView"))
                .stream()
                .filter(e -> e.getText().contains(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(name));

        return mainScreen.isElementPresentSafe(azaaza);
    }

}