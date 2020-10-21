import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GoogleSearch {

    public static WebDriver driver;
    public static MainPage mainPage;
    public static TestSearchTask1 testSearchTask1;


    @BeforeClass
    public static void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        mainPage = new MainPage(driver);
        testSearchTask1 = new TestSearchTask1(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    //New test
    @Test
    public void openGoogle() throws InterruptedException {
        Assert.assertEquals(testSearchTask1.getUrl(), "https://www.google.com/", "Url is not valid");
        mainPage.clickAgreeButton();
        testSearchTask1.seachTest("sql table online");
        Assert.assertTrue(testSearchTask1.getResStat() > 11000000, "Not true result");
        testSearchTask1.clickPages(3);
        Assert.assertTrue(testSearchTask1.clickTrueUrlOnPage("erdplus.com"));
        Assert.assertTrue(testSearchTask1.isLogoERD());
        Assert.assertTrue(testSearchTask1.isBackgroundColor());
        Thread.sleep(900);
        Assert.assertTrue(testSearchTask1.isDataValid());
    }


//    @Test
//    public void getColorAndKeys() throws InterruptedException {
//
//        mainPage.getKeyboard();
//        System.out.println("color button K20 " + mainPage.colorButtonK20());
//        System.out.println("left " + mainPage.getLeftButton().getText());
//        System.out.println("ctrl " + mainPage.getRButton().getText());
//        Thread.sleep(5000);
//
//    }
//
//    @Test
//    public void getPositionSearch() throws InterruptedException {
//        mainPage.setText("ChromeDriver");
//        List<String> strElements = mainPage.getAllElements();
//
//        int position = 0;
//
//        for (String strElement : strElements) {
//            position += 1;
//            System.out.println(strElement);
//            if (strElement.equals("ChromeDriver - GitHub")) {
//                System.out.println("element true" + "position " + position);
//                // Assert.assertEquals(4, position, "not actual position");
//                Assert.assertTrue(position < 10, "not equal");
//                break;
//            }
//        }
//        System.out.println("color " + mainPage.colorButton());
//        mainPage.clickNextPage();
//        Thread.sleep(5000);
//    }

    @AfterClass
    public static void closeDriver() {
        driver.close();
        driver.quit();
    }
}
