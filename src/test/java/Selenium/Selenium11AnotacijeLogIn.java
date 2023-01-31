package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Selenium11AnotacijeLogIn {

    /* Anotacije */
    /* Asertacije - poredjenje teksta poruke na stranici, prikaza dugmeta, URLa */
    /* Dom - poredjenje elementa u domu pre i nakon logovanja */
    /* Uvod u POM */

    // Ovo je jedan ozbiljan test. Za malo vise od sat smo testirali ozbiljan feature - login na stranicu.

    // U ovom testu mozemo videti da ima dosta ponovljenih kodova;
    // ideja je uvek skratiti kodove, i zato je kreiran POM - page object model.
    // Postoji vise nacina koriscenja POMa. Mi cemo raditi basic, tj. samo osnove.

    // Ideja je da se imaju tri PAKETA (unutar kojih kreiramo klase).
    // I u sledecem zadatku (Practice) cemo sve ovo sto smo ovde radili da prebacimo u POM.
    // (package Practice)

    // Dragoljubu nekad i po 10 pokusaja treba dok mu ne prodje cela klasa, tj svi testovi.

    // Program s anotacijama radi tako sto prvo otvori klasu,
    // zatim pokupi anotacije, i ide redom:
    // 1. Before Class
    // 2. Before Method
    // 3. Testovi - unutar kojih redom izvrsava kodove, ukljucujuci i pozvane pomocne metode gde god se nalazile
    // 4. After Method
    // 5. After Class

    // Kada pokrenemo celu klasu, i neki test padne, pored samo tog testa stajace crvena oznaka.

    WebDriver driver;      // Ovde moramo da definisemo driver;
    WebDriverWait wdwait; // ako bismo ga definisali unutar neke metode, samo tu bi bio vidljiv.

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();

    }

    @BeforeMethod
    public void pageSetUp() {          // ovde sve ovo smestamo
                                        // jer hocemo da svaki test bude u novom browseru

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/");
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // NE ZABORAVI DA KREIRAS OBJEKAT WDWAIT! ne samo da ga gore deklarises..

    }


    public void goToLogInPage() {  // Za sve kodove koji se PONAVLJAJU, pravimo posebne metode bez anotacija,
                                   // i onda ih pozivamo unutar metoda sa anotacijama, po imenu
                                   // (kad bismo stavili anotaciju i ovde, gledala bi se kao poseban test)
        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();

        WebElement testLoginPageButton = driver.findElement(By.linkText("Test Login Page"));
        testLoginPageButton.click();
    }

    public void logIn() {

        WebElement usernameField = driver.findElement(By.id("username"));
        String validUsername = "student";
        usernameField.sendKeys(validUsername);

        WebElement passwordField = driver.findElement(By.id("password"));
        String validPassword = "Password123";
        passwordField.sendKeys(validPassword);

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
    }

        // Da bismo vec ovde mogli da pokrenemo program,
        // dovoljno je da napravimo samo kostur za test metodu,
        // i pojavice se plej dugmici

    @Test (priority = 10)
    public void userCanLogIn() {  // (I ovde mozemo da ubacimo Thread.sleep.)
                                    // Prvo kreiramo elemente za log in.

        goToLogInPage();

        logIn();


        // Sada radimo potvrdu da smo ulogovani:
        // 1. da je prikazano log out dugme - is.Displayed
        WebElement logOutButton = driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(logOutButton.isDisplayed());

        // 2. Poredimo sadrzaj poruke koju driver hvata, s ocekivanom - WEB ELEMENT.getText();
        WebElement notification = driver.findElement(By.className("post-title"));
        Assert.assertEquals(notification.getText(), "Logged In Successfully");

        // 3. Poredimo trenutni URL koji drajver hvata, s ocekivanim
        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/logged-in-successfully/");

        // S tim sto je on umesto da direktno unosi "expected" vrednosi u zagradama, posebno pravio Stringove.

    }

    @Test (priority = 20)
    public void userCanLogOut() throws InterruptedException { // Deskriptivno pisemo metode
                                                            // (bas kao i test caseve)
                                        // da kada se sa strane ispisu, znamo tacno koji je test prosao/pao.

       goToLogInPage();

       logIn();

        //WebElement errorMessage = driver.findElement(By.className("show"));  // da l je ovde greska?
        //Assert.assertTrue(errorMessage.isDisplayed());
        //Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");

       // Thread.sleep(3000);
       // driver.close();

        WebElement logOutButton = driver.findElement(By.className("wp-block-group__inner-container"));
        logOutButton.click();

        boolean logOut = false;

        try {
            logOut = driver.findElement(By.className("wp-block-group__inner-container")).isDisplayed();
                                    // NE ZABORAVI - .isDISPLAYED - NA KRAJU

        } catch (Exception e) {


        }

        Assert.assertFalse(logOut);  // NE ZABORAVI - ASSERT - NA KRAJU TRY-CATCH!

        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");

        // Posto su webelementi posati stale, jer smo promenili stranicu/dom,
        // moramo ih ponovo deklarisati

        WebElement usernameField2 = driver.findElement(By.id("username"));

        Assert.assertTrue(usernameField2.isDisplayed());

        WebElement passwordField2 = driver.findElement(By.id("password"));

        Assert.assertTrue(passwordField2.isDisplayed());



    }

    // Posle ovoga mozemo da pravimo testove UserCantLoginWithInvalidUsername/Password

    @Test (priority = 30)
    public void userCantLoginWithInvalidUsername() {

        goToLogInPage();

        WebElement usernameField = driver.findElement(By.id("username"));
        String invalidUsername = "user";
        usernameField.sendKeys(invalidUsername);

        WebElement passwordField = driver.findElement(By.id("password"));
        String validPassword = "Password123";
        passwordField.sendKeys(validPassword);

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();


        WebElement notification = driver.findElement(By.className("show"));
       // Assert.assertTrue(notification.isDisplayed());                 // Ne znam ZASTO NE MOZE OVAKO

        String expectedNotification = "Your username is invalid!";
        wdwait.until(ExpectedConditions.textToBePresentInElement(notification, expectedNotification));
        Assert.assertEquals(notification.getText(), expectedNotification);

        // On u domu gleda sta postoji od elemenata pre logovanja;
        // vidi da su poruka o gresci i njen ID prisutni i pre logIn-a.
        // Zatim gleda sta se menja u domu kad se uloguje,
        // i vidi da se pojavljuje nova klasa "show" (potamnjeno), koja se odnosi na notifikaciju;
        // zato menja putanju do notifikacije preko Class,
        // tako smo jedino sigurni da nismo uspeli da se ulogujemo
        // (jer se notifikacija o gresci samo tad pojavljuje na ekranu).
        // Da se klasa nije pojavila, ne bi trebalo ni da uzimamo notifikaciju za asertaciju
        // jer  je nepouzdana.

        boolean logOut = false;

        try {
            logOut = driver.findElement(By.className("wp-block-group__inner-container")).isDisplayed();

        } catch (Exception e) {

        }
        Assert.assertFalse(logOut);

        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");

    }

    @Test (priority = 40)
    public void userCantLoginWithInvalidPassword() {

        goToLogInPage();

        WebElement usernameField = driver.findElement(By.id("username"));
        String validUsername = "student";
        usernameField.sendKeys(validUsername);

        WebElement passwordField = driver.findElement(By.id("password"));
        String invalidPassword = "password";
        passwordField.sendKeys(invalidPassword);

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();


        WebElement notification = driver.findElement(By.className("show"));
        // Assert.assertTrue(notification.isDisplayed());

        String expectedNotification = "Your password is invalid!"; // PAZI STA PISE U PORUCI,
                                                                // NIJE USERNAME, VEC PASSWORD INVALID!!

        wdwait.until(ExpectedConditions.textToBePresentInElement(notification, expectedNotification));
        // KADA BAGUJE PROBAJ S WAITEROM!
        // u wdwait ide i poruka koju treba naci preko drivera, i ocekivana poruka, sto je cudno...

        Assert.assertEquals(notification.getText(), expectedNotification); // ZASTO NECE

        boolean logOut = false;

        try {
            logOut = driver.findElement(By.className("wp-block-group__inner-container")).isDisplayed();

        } catch (Exception e) {

        }
        Assert.assertFalse(logOut);

        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");

    }

    @Test
    public void userCannotLogInWithEmptyFields() {

        goToLogInPage();
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        username.clear();  // ubacujemo - .clear - da budemo sigurni da nisu ostali neki kolacici
                           // od prethodnog logovanja i da su polja sada prazna
                           // znaci ovde proveravamo akciju:
                           // preskocio sam username, preskocio sam password
        password.clear();
        submitButton.click();

        String expectedURL = "https://practicetestautomation.com/practice-test-login/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        boolean logOut = false;
        try {
            logOut = driver.findElement(By.linkText("Log out")).isDisplayed();
        } catch (Exception e) {

        }
        Assert.assertFalse(logOut);

        WebElement errorNotification = driver.findElement(By.className("show"));
        String expectedNotification = "Your username is invalid!";
        wdwait.until(ExpectedConditions.textToBePresentInElement(errorNotification, expectedNotification));
       // malo dupli posao
        Assert.assertEquals(errorNotification.getText(), expectedNotification);
    }

    @Test
    public void userCannotLogInWithEmptyUsernameField() {

        goToLogInPage();

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        String validPassword = "Password123";

        username.clear();
        password.sendKeys(validPassword);
        submitButton.click();

        String expectedURL = "https://practicetestautomation.com/practice-test-login/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        boolean logOut = false;
        try {
            logOut = driver.findElement(By.linkText("Log out")).isDisplayed();
        } catch (Exception e) {

        }
        Assert.assertFalse(logOut);

        WebElement errorNotification = driver.findElement(By.className("show"));
        String expectedNotification = "Your username is invalid!";
        wdwait.until(ExpectedConditions.textToBePresentInElement(errorNotification, expectedNotification));
        Assert.assertEquals(errorNotification.getText(), expectedNotification);
    }

    @Test
    public void userCannotLogInWithEmptyPasswordField() {

        goToLogInPage();

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        String validUsername = "student";

        username.sendKeys(validUsername);
        password.clear();
        submitButton.click();

        String expectedURL = "https://practicetestautomation.com/practice-test-login/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        boolean logOut = false;
        try {
            logOut = driver.findElement(By.linkText("Log out")).isDisplayed();
        } catch (Exception e) {

        }
        Assert.assertFalse(logOut);

        WebElement errorNotification = driver.findElement(By.className("show"));
        String expectedNotification = "Your password is invalid!";
        wdwait.until(ExpectedConditions.textToBePresentInElement(errorNotification, expectedNotification));
        Assert.assertEquals(errorNotification.getText(), expectedNotification);
    }

    @AfterMethod
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
