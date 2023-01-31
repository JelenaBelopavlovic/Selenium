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

public class z7Cookies {

    public static void main(String[] args) throws InterruptedException {

        // Ulogovati se na sajt https://demoqa.com/ preko kolacica,
        // izlogovati se
        // i asertovati da je korisnik izlogovan

         // Radi x) jeeee

        // LOGIN

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://demoqa.com/login");

        Cookie userID = new Cookie("userID", "ae7c4869-15a0-47d1-8cf6-111be28cebbb");
        Cookie expires = new Cookie("expires", "2023-01-24T14%3A29%3A00.952Z");
        Cookie token = new Cookie("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6IkplbEJlbGwiLCJwYXNzd29yZCI6IkplbGJlbGw4NCMiLCJpYXQiOjE2NzM5NjU3NDB9.9nYbpHSJ9Y5bC7kVNGVghTv5yitXCq7CyNYxBRvgf1A");

        driver.manage().addCookie(userID);  // Dodajemo kukije pomocu MANAGE
        driver.manage().addCookie(expires);
        driver.manage().addCookie(token);

        driver.navigate().refresh();   // Refresujemo pomocu NAVIGATE

        // Komanda za BRISANJE kolacica:
        // driver.manage().deleteCookieNamed("name");

        // LOGOUT

        /* WebElement profile = driver.findElement(By.linkText("profile"));
        profile.click(); */

        // Za logout dugme vezan je id=submit, koji se pojavljuje 4 puta,
        // zato mora da se napravi lista

        Thread.sleep(2000);

        List<WebElement>buttons = driver.findElements(By.id("submit"));

        for (int i=0; i<buttons.size(); i++)  {    //NE ZABORAVI "int" ISPRED i

            if(buttons.get(i).getText().equals("Log out")) {
                buttons.get(i).click();
                break;
            }

        }

        // ASERTOVAJE da smo se izlogovali

        // potvrdjujemo da logout dugme nije prikazano

        boolean logOutButton = false;

        try {
            logOutButton = driver.findElement(By.id("submit")).isDisplayed(); // PAZI OVDE JE JEDNINA
                                                                                // - nadji mi elemenT
        } catch (Exception e) {

        }

        Assert.assertFalse(logOutButton);

        WebElement loginButton = driver.findElement(By.id("login"));

        Assert.assertTrue(loginButton.isDisplayed());


        Thread.sleep(2000);
        driver.close();

    }
}
