import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MainPage {
    WebDriver driver;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(name = "q")
    private WebElement searchBox;

    public void setText(String text) {
        searchBox.sendKeys(text);
        searchBox.submit();
    }


    @FindBy(xpath = "//*[@id='tsf']/div[2]/div[1]/div[3]/center/input[1]")
    private WebElement button;

    public void clickButton() {
        button.click();
    }

    @FindBy(xpath = "//*[@id='tsf']/div[2]/div[1]/div[3]/center/input[2]")
    private WebElement buttonLucky;

    public void clickButtonLucky() {
        buttonLucky.click();
    }
    //document.querySelector("#introAgreeButton");

    public void clickAgreeButton() {
        WebElement agreeButton = driver.switchTo().frame(0)
                .findElement(By.xpath("//div[@id='introAgreeButton']"));
        agreeButton.click();
    }

    @FindBy(xpath = "//a[@href='/products?category=29'")
    private WebElement selectCategory;

    public void SelectCategoryClick() {
        selectCategory.click();
    }

    @FindBy(xpath = "//h3[@class='LC20lb DKV0Md']/span")
    private List<WebElement> searchElements;

    public List<String> getAllElements() {
        List<String> allElements = new LinkedList<>();
        searchElements = searchElements.stream().filter(e -> !e.getText().isEmpty()).collect(Collectors.toList());
        searchElements.forEach(e -> allElements.add(e.getText()));
        return allElements;
    }

    @FindBy(css = "a[class='gb_4 gb_5 gb_ke gb_7c']")
    private WebElement getButton;

    public String colorButton() {
        return getButton.getCssValue("background-color");
    }

    @FindBy(css = "button[id='K273']")
    private List<WebElement> getCtrlButton;

    public WebElement getLeftButton() {
        return getCtrlButton.get(0);
    }

    public WebElement getRButton() {
        return getCtrlButton.get(1);
    }

    public void getKeyboard() {
        driver.findElement(By.cssSelector("span[class='hOoLGe']")).click();
    }

    @FindBy(css = "span[class='vk-cap vk-sf-b vk-sf-c20']")
    private WebElement buttonColorK20;

    public String colorButtonK20() {
        return buttonColorK20.getCssValue("color");
    }

    public void clickNextPage() {
        driver.findElement(By.cssSelector("a[id='pnnext']")).click();
    }
}
