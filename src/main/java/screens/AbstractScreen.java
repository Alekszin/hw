package screens;

import helpers.SwipeDirections;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.awaitility.Durations;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;

import static java.time.Duration.ofSeconds;
import static org.awaitility.Awaitility.await;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfAllElementsLocatedBy;

public class AbstractScreen {

    public static final String APP_ID = "com.easyfitness:id/";

    public AppiumDriver<? extends MobileElement> driver;

    /**
     * @param driver Platforms driver
     *               Annotation @WithTimeout(...) can override this value,
     *               but it's appended on MobileElement directly.
     */
    public AbstractScreen(AppiumDriver<? extends MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, ofSeconds(30)), this);
    }

    public void swipeInDirection(SwipeDirections direction) {
        Dimension screenSize = driver.manage().window().getSize();
        int scrollStart;
        int offset;
        int duration = 2000;
        int startx = (int) (screenSize.width * 0.5);

        switch (direction) {
            case DOWN:
                scrollStart = (int) (screenSize.height * 0.7);
                offset = (int) (screenSize.height * 0.5);
                swipe(startx, scrollStart, 0, -offset, duration);
                break;
            case UP:
                scrollStart = (int) (screenSize.height * 0.2);
                offset = (int) (screenSize.height * 0.3);
                swipe(startx, scrollStart, 0, offset, duration);
                break;
            default:
                throw new IllegalArgumentException("Direction is not allowed");
        }
    }

    private void swipe(int startX, int startY, int xOffset, int yOffset, int duration) {
        (new TouchAction(driver))
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)))
                .moveTo(PointOption.point(startX - xOffset, startY + yOffset))
                .release()
                .perform();
    }

    public boolean isElementPresentSafe(MobileElement elementName) {
        return waitForElementInTimeDuration(elementName, 30);
    }

    public boolean isElementPresentSafe(MobileElement elementName, int timeForSearch) {
        return waitForElementInTimeDuration(elementName, timeForSearch);
    }

    private boolean waitForElementInTimeDuration(MobileElement e, int waitTime) {
        try {
            FluentWait<WebDriver> wait = new FluentWait<>(driver);
            wait
                    .withTimeout(ofSeconds(waitTime))
                    .pollingEvery(Duration.ofMillis(500))
                    .ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
                    .until(elementToBeClickable(e));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public void waitAndSelectElement(MobileElement element) {
        click(element);
    }

    public void click(MobileElement element) {
        if (isElementPresentSafe(element)) {
            element.click();
        } else {
            throw new IllegalStateException(element + " not found in screen or can't be clickable");
        }
    }

    public void waitAndSetValue(MobileElement element, String text) {
        isElementPresentSafe(element);
        element.clear();
        element.setValue(text);
    }

    /**
     * @param element    willing element
     * @param timeToWait time to check element before scrolling
     */
    public void isElementVisibleInScreen(MobileElement element, int timeToWait) {
        await().atMost(Durations.FIVE_SECONDS).until(scrollUntilVisible(element, timeToWait));
    }

    private Callable<Boolean> scrollUntilVisible(MobileElement element, int timeToWait) {
        if (!isElementPresentSafe(element, timeToWait)) {
            swipeInDirection(SwipeDirections.UP);
        }
        return element::isDisplayed;
    }

    private void waitUntil(ExpectedCondition<?> until, long secondsTimeout) {
        WebDriverWait wait = new WebDriverWait(driver, secondsTimeout);
        wait
                .ignoring(StaleElementReferenceException.class, NoSuchElementException.class)
                .until(until);
    }

    public List<? extends MobileElement> findElements(By by) {
        try {
            waitUntil(presenceOfAllElementsLocatedBy(by), 30);
        } catch (TimeoutException e) {
            return Collections.emptyList();
        }
        return driver.findElements(by);
    }
}
