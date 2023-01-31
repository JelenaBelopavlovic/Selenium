package Domaci6TheInternetPOMdva.Base;

import Domaci6TheInternetPOMdva.Pages.TheInternetLogOutPage;
import Domaci6TheInternetPOMdva.Pages.TheInternetLogInPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class TheInternetBaseTest {

    // Dodati sto vise kejseva u poslednjem zadatku sa casa.

    public static WebDriver driver;
    public WebDriverWait wdwait;

    public ExcelReader2 excelReader2;
    public String homeURL;

    public TheInternetLogOutPage theInternetLogOutPage;

    public TheInternetLogInPage theInternetLogInPage;

    @BeforeClass
    public void setUp() throws IOException {

        WebDriverManager.chromedriver().setup();

        excelReader2 = new ExcelReader2("C:\\Users\\Administrator\\Desktop\\TestData2.xlsx");

        homeURL = excelReader2.getStringData("URL", 1,0);

    }

    @AfterClass
    public void tearDown() {

      driver.quit();

    }
}
