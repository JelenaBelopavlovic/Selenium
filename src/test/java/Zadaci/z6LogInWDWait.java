package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class z6LogInWDWait {

    public static void main(String[] args) throws InterruptedException {

        /* Implicit wait - WebDriverWait */

        //Ulogovati se na wordpress i proveriti da li smo ulogovani

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Kreiramo objekat iz klase WebDriverWait, i nazivamo ga wdwait;
        // prosledjujemo mu u malu zagradu 2 informacije:
        // sta ce da ceka - driver,
        // i koliko ce max da ceka - .Duration.OfSeconds(10)


        driver.manage().window().maximize();

        driver.get("https://wordpress.com/?apppromo");

        WebElement logIn = driver.findElement(By.linkText("Log In"));
        logIn.click();

        wdwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("usernameOrEmail"))));

        // Ovde radi, ali njemu ne, pa on dodaje i prepoznavanje URLa

        wdwait.until(ExpectedConditions.urlToBe("https://wordpress.com/log-in?redirect_to=https%3A%2F%2Fwordpress.com%2F"));

        WebElement username = driver.findElement(By.id("usernameOrEmail"));

        String user = "jelenabell";
        username.sendKeys(user);

        // Uvek tezimo da stvari definisemo na jednom mestu, i samo da ih pozivamo kasnije;
        // tako skracujemo proces (npr. kada sl. put budemo hteli da se ulogujemo s drugim username,
        // samo ga promenimo unutar ovog stringa, umesto na vise mesta)

        wdwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("login__form-action"))));

        WebElement continueButton = driver.findElement(By.className("login__form-action"));
        continueButton.click();

        wdwait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("password"))));
        // posto je password polje, prema njegovim recima, vidljivo programu i na stranici na kojoj mi vidimo
        // samo username, ovde visibilityOf vrv ne bi radilo;
        // zato biramo da je klikbl, iako necemo na njega kliktati

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("belarada4321#");


        // Explicit - implicit wait

        // Explicit wait - kod naredbe Thread.sleep, ceka se onoliko sekundi koliko smo zadali,
        // bez obzira da li se element pojavio i pre isteka tog vremena (sto je nepotrebno cekanje)

        // Implicit wait - naredba kojom nalazemo programu da saceka samo do trenutka dok se element
        // ne pojavi, a najduze onoliko koliko mu je zadato.
        // Zbog toga kreiramo (gore) objekat iz klase WebDriverWait

        // Thread.sleep() se koristi dok gradimo svoj test, da proverimo da li nam nesto radi;
        // Kada kreiramo test, thread.sleepove menjamo u WebDriverWait

        // wd wait pozivamo, i kazemo - cekaj dok se ne ispuni ocekivani uslov,
        // tj. jedna od opcija koju program sam nudi - da element bude vidljiv, da je klikbl, ili URLtoBe.
        // Ovde smo izabrali visibleOf opciju, i tu moramo proslediti put ka elementu,
        // koji kopiramo iz WebElementa


        WebElement logIn2 = driver.findElement(By.className("login__form-action"));
        logIn2.click();

        // Thread.sleep(3000);

        wdwait.until(ExpectedConditions.urlToBe("https://wordpress.com/home/jecabell3.wordpress.com"));

        // Provera da li smo ulogovani


        String expectedURL = "https://wordpress.com/home/jecabell3.wordpress.com";

        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        WebElement reader = driver.findElement(By.cssSelector(".gridicon.gridicons-reader"));

        Assert.assertTrue(reader.isDisplayed());

        WebElement write = driver.findElement(By.className("masterbar__publish"));

        Assert.assertTrue(write.isDisplayed());

        // Nema potrebe da ovde pravimo novi-stari web element, jer on nece uspeti da ga pronadje
        // (log in dugme i nije tu), pa program tu staje.
        // U try catch naredbi mi potvrdjujemo da ga nema. Tako da pozivamo element koji je gore definisan.


        boolean button = false;

        try {
            button = logIn.isDisplayed();

        } catch (Exception e) {

        }

        //NE ZABORAVITI ASSERT.ASSERTFALSE NAKON TRY-CATCH

        Assert.assertFalse(button);

        // Bolji izbor za proveru bi bio natpis pored dugmeta Homepage,
        // jer sadrzi nas username, koji se nece pojaviti nekom drugom.
        // Ja sam uzela svoj domen, jer kod mene pise samo Page Title (a ne username)

        WebElement siteDomain = driver.findElement(By.className("site__domain"));

        Assert.assertEquals(siteDomain.getText(), "jecabell3.wordpress.com");

        // Proveru asserta vrsimo tako sto Equals pretvorimo u notEquals, ili iznad - false u true.



        Thread.sleep(2000);
        driver.close();



    }
}
