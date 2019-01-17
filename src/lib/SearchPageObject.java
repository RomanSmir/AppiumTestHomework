package lib;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPageObject extends MainPageObject {

    private static final String
            SEARCH_INIT_ELEMENT = "//*[@resource-id='ru.softbalance.ireca.courier.debug:id/access_key']",
            SEARCH_INIT_ELEMENT1 = "//*[@resource-id='ru.softbalance.ireca.courier.debug:id/password']",
            SEARCH_INIT_ELEMENT2 = "//*[@resource-id='ru.softbalance.ireca.courier.debug:id/password_layout']",
            SEARCH_INPUT = "//*[contains(@text,'Access key')]",
            SEARCH_INPUT1 = "//*[contains(@text,'Password')]",
            SEARCH_INPUT2 = "//*[contains(@text,'Access code')]",
            SEARCH_CANCEL_BUTTON = "org.wikipedia:id/search_close_btn",
            SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='{SUBSTRING}']",
            SEARCH_BUTTON_CONNECT = "//*[@text='CONNECT']",
            SEARCH_BUTTON_CONNECT1 = "//android.widget.ImageView[@resource-id='ru.softbalance.ireca.courier.debug:id/confirm']",
            SEARCH_BUTTON_ALLOW = "//android.widget.Button[@text='ALLOW']",
            SEARCH_ELEMENT_PAGE = "//*[@resource-id='com.android.packageinstaller:id/permission_allow_button']",
            SEARCH_ELEMENT_PAGE1 = "//android.widget.TextView[@text='orders']";


    public SearchPageObject(AppiumDriver driver, WebDriver webDriver) {
        super(driver, webDriver);
    }

    /*TEMPLATE METHOD*/
    private static String getResultSearchElement(String substring) {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);

    }
    /*TEMPLATE METHOD*/

    public void initSearchInput() {
        this.waitForElementAndCliсk(By.xpath(SEARCH_INIT_ELEMENT), "Cannot find and clic search init element", 10);
        this.waitForElementPresent(By.xpath(SEARCH_INIT_ELEMENT), "Cannot find search input cliking search init element");
    }

    public void initSearchInput1() {
        this.waitForElementAndCliсk(By.xpath(SEARCH_INIT_ELEMENT1), "Cannot find and clic search init element", 10);
        this.waitForElementPresent(By.xpath(SEARCH_INIT_ELEMENT1), "Cannot find search input cliking search init element");
    }

    public void initSearchInput2() {
        this.waitForElementAndCliсk(By.xpath(SEARCH_INIT_ELEMENT2), "Cannot find and clic search init element", 10);
        this.waitForElementPresent(By.xpath(SEARCH_INIT_ELEMENT2), "Cannot find search input cliking search init element");
    }

    public void clickAndWaitButton(String clickElement,String waitElement) {
        this.waitForElementAndCliсk(By.xpath(clickElement), "cannot find connect button", 5);
        this.waitForElementPresent(By.xpath(waitElement), "cannot find Acsess code", 10);
    }

    public void clickButton() {
        this.waitForElementAndCliсk(By.xpath(SEARCH_BUTTON_CONNECT), "cannot find connect button", 5);
        this.waitForElementPresent(By.xpath(SEARCH_INPUT2), "cannot find Acsess code", 15);
    }

    public void clickButton1() {
        this.waitForElementAndCliсk(By.xpath(SEARCH_BUTTON_CONNECT1), "cannot find connect button", 15);
       // this.waitForElementPresent(By.xpath(SEARCH_ELEMENT_PAGE),"cannot find Acsess code", 15);
    }

    public void clickButton2() {
        this.waitForElementAndCliсk(By.xpath(SEARCH_BUTTON_ALLOW), "cannot find allow button", 15);
        this.waitForElementPresent(By.xpath(SEARCH_ELEMENT_PAGE1),"cannot find order code", 15);
    }

    public void waitForCancelButtonToAppear() {
        this.waitForElementPresent(By.id(SEARCH_CANCEL_BUTTON), "Cannot find search cancel button", 10);
    }

    public void waitForCancelButtonToDisAppear() {
        this.waitForElementPresent(By.id(SEARCH_CANCEL_BUTTON), "Search cancel button is still present", 10);
    }

    public void clickCancelSearch() {
        this.waitForElementPresent(By.xpath(SEARCH_CANCEL_BUTTON), "Cannot find search cancel button", 5);
    }

    public void typeSearchLine(String search_line) {
        this.waitForElementAndSendKeys(By.xpath(SEARCH_INPUT), search_line, "Cannot find and type into search input", 5);
    }

    public void typeSearchLine1(String search_line1) {
        this.waitForElementAndSendKeys(By.xpath(SEARCH_INPUT1), search_line1, "Cannot find and type into search input1", 5);
    }

    public void typeSearchLine2(String search_line2) {
        this.waitForElementAndSendKeys(By.xpath(SEARCH_INPUT2), search_line2, "Cannot find and type into search input2", 5);
    }

    public void waitForSearchResult(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(By.xpath(search_result_xpath), "Cannot find search result with substring" + substring);
    }

    public void clickByArticleWithSubstring(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndCliсk(By.xpath(search_result_xpath), "Cannot find and click search result with substring" + substring, 10);
    }

    public void loginCourier() {
        //this.waitForElementAndCliсk(By.xpath(SEARCH_INIT_ELEMENT),"cannon find Acsess fild",10);
        this.waitForElementAndSendKeys(By.xpath(SEARCH_INIT_ELEMENT), "", "cannot find fild acsess", 10);

    }

}
