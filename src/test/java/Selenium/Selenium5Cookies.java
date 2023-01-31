package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Selenium5Cookies {

    public static void main(String[] args) throws InterruptedException {

        /* Cookies - logovanje kada Log In ne radi, pomocu kukija*/

        // NE RADI (OBRISALA SAM SVOJE COOKIES.. mada u poruci koja se pojavi pise
        // "clear cookies".. mozda treba sve)

        // Cookies mozemo koristiti da se ulogujemo, kada npr. log in za stranicu koju testiramo ne radi.
        // Koraci su:
        // 1. Inspect na ulogovanu stranicu
        // 2. Elements - Application - Cookies (date stranice.. pise u opisu)
        // 3. Kopiramo Name i Value cookie-a koji u nazivu ima nas username i "log in"
        // 4. Kreiramo Cookie objekat iz Cookie klase i ubacimo kopirane vrednosti - Name i Value
        // 5. Dodajemo cookie - pozivamo driver da upravlja dodavanjem kukija,
        //    i prosledjujemo mu kog kukija - tj. naziv kukija
        // 6. Radimo refresh

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://wordpress.com/?apppromo");

        // nznm odakle je ova adresa.. kopirala iz njegovog zadatka

        Thread.sleep(2000);

        Cookie cookie = new Cookie("wordpress_logged_in", "jelenabell%7C1768474466%7C91twyHHnrGuCFyhA6qZIqZy6TPHtHpBqPKVvmQ9Gx79%7C3d774411ed107e10df710880e295a4e6006a0830a21dfc8f6fb32404faece505");

        driver.manage().addCookie(cookie);
        driver.navigate().refresh();

        // driver.manage.delete.all.cookies - cesto se pise na kraju testova, da ne bismo opterecivali komp.
        // Mozemo od developera traziti da kreiraju nas cookie, i njime da se stalno sluzimo.

        // Refresh je potreban prilikom koriscenja kukija za log in;
        // u situacijama poput dodavanja knjiga u korpu preko kukija, nije neophodno,
        // ali je pozeljno.

        // Postoji i naredba driver.navigate().back();
        // za pop-upove

        // BRISANJE KUKIJA:
        // driver.manage().deleteCookieNamed("name"); ili
        // driver.manage.delete.all.cookies








        Thread.sleep(4000);
        driver.close();


    }


}
