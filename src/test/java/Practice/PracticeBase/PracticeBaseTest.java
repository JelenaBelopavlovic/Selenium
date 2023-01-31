/* package Practice.PracticeBase;

import PracticePages.PracticeLoginPage;
import PracticePages.PracticePracticePage;
import PracticePages.PracticeProfilePage;
import PracticePages.PracticeSidebarPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;


    public class PracticeBaseTest {
        public WebDriver driver;
        public WebDriverWait wdwait;
        public PracticeSidebarPage practiceSidebarPage;
        public PracticePracticePage practicePracticePage;
        public PracticeLoginPage practiceLoginPage;
        public PracticeProfilePage practiceProfilePage;

        @BeforeClass
        public void setUp() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
            practiceSidebarPage = new PracticeSidebarPage(driver, wdwait);
            practicePracticePage = new PracticePracticePage(driver, wdwait);
            practiceLoginPage = new PracticeLoginPage(driver, wdwait);
            practiceProfilePage = new PracticeProfilePage(driver, wdwait);
        }

        @AfterClass
        public void tearDown() {

        }
    } */

