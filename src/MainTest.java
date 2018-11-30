import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.List;


public class MainTest {

    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "E:\\JavaAppiumAutomation\\apks\\org.wikipedia.apk");


        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }


    @After
    public void tearDown() {
        driver.quit();
    }


//@Test
//    public void firstTest()
//{
//    waitForElementAndCliсk(
//            By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//            "Cannot findSearch Wikipedia input",
//            5
//
//    );
//
//    waitForElementAndSendKeys(
//            By.xpath("//*[contains(@text,'Search…')]"),
//            "Java",
//            "Cannot find search input",
//            10
//
//    );
//
//    waitForElementPresent(
//          By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Java (programming language)']"),
//           "Cannot find 'Java (programming language)'Java'",
//           15
//   );
//
//}
//
//@Test
//public void testCancelSearch()
//{
//    waitForElementAndCliсk(
//By.id("org.wikipedia:id/search_container"),
//    "Cannot find 'Search Wikipedia' input",
//            5
//    );
//
//waitForElementAndSendKeys(
//        By.xpath("//*[contains(@text,'Search…')]"),
//        "Java",
//        "Cannot find'Java'",
//        5
//);
//
//waitForElementAndClear(
//        By.id("org.wikipedia:id/search_src_text"),
//        "cannot find search failed",
//        5
//);
//
//    waitForElementAndCliсk(
//            By.id("org.wikipedia:id/search_close_btn"),
//            "X is still present on the page",
//            5
//
//    );
//    waitForElementNotPresent(
//            By.id("org.wikipedia:id/search_close_btn"),
//            "Cannot find x to cancel search",
//            5
//    );
//}


//  @Test
//  public void testCompareArticleTitle()
//  {
//          waitForElementAndCliсk(
//          By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//   "Cannot find 'Search Wikipedia' input",
//           5
//           );

//   waitForElementAndSendKeys(
//           By.xpath("//*[contains(@text,'Search…')]"),
//       "Java",
//               "Cannot find'Java'",
//               5
//               );

//      waitForElementAndCliсk(
//              By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Java (programming language)']"),
//              "Cannot find 'Search Wikipedia' input",
//              15
//      );
//      WebElement title_element = waitForElementPresent(
//            By.id("org.wikipedia:id/view_page_title_text"),
//              "Cannot find article title",
//              15

//              );


//      String article_title = title_element.getAttribute("text");

//      Assert.assertEquals(
//              "We see unexpected title",
//              "Java (programming language)",
//              article_title
//      );
//  }
// @Test
// public void testSearchWordsInAll()
// {
//     waitForElementAndCliсk(
//             By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//             "Cannot find 'Search Wikipedia' input",
//             5
//     );

//     waitForElementAndSendKeys(
//             By.xpath("//*[contains(@text,'Search…')]"),
//             "Java",
//             "Cannot find'Java'",
//             5
//     );


//     WebElement title_element = waitForElementPresent(
//             By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Java']"),
//             "Cannot find article title",
//             15

//     );


//     String article_title = title_element.getAttribute("text");

//     Assert.assertEquals(
//             "We see unexpected title",
//             "Java",
//             article_title
//     );
// }
//@Test
// public void testSwipeArticle() {
//    waitForElementAndCliсk(
//            By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//            "Cannot find 'Search Wikipedia' input",
//            5
//    );
//
//    waitForElementAndSendKeys(
//            By.xpath("//*[contains(@text,'Search…')]"),
//            "Appium",
//            "Cannot find'Java'",
//            5
//    );
//
//    waitForElementAndCliсk(
//            By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='Appium']"),
//            "Cannot find 'SAppium in search' input",
//            15
//    );
//    waitForElementPresent(
//            By.id("org.wikipedia:id/view_page_title_text"),
//            "Cannot find article title",
//            15
//    );
//
//    swipeUpToFindElement(
//            By.xpath("//*[@text='View page in browser']"),
//            "Test error message"
//    );
//
//
//}

//@Test
//public void saveFirstAndArticleToMyList()
//{
//    waitForElementAndCliсk(
//            By.xpath("//*[contains(@text,'Search Wikipedia')]"),
//            "Cannot find 'Search Wikipedia' input",
//            5
//    );
//    waitForElementAndSendKeys(
//            By.xpath("//*[contains(@text,'Search…')]"),
//            "Java",
//            "Cannot find'Java'",
//            5
//    );
//    waitForElementAndCliсk(
//            By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
//            "Cannot find 'SAppium in search' input",
//            15
//    );
//    waitForElementPresent(
//            By.id("org.wikipedia:id/view_page_title_text"),
//            "Cannot find article title",
//            15
//    );
//  waitForElementAndCliсk(
//          By.xpath("//android.widget.ImageView[@content-desc= 'More options']"),
//          "cannot find button",
//          5
//  );
//  waitForElementAndCliсk(
//          By.xpath("//*[@text='Add to reading list']"),
//          "cannot find option to add article to reading list",
//          5
//  );
//  waitForElementAndCliсk(
//        By.id("org.wikipedia:id/onboarding_button"),
//        "Cannot find 'got it'",
//        5
//);
//    waitForElementAndClear(
//            By.id("org.wikipedia:id/text_input"),
//            "Cannot find input to set name of articles folder",
//            5
//    );
//
//    String name_of_folder = "Learning programming";
//
//    waitForElementAndSendKeys(
//            By.id("org.wikipedia:id/text_input"),
//            "Learning programming",
//            "Cannot put text into articles folder input",
//            5
//    );
//    waitForElementAndCliсk(
//            By.xpath("//*[@text='OK']"),
//            "Cannot press'OK'",
//            5
//    );
//    waitForElementAndCliсk(
//        By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
//        "Cannot close article, cannot find X link",
//        5
//);
//    waitForElementAndCliсk(
//            By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),
//            "Cannot find 'My lists'",
//            5
//    );
//    waitForElementAndCliсk(
//            By.xpath("//*[@text='" +name_of_folder+ "']"),
//            "Cannot find created folder",
//            5
//    );
//    swipeElementToLeft(
//By.xpath("//*[@text='Learning programming']"),
//            "Cannot find saved article"
//    );
//    waitForElementNotPresent(
//            By.xpath("//*[@text='Java (programming language)']"),
//            "Cannot find saved article",
//            5
//    );
//
//}

    @Test
    public void saveFirstAndArticleToMyListеее() {
        waitForElementAndCliсk(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia' input",
                5
        );
        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search…')]"),
                "Java",
                "Cannot find'Java'",
                5
        );
        waitForElementAndCliсk(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
                "Cannot find 'SAppium in search' input",
                15
        );
        waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Cannot find article title",
                15
        );
        waitForElementAndCliсk(
                By.xpath("//android.widget.ImageView[@content-desc= 'More options']"),
                "cannot find button",
                5
        );
        waitForElementAndCliсk(
                By.xpath("//*[@text='Add to reading list']"),
                "cannot find option to add article to reading list",
                5
        );
        waitForElementAndCliсk(
                By.id("org.wikipedia:id/onboarding_button"),
                "Cannot find 'got it'",
                5
        );
        waitForElementAndClear(
                By.id("org.wikipedia:id/text_input"),
                "Cannot find input to set name of articles folder",
                5
        );
        String name_of_folder = "Learning programming";
        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/text_input"),
                "Learning programming",
                "Cannot put text into articles folder input",
                5
        );
        waitForElementAndCliсk(
                By.xpath("//*[@text='OK']"),
                "Cannot press'OK'",
                5
        );
        waitForElementAndCliсk(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot close article, cannot find X link",
                5
        );
        waitForElementAndCliсk(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia' input",
                5
        );
        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search…')]"),
                "Java",
                "Cannot find'Java'",
                5
        );
        WebElement title_elements = waitForElementAndCliсk(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='JavaScript']"),
                "Cannot find 'SAppium in search' input",
                15
        );


        waitForElementAndCliсk(
                By.xpath("//android.widget.ImageView[@content-desc= 'More options']"),
                "cannot find button",
                5
        );
        waitForElementAndCliсk(
                By.xpath("//*[@text='Add to reading list']"),
                "cannot find option to add article to reading list",
                5
        );
        waitForElementAndCliсk(
                By.xpath("//android.widget.TextView[@text='Learning programming']"),
                "Cannot find 'SAppium in search' input",
                15
        );
        waitForElementAndCliсk(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot close article, cannot find X link",
                5
        );

        waitForElementAndCliсk(
                By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),
                "Cannot find My list link",
                5
        );

        waitForElementAndCliсk(
                By.xpath("//*[@text='"+name_of_folder+"']"),
                "Cannot open link  Learn programming",
                5
        );

        swipeElementToLeft(
                By.xpath("//*[@text='Java (programming language)']"),
                "Cannot find saved article"
        );

        String title_element = title_elements.getAttribute("text");

     Assert.assertEquals(
             "We see unexpected title",
             "JavaScript",
             title_element
     );

    }
    //@Test
    //public void amountEmptySearch() //{ //waitForElementAndCliсk(
            //By.xpath("//*[contains(@text,'Search Wikipedia')]"),
            //"Cannot find 'Search Wikipedia' input",
            //5
    //);

    //String search_line = "Linkin park Diskography";
    //waitForElementAndSendKeys(
            //By.xpath("//*[contains(@text,'Search…')]"),
            //search_line,
            //"Cannot find search input",
            //5
    //);

    //String search_result_locator = "//*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']";
    //waitForElementPresent(
            //By.xpath(search_result_locator),
            //"Cannot find anything by the request " + search_line,
            //15
    //);

    //int amount_of_search_results = getAmountOfElement(
            //By.xpath(search_result_locator)
    //);

    //Assert.assertTrue(
            //"We found too few results!",
            //amount_of_search_results > 0
    //);





    }


    private WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)

        );

    }

    private WebElement waitForElementPresent(By by, String error_message) {
        return waitForElementPresent(by, error_message, 5);
    }

    private WebElement waitForElementAndCliсk(By by, String error_message, long timeoutInseconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInseconds);
        element.click();
        return element;
    }

    private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInseconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInseconds);
        element.sendKeys(value);
        return element;
    }


    private boolean waitForElementNotPresent(By by, String error_message, long timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by));
    }

    private WebElement waitForElementAndClear(By by, String error_message, long timeotInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeotInSeconds);
        element.clear();
        return element;
    }

    protected void swipeUP(int timeOfSwipe) {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.width / 2;
        int start_y = (int) (size.height * 0.8);
        int end_y = (int) (size.height * 0.2);
        action.press(x, start_y).waitAction(timeOfSwipe).moveTo(x, end_y).release().perform();
    }

    protected void swipeUpQuick() {
        swipeUP(200);
    }

    protected void swipeUpToFindElement(By by, String error_message) {
        while (driver.findElements(by).size() == 0) {
            swipeUpQuick();
        }
    }

    protected void swipeElementToLeft(By by, String error_message) {
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

    private int getAmountOfElement(By by)
    {
        List elements = driver.findElements(by);
        return elements.size();
    }
}
