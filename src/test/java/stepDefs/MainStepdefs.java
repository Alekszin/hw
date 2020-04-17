package stepDefs;

import io.cucumber.java.en.And;
import lombok.AllArgsConstructor;
import org.junit.Assert;
import steps.MainSteps;


@AllArgsConstructor
public class MainStepdefs {

    private MainSteps mainSteps;

    @And("user should be logged in")
    public void userJohnShouldBeLoggedIn(String fullname) {
        mainSteps.openProfileMenu();
        Assert.assertTrue(mainSteps.userisLoggedIn(fullname));
    }

    @And("user choices an exercise")
    public void userChoicesAnExercise() {

    }
}
