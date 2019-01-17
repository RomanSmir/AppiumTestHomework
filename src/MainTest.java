import com.gargoylesoftware.htmlunit.WebWindow;
import com.sun.tools.javac.comp.Enter;
import lib.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class MainTest extends CoreTestCase {

    private MainPageObject MainPageObject;


    protected void setUp() throws Exception {
        super.setUp();

        MainPageObject = new MainPageObject(androidDriver, webDriver);

    }

    @Test
    public void testAcsessCourierWeb() {
        SearchPageObject SearchPageObject = new SearchPageObject(androidDriver, webDriver);
        SearchPageObject.loginCourier();
    }


    @Test
    public void testLoginCourierWeb() {
        WebElement emailKey = webDriver.findElement(By.id("UserLogin_username"));
        WebElement pswrdKey = webDriver.findElement(By.id("UserLogin_password"));
        WebElement loginBtKey = webDriver.findElement(By.xpath("//button[text()='Войти']"));
        emailKey.sendKeys("rsmirnovv+112233@yandex.ru");
        pswrdKey.sendKeys("203809");
        loginBtKey.click();
    }


    @Test
    public void testCreateOrderWeb() {
        testLoginCourierWeb();
        WebElement addBtKey = webDriver.findElement(By.xpath("//a[contains(text(),'Добавить')]"));
        addBtKey.click();
        WebElement phoneNumber = webDriver.findElement(By.id("Order_phone"));
        phoneNumber.click();
        phoneNumber.sendKeys("89818236205");
        WebElement streetName = webDriver.findElement(By.id("Order_address_to_street"));
        streetName.click();
        streetName.sendKeys("Лубянка");
        WebElement streetNumber = webDriver.findElement(By.id("Order_address_to_home"));
        streetNumber.click();
        streetNumber.sendKeys("1");
        WebElement paymentType = webDriver.findElement(By.id("payment-type-js"));
        paymentType.click();
        paymentType.sendKeys("нал");
        WebElement dateFirst = webDriver.findElement(By.id("Order_started_at"));
        dateFirst.click();
        dateFirst.clear();
        dateFirst.sendKeys("7.01.2019 18:00");
        WebElement dateSecond = webDriver.findElement(By.id("Order_finished_at"));
        dateSecond.click();
        dateSecond.clear();
        dateSecond.sendKeys("7.01.2019 20:00");
        WebElement ss = webDriver.findElement(By.id("select2-order_items_0_value-container"));
        ss.click();
        WebElement sss = webDriver.findElement(By.xpath("/html/body/span[4]/span/span[1]/input"));
        sss.sendKeys("Трактиръ Head-Office");
        sss.sendKeys(Keys.ENTER);
        WebElement calcOrder = webDriver.findElement(By.id("calcOrder"));
        calcOrder.click();
        WebElement creatOrder = webDriver.findElement(By.id("ceateOrder"));
        creatOrder.click();
        WebElement formOrder = webDriver.findElement(By.xpath("//a[contains(text(),'Сформирован')]"));
        formOrder.click();
        WebElement selectt = webDriver.findElement(By.cssSelector("select.form-control.input-sm"));
        selectt.click();
       Select dropdown = new Select(webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div/div[2]/div/table/tbody/tr[1]/td[7]/span/div/div[2]/div/form/div/div[1]/div[1]/select")));
       dropdown.selectByVisibleText("Подготовлен");
       WebElement vButton = webDriver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div/div[2]/div/table/tbody/tr[1]/td[7]/span/div/div[2]/div/form/div/div[1]/div[2]/button[1]"));
         vButton.click();
    }


    @Test
    public void testSearch() {
        SearchPageObject searchPageObject = new SearchPageObject(androidDriver, webDriver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("202708");
        searchPageObject.initSearchInput1();
        searchPageObject.typeSearchLine1("15573");
        searchPageObject.clickButton();
        searchPageObject.initSearchInput2();
        searchPageObject.typeSearchLine2("2222");
        searchPageObject.clickButton1();
        searchPageObject.clickButton2();
        WebElement order = androidDriver.findElement(By.id("//*[@resource-id='ru.softbalance.ireca.courier.debug:id/text_address']"));
        order.click();


    }

 //  @Test
 //  public void testCancelSearch() {
 //      SearchPageObject SearchPageObject = new SearchPageObject(androidDriver, webDriver);
 //      SearchPageObject.initSearchInput();
 //      SearchPageObject.typeSearchLine("Java");
 //      SearchPageObject.waitForCancelButtonToAppear();
 //      SearchPageObject.clickCancelSearch();
 //      SearchPageObject.waitForCancelButtonToDisAppear();
 //  }


 //  @Test
 //  public void testCompareArticleTitle() {
 //      ArticlePageObject ArcticlePageObject = new ArticlePageObject(androidDriver, webDriver);
 //      String article_title = ArcticlePageObject.getArticleTitle();

 //      Assert.assertEquals(
 //              "We see unexpected title",
 //              "Java (programming language)",
 //              article_title
 //      );
 //  }

 //  @Test
 //  public void testSearchWordsInAll() {
 //      MainPageObject.waitForElementAndCliсk(
 //              By.xpath("//*[contains(@text,'Search Wikipedia')]"),
 //              "Cannot find 'Search Wikipedia' input",
 //              5
 //      );

 //      MainPageObject.waitForElementAndSendKeys(
 //              By.xpath("//*[contains(@text,'Search…')]"),
 //              "Java",
 //              "Cannot find'Java'",
 //              5
 //      );


 //      WebElement title_element = MainPageObject.waitForElementPresent(
 //              By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Java']"),
 //              "Cannot find article title",
 //              15

 //      );


 //      String article_title = title_element.getAttribute("text");

 //      Assert.assertEquals(
 //              "We see unexpected title",
 //              "Java",
 //              article_title
 //      );
 //  }

 //  @Test
 //  public void testSwipeArticle() {

 //      SearchPageObject SearchPageObject = new SearchPageObject(androidDriver, webDriver);
 //      SearchPageObject.initSearchInput();
 //      SearchPageObject.typeSearchLine("Appium");
 //      SearchPageObject.clickByArticleWithSubstring("Appium");

 //      ArticlePageObject ArticlePageObject = new ArticlePageObject(androidDriver, webDriver);
 //      ArticlePageObject.waitForTitleElement();
 //      ArticlePageObject.swipeToFooter();

 //  }

 //  @Test
 //  public void saveFirstAndArticleToMyList() {
 //      SearchPageObject SearchPageObject = new SearchPageObject(androidDriver, webDriver);
 //      SearchPageObject.initSearchInput();
 //      SearchPageObject.typeSearchLine("Java");
 //      SearchPageObject.clickByArticleWithSubstring("Object-oriented programing language");

 //      ArticlePageObject ArticlePageObject = new ArticlePageObject(androidDriver, webDriver);
 //      ArticlePageObject.waitForTitleElement();
 //      String article_title = ArticlePageObject.getArticleTitle();
 //      String name_of_folder = "Learning programing";
 //      ArticlePageObject.addArticleToMyList(name_of_folder);
 //      ArticlePageObject.closeArticle();

 //      NavigationUI NavigationUI = new NavigationUI(androidDriver, webDriver);
 //      NavigationUI.clickMyList();

 //      MyListPageObject MyListPageObject = new MyListPageObject(androidDriver, webDriver);
 //      MyListPageObject.openFolderByName(name_of_folder);


 //      MainPageObject.waitForElementAndCliсk(
 //              By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
 //              "Cannot close article, cannot find X link",
 //              5
 //      );
 //      MainPageObject.waitForElementAndCliсk(
 //              By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),
 //              "Cannot find 'My lists'",
 //              5
 //      );
 //      MainPageObject.waitForElementAndCliсk(
 //              By.xpath("//*[@text='" + name_of_folder + "']"),
 //              "Cannot find created folder",
 //              5
 //      );
 //      MainPageObject.swipeElementToLeft(
 //              By.xpath("//*[@text='Learning programming']"),
 //              "Cannot find saved article"
 //      );
 //      MainPageObject.waitForElementNotPresent(
 //              By.xpath("//*[@text='Java (programming language)']"),
 //              "Cannot find saved article",
 //              5
 //      );

 //  }

 //  @Test
 //  public void testSaveFirstAndArticleToMyListеее() {

 //      SearchPageObject SearchPageObject = new SearchPageObject(androidDriver, webDriver);
 //      SearchPageObject.initSearchInput();
 //      SearchPageObject.typeSearchLine("Java");
 //      SearchPageObject.waitForSearchResult("Object-oriented programing language");

 //      ArticlePageObject ArticlePageObject = new ArticlePageObject(androidDriver, webDriver);
 //      ArticlePageObject.waitForTitleElement();
 //      String article_title = ArticlePageObject.getArticleTitle();


 //      MainPageObject.waitForElementAndCliсk(
 //              By.xpath("//*[contains(@text,'Search Wikipedia')]"),
 //              "Cannot find 'Search Wikipedia' input",
 //              5
 //      );
 //      MainPageObject.waitForElementAndSendKeys(
 //              By.xpath("//*[contains(@text,'Search…')]"),
 //              "Java",
 //              "Cannot find'Java'",
 //              5
 //      );
 //      MainPageObject.waitForElementAndCliсk(
 //              By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
 //              "Cannot find 'SAppium in search' input",
 //              15
 //      );
 //      MainPageObject.waitForElementPresent(
 //              By.id("org.wikipedia:id/view_page_title_text"),
 //              "Cannot find article title",
 //              15
 //      );
 //      MainPageObject.waitForElementAndCliсk(
 //              By.xpath("//android.widget.ImageView[@content-desc= 'More options']"),
 //              "cannot find button",
 //              5
 //      );
 //      MainPageObject.waitForElementAndCliсk(
 //              By.xpath("//*[@text='Add to reading list']"),
 //              "cannot find option to add article to reading list",
 //              5
 //      );
 //      MainPageObject.waitForElementAndCliсk(
 //              By.id("org.wikipedia:id/onboarding_button"),
 //              "Cannot find 'got it'",
 //              5
 //      );
 //      MainPageObject.waitForElementAndClear(
 //              By.id("org.wikipedia:id/text_input"),
 //              "Cannot find input to set name of articles folder",
 //              5
 //      );
 //      String name_of_folder = "Learning programming";
 //      MainPageObject.waitForElementAndSendKeys(
 //              By.id("org.wikipedia:id/text_input"),
 //              "Learning programming",
 //              "Cannot put text into articles folder input",
 //              5
 //      );
 //      MainPageObject.waitForElementAndCliсk(
 //              By.xpath("//*[@text='OK']"),
 //              "Cannot press'OK'",
 //              5
 //      );
 //      MainPageObject.waitForElementAndCliсk(
 //              By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
 //              "Cannot close article, cannot find X link",
 //              5
 //      );
 //      MainPageObject.waitForElementAndCliсk(
 //              By.xpath("//*[contains(@text,'Search Wikipedia')]"),
 //              "Cannot find 'Search Wikipedia' input",
 //              5
 //      );
 //      MainPageObject.waitForElementAndSendKeys(
 //              By.xpath("//*[contains(@text,'Search…')]"),
 //              "Java",
 //              "Cannot find'Java'",
 //              5
 //      );
 //      WebElement title_elements = MainPageObject.waitForElementAndCliсk(
 //              By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='JavaScript']"),
 //              "Cannot find 'SAppium in search' input",
 //              15
 //      );


 //      MainPageObject.waitForElementAndCliсk(
 //              By.xpath("//android.widget.ImageView[@content-desc= 'More options']"),
 //              "cannot find button",
 //              5
 //      );
 //      MainPageObject.waitForElementAndCliсk(
 //              By.xpath("//*[@text='Add to reading list']"),
 //              "cannot find option to add article to reading list",
 //              5
 //      );
 //      MainPageObject.waitForElementAndCliсk(
 //              By.xpath("//android.widget.TextView[@text='Learning programming']"),
 //              "Cannot find 'SAppium in search' input",
 //              15
 //      );
 //      MainPageObject.waitForElementAndCliсk(
 //              By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
 //              "Cannot close article, cannot find X link",
 //              5
 //      );

 //      MainPageObject.waitForElementAndCliсk(
 //              By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),
 //              "Cannot find My list link",
 //              5
 //      );

 //      MainPageObject.waitForElementAndCliсk(
 //              By.xpath("//*[@text='" + name_of_folder + "']"),
 //              "Cannot open link  Learn programming",
 //              5
 //      );

 //      MainPageObject.swipeElementToLeft(
 //              By.xpath("//*[@text='Java (programming language)']"),
 //              "Cannot find saved article"
 //      );

 //      String title_element = title_elements.getAttribute("text");

 //      Assert.assertEquals(
 //              "We see unexpected title",
 //              "JavaScript",
 //              title_element
 //      );

 //  }
///  @Test
///  public void amountEmptySearch() //{ //waitForElementAndCliсk(
///  By.xpath("//*[contains(@text,'Search Wikipedia')]"),
///  "Cannot find 'Search Wikipedia' input",
///  5
///  );

///  String search_line = "Linkin park Diskography";
///  waitForElementAndSendKeys(
///  By.xpath("//*[contains(@text,'Search…')]"),
///  search_line,
///  "Cannot find search input",
///  5
///  );

///  String search_result_locator = "//*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']";
///  waitForElementPresent(
///  By.xpath(search_result_locator),
///  "Cannot find anything by the request " + search_line,
///  15
///  );

///  int amount_of_search_results = getAmountOfElement(
///  By.xpath(search_result_locator)
///  );

///  Assert.assertTrue(
///  "We found too few results!",
///  amount_of_search_results > 0
///  );

///   }


 //  @Test

 //  public void testAmountOfEmptySearch() {
 //      MainPageObject.waitForElementAndCliсk(
 //              By.xpath("//*[contains(@text,'Search Wikipedia')]"),
 //              "Cannot find 'Search Wikipedia' input",
 //              5
 //      );

 //      String search_line = "Linkin park Diskography";
 //      MainPageObject.waitForElementAndSendKeys(
 //              By.xpath("//*[contains(@text,'Search…')]"),
 //              search_line,
 //              "Cannot find search input",
 //              5
 //      );
 //  }

 //  @Test

 //  public void assertTitle() {

 //      MainPageObject.waitForElementAndCliсk(
 //              By.xpath("//*[contains(@text,'Search Wikipedia')]"),
 //              "Cannot find 'Search Wikipedia' input",
 //              5
 //      );
 //      MainPageObject.waitForElementAndSendKeys(
 //              By.xpath("//*[contains(@text,'Search…')]"),
 //              "Java",
 //              "Cannot find'Java'",
 //              5
 //      );
 //      MainPageObject.waitForElementAndCliсk(
 //              By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
 //              "Cannot find 'SAppium in search' input",
 //              15
 //      );

 //      MainPageObject.assertElementPresent(
 //              By.xpath("//*[@resource-id='org.wikipedia:id/view_page_title_text']//*[@text='Object-oriented programming language']"),
 //              "cannot find element present"
 //      );

 //  }


}