package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class z8DeleteCookie {

    public static void main(String[] args) throws InterruptedException {

        /* Brisanje (knjige) samo jednim kukijem */
        /* Naredba: String...get.text(); */


        //Zadatak 8
    //https://www.amazon.com/Selenium-Framework-Design-Data-Driven-Testing/dp/1788473574/ref=sr_1_2?dchild=1&keywords=selenium+test&qid=1631829742&sr=8-2
    //Potrebno je napraviti test dodavanja knjige u korpu
    //i brisanjem samo jednog cookie-a treba da se obrise knjiga iz korpe

        //POENTA ZADATAKA - tri puta proveriti cart:
        // 1. pre dodavanja knjige
        // 2. nakon dodavanja
        // 3. nakon brisanja

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com/Selenium-Framework-Design-Data-Driven-Testing/dp/1788473574/ref=sr_1_2?dchild=1&keywords=selenium+test&qid=1631829742&sr=8-2");

        // Prvo moramo da se UVERIMO DA JE KORPA PRAZNA.
        // to radimo preko Stringa i get.text naredbe.

        WebElement cart1 = driver.findElement(By.id("nav-cart-count"));
        String cartBeforeAdding = cart1.getText();
        Assert.assertEquals(cartBeforeAdding, "0");

        // Dodajemo knjigu.

        WebElement addToCart = driver.findElement(By.id("submit.add-to-cart"));
        addToCart.click();

        // Ovde bi stavio driver.navigate().refresh();
        // da ga dodavanje knjige nije automatski odvelo na sledecu stranicu;
        // posto jeste, ne treba nam.

        // Sad hocemo da proverimo stanje u korpi. Pozivamo ponovo cart element,
        // ali posto je nova stranica u pitanju, znaci da se dom promenio i da je element stale.
        // (mogli smo ovde i da skinemo "Web element", pa da svuda pise samo cart = ...,
        // jer smo ga gore vec deklarisali)

        WebElement cart2 = driver.findElement(By.id("nav-cart-count"));
        String cartAfterAdding = cart2.getText();
        Assert.assertEquals(cartAfterAdding, "1");

        driver.navigate().back();
        driver.navigate().refresh();

        // Valjda ponovo pravimo proveru da je u korpi knjiga.

        WebElement cart3 = driver.findElement(By.id("nav-cart-count"));
        String cartAfterRefresh = cart3.getText();
        Assert.assertEquals(cartAfterRefresh, "1");

        // Sada na stranici trazimo cookie kojim bi mogli da izbrisemo knjigu.
        // On bira session ID cookie, ide na DELETE (kuki) i REFRESH (stranica).
        // I tako vidi da je korpa prazna,
        // tj. koji je kuki adekvatan.

        // Sada uopste ne kreira element Cookie, vec koristi naredbu:

        driver.manage().deleteCookieNamed("session-id"); // i ubacuje ime kukija sa stranice
        driver.navigate().refresh();
        driver.navigate().refresh();
        // Ubacujemo jos jedan referes, jer se na stranici nakon brisanja knjige kukijem
        // pojavljuje poruka o gresci

        // (Ako se trazena radnja ne nalazi u navigate, onda je u manage..
        // OBAVEZNO REFRESH nakon naredbi za kukije.)

        // Iznova radimo proveru stanja u korpi.

        WebElement cart4 = driver.findElement(By.id("nav-cart-count"));
        String cartAfterDelete = cart4.getText();
        Assert.assertEquals(cartAfterDelete, "0");

        // Vracamo se u korpu i trazimo potvrdu ispisane poruke na stranici - "korpa je prazna":

        WebElement goToCartButton = driver.findElement(By.id("nav-cart"));
        goToCartButton.click();

        WebElement notification = driver.findElement(By.cssSelector(".a-row.sc-your-amazon-cart-is-empty"));
        Assert.assertTrue(notification.isDisplayed());



         // Cookie delete = new Cookie("session-token", "tdhJmqkLyt8Es5FH6QmCVjzgiedKFOmaXW6TWiQ5kwYer3cme711nrRunEHHdz96wtyFKJ11p0jaECSUacqUVlyuulnNUdMMsinD8M2HSXrlus355wp+9cesVNVEGWn4eNmfaqOagnu8Fd327GMh+MSOlNSLGLNOwDYmRUTjI0vxHLrEdceQK7+nMPIKQBODynl/HY223CFyfyy1I/vot97j9Z/6l3AvDAU37cnUaeXWMtJRbrGNX2wQ7AGxiGCE");
        //  driver.manage().deleteCookieNamed("delete");
        // NISAM SIGURNA da mozemo i ovako da brisemo kolacice... pozivanjem imena kreiranog kukija..
        // ili samo imena koje je originalno na stranici


        //Thread.sleep(3000);
        //driver.close();



    }
}
