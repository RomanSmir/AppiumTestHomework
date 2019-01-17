package lib;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject {
    private static final String
            TITLE = "org.wikipedia:id/view_page_title_text",
            FOOTER_ELEMENT = "//*[@text='View page in browser']",
            OPTIONS_BUTTON = "//android.widget.ImageView[@content-desc= 'More options']",
            OPTIOТNS_ADD_TO_MY_LIST_BUTTON = "//*[@text='Add to reading list']",
            ADD_TO_MY_LIST_OVERLAY = "org.wikipedia:id/onboarding_button",
            MY_LISTNAME_INPUT = "org.wikipedia:id/text_input",
            MY_LIST_OK_BUTTON = "//*[@text='OK']",
            CLOSE_ARTICLE_BUTTON = "//*[@text='OK']";


    public ArticlePageObject(AppiumDriver driver, WebDriver webDriver) {
        super(driver, webDriver);
    }

    public WebElement waitForTitleElement() {
        return this.waitForElementPresent(By.id(TITLE), "Cannot find article on page", 15);
    }

    public String getArticleTitle() {
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("text");
    }

    public void swipeToFooter() {
        this.swipeUpToFindElement(By.xpath(FOOTER_ELEMENT),
                "Cannot find swipe element",
                20
        );
    }

    public void addArticleToMyList(String name_of_folder) {
        this.waitForElementAndCliсk(
                By.xpath(OPTIONS_BUTTON),
                "cannot find button",
                5
        );
        this.waitForElementAndCliсk(
                By.xpath(OPTIOТNS_ADD_TO_MY_LIST_BUTTON),
                "cannot find option to add article to reading list",
                5
        );
        this.waitForElementAndCliсk(
                By.id(ADD_TO_MY_LIST_OVERLAY),
                "Cannot find 'got it'",
                5
        );
        this.waitForElementAndClear(
                By.id(MY_LISTNAME_INPUT),
                "Cannot find input to set name of articles folder",
                5
        );

        this.waitForElementAndSendKeys(
                By.id(MY_LISTNAME_INPUT),
                "Learning programming",
                "Cannot put text into articles folder input",
                5
        );
        this.waitForElementAndCliсk(
                By.xpath(MY_LIST_OK_BUTTON),
                "Cannot press'OK'",
                5
        );
    }

    public void closeArticle() {
        this.waitForElementAndCliсk(
                By.xpath(CLOSE_ARTICLE_BUTTON),
                "CAnnot close article, cannot find x link",
                5
        );
    }
}
