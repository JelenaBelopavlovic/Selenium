package DemoQA.DemoQABase.DemoQABase;/* package DemoQABase;

import DemoQA.DemoQAPages.HomePage;
import DemoQA.DemoQAPages.SidebarPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class DemoQABaseTest {
    public WebDriver driver;
    public WebDriverWait wdwait;
    public HomePage homePage;
    public SidebarPage sidebarPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Kada smo pokrenuli test, u konzoli je pisalo Interseption, jer driver nije fizicki video
    // Bookstore polje, zato uvodimo skroll.

    // Ponekad treba refres ili cak dva refresa pre skrola, da bi funkcionisalo.

    // U base klasi smestamo pomocne metode.
    // Za skrol:

    public void scrollIntoView(WebElement element) { // ovde cemo proslediti na koji element se odnosi skrol
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element); // i ovde,
                                                                                    // na kraju u zagradi
    }
    //Pomocne metode za cekanje; prosledimo im ovde da se odnose na web elemente,
    // a u test klasi na koji tacno (tj. ime web elementa)

    public void waitForVisibility(WebElement element) {
        wdwait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForClickability(WebElement element) {
        wdwait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Metoda za vidljivost elementa ne funkcioise na ovaj nacin, nego preko anotacija.. to cemo sutra..

    public boolean elementIsDisplayed() {

    boolean displayed = false;
    try {
    displayed = element.isDIsplayed;

    } catch (Exception e) {


    }
    return displayed;


    }


} */
