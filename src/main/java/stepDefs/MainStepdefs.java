package stepDefs;

import cucumber.api.java.en.And;
import org.junit.Assert;
import steps.MainSteps;


public class MainStepdefs {

    private MainSteps mainSteps;

    public MainStepdefs(MainSteps mainSteps) {
        this.mainSteps = mainSteps;
    }

    @And("user should be logged in")
    public void userJohnShouldBeLoggedIn(String fullname) {
        mainSteps.openProfileMenu();
        Assert.assertTrue(mainSteps.userisLoggedIn(fullname));
    }

    @And("user choices an exercise")
    public void userChoicesAnExercise() {

    }
}
