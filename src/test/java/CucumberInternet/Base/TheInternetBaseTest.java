package CucumberInternet.Base;

import Domaci6TheInternetPOMdva.Pages.TheInternetLogInPage;
import Domaci6TheInternetPOMdva.Pages.TheInternetLogOutPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TheInternetBaseTest {


    public static WebDriver driver;
    public WebDriverWait wdwait;

    public TheInternetLogOutPage theInternetLogOutPage;

    public TheInternetLogInPage theInternetLogInPage;

    @BeforeClass
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver.get("https://the-internet.herokuapp.com/login");
        theInternetLogInPage = new TheInternetLogInPage();
        theInternetLogOutPage = new TheInternetLogOutPage();

    }

    @AfterClass
    public void tearDown() {

      //  driver.quit();

    }
}
