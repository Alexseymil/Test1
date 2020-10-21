import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.logging.Logger;

public class TestSearchTask1 {

    private WebDriver driver;
    private Utils utils;

    {
        utils = new Utils();
    }

    static Logger log = Logger.getLogger(TestSearchTask1.class.getName());

    TestSearchTask1(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(name = "q")
    private WebElement searchBox;

    public void seachTest(String text) {
        searchBox.sendKeys(text);
        searchBox.submit();
    }

    public void clickNextPage() {
        driver.findElement(By.cssSelector("a[id='pnnext']")).click();
    }

    @FindBy(css = "span[class='SJajHc NVbCr']")
    private List<WebElement> pages;

    public void clickPages(int page) {
        if (page <= 2) throw new IllegalArgumentException("Not actual page");
        pages.get(page - 2).click();
    }

    @FindBy(css = "div[id='result-stats']")
    private WebElement resStats;

    public int getResStat() {
        int resStat = utils.getIntInStr(resStats.getText());
        log.info("Result " + resStat);
        return resStat;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

//
//    @FindBy(xpath = "//div[@class='yuRUbf']/a")
//    private List<WebElement> searchElements;

    public boolean clickTrueUrlOnPage(String text) {

        driver.findElements(By.xpath("//div[@class='yuRUbf']/a")).stream()
                .filter(webElement -> {
                    log.info("Real URL: " + utils.formatUrl(webElement.getAttribute("href")));
                    return text.equals(utils.formatUrl(webElement.getAttribute("href")));
                })
                .findFirst()
                .orElseThrow(RuntimeException::new)
                .click();

//        String strAct;
//        for (WebElement webElement : searchElements) {
//            strAct = webElement.getAttribute("href");
//            log.info("href " + strAct);
//            try {
//                strAct = utils.formatUrl(strAct);
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            }
//            if (strAct.equals(text)) {
//                webElement.click();
//                log.info("True href " + strAct);
//                return true;
//            }
//        }
        return true;

    }

    public boolean isLogoERD() {
        boolean isDisplayed = driver.findElement(By.xpath(".//img[@alt='ERDPlus logo']")).isDisplayed();
        log.info("isDisplayed " + isDisplayed);
        return isDisplayed;
    }

    public boolean isBackgroundColor() {
        WebElement colorElement = driver.findElement(By.xpath(".//header[@class='jss174 jss180 jss165 jss169 jss172']"));
        String color = colorElement.getCssValue("background-color");
        log.info("Color " + color);
        return color.equals("rgba(83, 109, 254, 1)");
    }

    public boolean isDataValid() {
        WebElement dateElement = driver.findElement(By.xpath(".//span[@class='jss110 jss120']"));
        String date = dateElement.getText();
        date = utils.dateFormat(date);
        log.info("Date " + date);
        return "2020-05-24".equals(date);
    }

    //xpath contains text .//*[contains(text(), 'Feedback')]

}
