package lib;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class NavigationUI extends MainPageObject {

    private static final String MY_LIST_LINK = "//android.widget.FrameLayout[@content-desc='My lists']";

    public NavigationUI(AppiumDriver driver, WebDriver webDriver) {
        super(driver, webDriver);
    }

    public void clickMyList() {
        this.waitForElementAndCliсk(
                By.xpath(MY_LIST_LINK),
                "Cannot find navigation button to 'My lists'",
                5
        );
    }
}
