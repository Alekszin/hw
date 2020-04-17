package steps;

import io.appium.java_client.MobileElement;
import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import screens.MainScreen;

@AllArgsConstructor
public class MainSteps {

    private MainScreen mainScreen;
    
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