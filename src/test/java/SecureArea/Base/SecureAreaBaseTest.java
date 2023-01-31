package SecureArea.Base;

import HerokuApp.HerokuPages.HerokuHomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class SecureAreaBaseTest {

    public WebDriver driver;
    public WebDriverWait wdwait;

    public HerokuHomePage homePage;

    @BeforeClass
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @AfterClass
    public void tearDown() {

       // driver.quit();

    }

}
