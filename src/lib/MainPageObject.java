package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPageObject {
    protected AppiumDriver driver;
    protected WebDriver webDriver;

    public MainPageObject(AppiumDriver driver, WebDriver webDriver)
    {
        this.driver = driver;
        this.webDriver = webDriver;
    }

    public WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)

        );

    }

    public WebElement waitForElementPresent(By by, String error_message) {
        return waitForElementPresent(by, error_message, 5);
    }

    public WebElement waitForElementAndCliсk(By by, String error_message, long timeoutInseconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInseconds);
        element.click();
        return element;
    }

    public WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInseconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInseconds);
        element.sendKeys(value);
        return element;
    }


    public boolean waitForElementNotPresent(By by, String error_message, long timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public WebElement waitForElementAndClear(By by, String error_message, long timeotInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeotInSeconds);
        element.clear();
        return element;
    }

    public void swipeUP(int timeOfSwipe) {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.width / 2;
        int start_y = (int) (size.height * 0.8);
        int end_y = (int) (size.height * 0.2);
        action.press(x, start_y).waitAction(timeOfSwipe).moveTo(x, end_y).release().perform();
    }

    public void swipeUpQuick() {
        swipeUP(200);
    }

    public void swipeUpToFindElement(By by, String error_message, int ma_swipe) {
        while (driver.findElements(by).size() == 0) {
            swipeUpQuick();
        }
    }

    public void swipeElementToLeft(By by, String error_message) {
        WebElement element = waitForElementPresent(
                by,
                error_message,
                10);

        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y) / 2;

        TouchAction action = new TouchAction(driver);
        action
                .press(right_x, middle_y)
                .waitAction(300)
                .moveTo(left_x, middle_y)
                .release()
                .perform();
    }

    public int getAmountOfElement(By by) {
        List elements = driver.findElements(by);
        return elements.size();
    }

    public void assertElementPresent(By by, String error_message) {
        int element_title = getAmountOfElement(by);
        if (element_title == 1) {
            String default_message = "'An element '" + by.toString() + "'suporrst not present";
            throw new AssertionError(default_message + " " + error_message);
        }

    }

    public void LoginCourierWeb(By by, String error_message, long timeOutInSeconds) {
        WebElement emailKey = webDriver.findElement(By.id("UserLogin_username"));
        WebElement pswrdKey = webDriver.findElement(By.id("UserLogin_password"));
        WebElement loginBtKey = webDriver.findElement(By.xpath("//button[text()='Войти']"));
        emailKey.sendKeys("rsmirnovv+112233@yandex.ru");
        pswrdKey.sendKeys("203809");
        loginBtKey.click();
    }
}
