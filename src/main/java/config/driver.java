package config;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;


public class driver {


    private AndroidDriver driver;


    @Before
    public void setUp() throws Exception {
        //To create an object of Desired Capabilities
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability(CapabilityType.VERSION, " 7.0.0");
        capability.setCapability("app", "/Users/aleksz/fit.apk");
        capability.setCapability("deviceName", "J7");
        capability.setCapability("platformName", "Android");
        capability.setCapability("reset", true);
        capability.setCapability("appPackage", "com.easyfitness");
        capability.setCapability("appActivity", "com.easyfitness.MainActivity");
        capability.setCapability("udid", "5200de67be759423");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4111/wd/hub"), capability);
    }

    @After
    public void afterScenario() {
        driver.closeApp();
    }
}