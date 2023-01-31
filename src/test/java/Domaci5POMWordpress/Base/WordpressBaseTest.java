package Domaci5POMWordpress.Base;

import Domaci5POMWordpress.Pages.WordpressHomePage;
import Domaci5POMWordpress.Pages.WordpressLogInPage;
import Domaci5POMWordpress.Pages.WordpressProfilePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class WordpressBaseTest {

    //Ulogovati se na wordpress i proveriti da li smo ulogovani

public WebDriver driver;
public WebDriverWait wdwait;

public WordpressHomePage wordpressHomePage;
public WordpressLogInPage wordpressLogInPage;
public WordpressProfilePage wordpressProfilePage;



    @BeforeClass
    public void setupPage() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wordpressHomePage = new WordpressHomePage(driver, wdwait);
        wordpressLogInPage = new WordpressLogInPage(driver, wdwait);
        wordpressProfilePage = new WordpressProfilePage(driver, wdwait);

    }

    @AfterClass
    public void tearDown() {

      driver.manage().deleteAllCookies();
      driver.quit();

    }


}
