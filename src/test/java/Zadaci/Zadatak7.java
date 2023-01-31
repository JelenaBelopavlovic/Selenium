package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;

public class Zadatak7 {

    public static void main(String[] args) {

        //Zadatak 7 - Ulogovati se na sajt https://demoqa.com/ preko kolacica,
        // izlogovati se i asertovati da je korisnik izlogovan

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/");

        WebElement bookAplication = driver.findElement(By.cssSelector(".avatar.mx-auto.white"));
        bookAplication.click();


       /* Cookie userName = new Cookie("userName", "JelBell");
        driver.manage().addCookie(userName);
        driver.navigate().refresh();

        Cookie id = new Cookie("userID", "ae7c4869-15a0-47d1-8cf6-111be28cebbb");
        driver.manage().addCookie(userName);
        driver.navigate().refresh(); */

       // ponavlja to sve i za cookie = expires i token
        // ide samo jednom na refresh na kraju..








    }
}
