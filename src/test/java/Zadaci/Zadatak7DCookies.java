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
import java.util.List;

public class Zadatak7DCookies {

    public static void main(String[] args) {

        /* Cookies - logovanje preko kukija */

        //Ulogovati se na sajt https://demoqa.com/ preko kolacica,
        // izlogovati se i asertovati da je korisnik izlogovan

        // LOGIN //

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/login");

        // Uneo je adresu gde je vec na stranici Bookstore - Login (a mogli smo i klik - klik,
        // korak po korak da dodjemo do te stranice).

        // Inspect na body stranice Profile - Application - Cookies demoqa
        // onda se IZLOGUJE i gleda kojih sve kolacica sad ima: pocinje prvi sa "cto", poslednji sa "pbjs";
        // kako da znamo koji su se KUKIJI DODALI pri nasem logovanju?
        // tako sto je otvoren Application pri logout i potom pri login.
        // Vidimo da su se dodala prva tri, i nas username

        // Sad kreiramo kukije i kopiramo njihove Name i Value
        // (napravio je i cookie username prvo, al je ovde obrisano)

        Cookie userID = new Cookie("userID", "362c8c84-7846-4bcd-9625-ef0df047ff54");
        Cookie expires = new Cookie("expires", "2023-01-19T19%3A47%3A40.307Z");
        Cookie token = new Cookie("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6ImRyYWdvbGp1YnFhIiwicGFzc3dvcmQiOiJRd2VydHkxMjMhQCMiLCJpYXQiOjE2NzM1NTI4NjB9.EYUPze9bhpl69bWwaZMy9dQGwF8IzAwtDlnMZAT1hVE");

        // Cookie expires govori koliko nasa sesija traje,
        // odnosno ako je nalog sve vreme otvoren, mocicemo da ga koristimo sve dok cookie ne istekne.
        // Tada se opet logujemo. U value vidimo da cookie traje do 2023. 1. 19., tj. sedam dana.

        // Cookie token je nesto poput nase sifre, to je ono sto potvrdjuje da smo mi validan korisnik.
        // Mi kad se ulogujemo unosimo username i sifru,
        // program kaze, ok ovaj korisnik postoji, evo ti token - ulaznica da koristis nasu aplikaciju,
        // za odredjeno vreme. Ta ulaznica traje ovde nedelju dana.
        // Ako se izlogujemo i ponovo logujemo,
        // program opet potvrdjuje da smo u njegovom sistemu i daje nam novi token, ulaznicu,
        // s kojom mozemo da budemo tu nedelju dana.
        // (videcemo i u Postmanu, kada generisemo novi token, prethodni se smatra nepostojecim)

        // Cesto se pri refreshovanju dobija novi token, onda on dobija novu vrednost...
        // ili prosto kad istekne sesija.

        // ne mora username cookie, dovoljno je ubaciti par kukija koji nas loguju

        // sada drajveru nalazemo da doda kreirane kukije

        driver.manage().addCookie(userID);
        driver.manage().addCookie(expires);
        driver.manage().addCookie(token);

        driver.navigate().refresh();

        // LOGOUT //

        // sad idemo inspect na Logout dugme
        // id=submit, ima ih vise. u ovom slucaju, posto je prvo po redu bas za logout dugme,
        // to bi radilo posao, ali se u buducnosti redosled moze promeniti.. zato pravimo listu:

        // (ovo sledece - profileButton - je kasnije ubacio,
        // valjda kao jos jedan vid provere da li smo se izlogovali)

        // ASERTOVANJE da je korisnik izlogovan //

       /* WebElement profileButton = driver.findElement(By.linkText("profile"));
        profileButton.click();

        WebElement profileName = driver.findElement(By.id("userName-value"));
        Assert.assertEquals(profileName.getText(), "dragoljubqa"); */

        // i kazemo, prodji kroz listu elemenata,
        // dohvati mi svako dugme (svaki web element),
        // i dohvati tekst (sta pise na njemu)
        // ako je taj text jednak "logout"
        // uzmi to dugme i klikni
        // dodajemo break, da prestane pretragu kad ga pronadje


        List<WebElement> button = driver.findElements(By.id("submit")); //(obavezno mnozina - elementS)
        for (int i = 0; i < button.size(); i++) {
            if (button.get(i).getText().equals("Log out")) {
                button.get(i).click();
                break;
            }
        }

        // sad radimo potvrdu da nema vise dugmeta preko try-catch
        // pokusaj da mi pronadjes dugme "isDisplayed" preko Id-a
        // ako pronadje element, boolean prelazi u true

        // OBAVEZNO ASSERT NAKON TRY CATCH

        boolean logOutisDisplayed = false;
        try {
            logOutisDisplayed = driver.findElement(By.id("submit")).isDisplayed();

        } catch (Exception e) {
        }
        Assert.assertFalse(logOutisDisplayed);

        // try - catch koristimo kada ocekujemo da program NE nadje neki element




        /* naknadno je dodao i ove provere..

        boolean logOutButtonIsDisplayed = false;
        boolean usernameIsDisplayed = false;
        try {
            logOutButtonIsDisplayed = driver.findElement(By.id("submit")).isDisplayed();
        } catch (Exception e) {

        }

        try {
            usernameIsDisplayed = driver.findElement(By.id("submit")).isDisplayed();
        } catch (Exception e) {

        }

        Assert.assertFalse(logOutButtonIsDisplayed);
        Assert.assertFalse(usernameIsDisplayed); */








    }
}
