package HerokuApp.HerokuBase;

import HerokuApp.HerokuPages.HerokuCheckboxesPage;
import HerokuApp.HerokuPages.HerokuHomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class HerokuBaseTest {

    public static WebDriver driver;
    public WebDriverWait wdwait;

    public ExcelReader3 excelReader3;  // Ne zaboravi da inicijalizujes Excel reader i homeURL
    public String homeURL;
    public HerokuHomePage herokuHomePage;
    public HerokuCheckboxesPage herokuCheckboxesPage;


    // inicijalizovati stranice


    @BeforeClass
    public void setUp() throws IOException {

        WebDriverManager.chromedriver().setup();

        excelReader3 = new ExcelReader3("C:\\Users\\Administrator\\Desktop\\HerokuData.xlsx");

        homeURL = excelReader3.getStringData("URL", 1, 0);

    }


    @AfterClass
    public void tearDown() {

      //  driver.quit();

    }






}
