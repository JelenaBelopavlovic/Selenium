package Practice.PracticeBase;

import Practice.PracticePages.PracticeLoginPage1;
import Practice.PracticePages.PracticePracticePage1;
import Practice.PracticePages.PracticeProfilePage1;
import Practice.PracticePages.PracticeSidebarPage1;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class PracticeBaseTest1 {

    // Ideja je da se imaju tri PAKETA (unutar kojih kreiramo klase):
    // a) Practise Base - vazi za sve testove;
    //    Ovde smestamo Before Class i After Class;
    //    Ali i POMOCNE METODE koje cemo pozivati u testovima, poput SKROLA
    // b) Practise Pages - ima klasu za SVAKU POSEBNU STRANICU na kojoj se nalazimo.
    //    Ovde smestamo SVE STRANICE sa sajta koje testiramo.
    //    Svaka stranica koju browser otvori i cije web elemente testiramo je jedna klasa - Page
    //    (a ne samo one koje su na sajt obelezene kao stranice _ Home, Practice...)
    //    Unutar svake stranice smestamo:
    //    SVE VEB ELEMENTE sa te stranice (koje testiramo),
    //    I AKCIJE KOJE VRSIMO NAD TIM ELEMENTIMA.
    // c) Practice Tests - tu kreiramo SVE TESTOVE, pozivajuci stranicu, pa metodu koju smo kreirali.

    public WebDriver driver;           // mora public da bi bilo vidljivo u drugim klasama (BaseTest)
    public WebDriverWait wdwait;

   // 6. SVAKU stranicu koju kreiram, moram da POZOVEM u Base klasi!
    //   Ovde je deklarisemo, a u @Before class - setup metodi kreiramo objekat..
    //   i prosledjujemo driver i wdwait.

    // U Base klasi NEMA KONSTRUKTORA!

    public PracticeSidebarPage1 practiceSidebarPage1;
    public PracticePracticePage1 practicePracticePage1;

    public PracticeLoginPage1 practiceLoginPage1;

    public PracticeProfilePage1 practiceProfilePage1;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        practiceSidebarPage1 = new PracticeSidebarPage1(driver, wdwait);//jer u konstruktoru ocekuje te dve stvari
        practicePracticePage1 = new PracticePracticePage1(driver, wdwait);
        practiceLoginPage1 = new PracticeLoginPage1(driver, wdwait);
        practiceProfilePage1 = new PracticeProfilePage1(driver, wdwait);
    }

    @AfterClass
    public void tearDown() {

       driver.manage().deleteAllCookies();
       driver.quit();
    }


}
