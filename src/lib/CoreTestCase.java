package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CoreTestCase extends TestCase {


    protected AppiumDriver androidDriver;
    protected WebDriver webDriver;
    private static String AppiumURL = "http://127.0.0.1:4723/wd/hub";
    private static String WEB_BASE_URL = "http://courier-test.softbalance.ru/courier/";

    @Override

    protected void setUp() throws Exception {
        super.setUp();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "ru.softbalance.ireca.courier.debug");
        capabilities.setCapability("appActivity", "ru.softbalance.ireca.courier.view.activity.AuthorizationActivity");
        capabilities.setCapability("app", "Users/macbook/Desktop/ireca-courier-android-debug-x86-2.5.0.0.apk");
        androidDriver = new AndroidDriver(new URL(AppiumURL), capabilities);

        System.setProperty("webdriver.chrome.driver", "/Users/macbook/Downloads/chromedriver");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get(WEB_BASE_URL);
    }

    @Override
    protected void tearDown() throws Exception {
        androidDriver.quit();
        super.tearDown();
    }

}
