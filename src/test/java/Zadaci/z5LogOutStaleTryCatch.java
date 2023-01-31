package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class z5LogOutStaleTryCatch {

    public static void main(String[] args) throws InterruptedException {

        // Proveriti da li na stranici https://practicetestautomation.com/ mozemo da se izlogujemo,
        // odnosno da li smo izlogovani

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/");

        WebElement practice = driver.findElement(By.id("menu-item-20"));
        practice.click();

        WebElement logInPage = driver.findElement(By.linkText("Test Login Page"));
        logInPage.click();

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("student");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Password123");

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        // Ne treba nam i ovde assert da smo se uspesno ulogovali, jer je to uradjeno u prethodnom testu.
        // Testovi se inace rade sekvencijalno. Ovde proveravamo samo uspesan log out.

        WebElement logOut = driver.findElement(By.linkText("Log out"));
        logOut.click();

        String expectedURL = "https://practicetestautomation.com/practice-test-login/";

        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        // STALE ELEMENTI

        // Ponovo pravimo iste WebElemente (isti path, samo malo izmenimo naziv),
        // jer bi nam se u suprotnom ispisala poruka u konzoli "stale element reference" (ustajali element),
        // i program ih ne bi prepoznao.
        // To se dogadja jer se dom promenio (izlogovali smo se), i element je vec jednom iskoriscen.
        // Stale elementi nece biti problem kad budemo radili u POMu (page object model),
        // jer ce on iznova pozivati metodu.

        WebElement username1 = driver.findElement(By.id("username"));

        Assert.assertTrue(username1.isDisplayed());

        WebElement password1 = driver.findElement(By.id("password"));

        Assert.assertTrue(password1.isDisplayed());

        // TRY - CATCH

        // Ubacujemo jos jednu proveru - da se dugme log out NE NALAZI na stranici

        // WebElement logOut1 = driver.findElement(By.linkText("Log out"));

        // Assert.assertFalse(logOut1.isDisplayed());

        // ali to ne mozemo da potvrdimo samo naredbom assertFalse,
        // vec koristeci TRY - CATCH naredbu, koja sadrzi sledece korake:

        boolean button = false;

        try {
            button = logOut.isDisplayed();

        } catch (Exception e) {

        }

        Assert.assertFalse(button);

        // Desilo se sledece:

        // Nismo se izlogovali i log out button je driver mogao da pronadje.
        // Boolean smo podesili na false,
        // i rekli smo - probaj da pronadjes ovaj element (logOut);
        // ako ga ne pronadjes, nije problem, ne prekidaj program;
        // ako ga pronadjes promeni boolean u true.
        // Sada treba da proverimo da li je boolean true ili false u assertu:
        // ako ga ne pronadje ostace false, samo ce da ignorise ovo u zagradi;
        // ako ga pronadje, menja vrednost u true i test pada

        // Dakle, u try bloku kazemo da ako se element pronadje,
        // onda prethodno kreiran boolean treba da se promeni
        // odnosno da primi vrednost true ako je element pronadjen

        // Nema potrebe da ovde pre naredbe try-catch pravimo novi-stari web element,
        // jer on nece uspeti da ga pronadje,
        // (log out dugme i nije tu), pa program tu staje.
        // U try catch naredbi mi potvrdjujemo da ga nema. Tako da pozivamo element koji je gore definisan.

        // Proveravamo da li try-catch radi tako sto se ne izlogujemo i pustimo program.
        // Vidimo da program pada tamo gde smo mu i namenili










        Thread.sleep(2000);
        driver.close();






    }
}
