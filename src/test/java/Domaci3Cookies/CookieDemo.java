package Domaci3Cookies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class CookieDemo {

    public static void main(String[] args) throws InterruptedException {

        // Ulogujte se na demoqa preko cookies-a,
        // dodati dve knjige na svoj nalog,
        // zatim se izlogovati brisanjem cookies-a.
        // Ulogovati se ponovo preko log-in forme
        // i potvrditi da se knjige i dalje nalaze na nalogu.



        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://demoqa.com/login");

        Cookie userID = new Cookie("userID", "ae7c4869-15a0-47d1-8cf6-111be28cebbb");
        Cookie expires = new Cookie("expires", "2023-01-25T18%3A03%3A45.779Z");
        Cookie token = new Cookie("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6IkplbEJlbGwiLCJwYXNzd29yZCI6IkplbGJlbGw4NCMiLCJpYXQiOjE2NzQwNjUwMjV9.2yCJX_j4IlUUHR0H7BA-ISWIO4S3k_HeDlilwoKfILE");

        driver.manage().addCookie(userID);
        driver.manage().addCookie(expires);
        driver.manage().addCookie(token);

        driver.navigate().refresh();

        WebElement profile = driver.findElement(By.linkText("profile"));
        profile.click();

        JavascriptExecutor jse1 = (JavascriptExecutor) driver;
        jse1.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        Thread.sleep(3000);

        WebElement GoToBookStore = driver.findElement(By.id("gotoStore"));
        GoToBookStore.click();

        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollBy(0,250)", "");

        Thread.sleep(3000);

        WebElement book1 = driver.findElement(By.linkText("Git Pocket Guide"));
        book1.click();

        JavascriptExecutor jse3 = (JavascriptExecutor) driver;
        jse3.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        WebElement addToCollection = driver.findElement(By.cssSelector(".text-right.fullButton"));
        addToCollection.click();

        driver.navigate().back();

        JavascriptExecutor js4 = (JavascriptExecutor) driver;
        js4.executeScript("window.scrollBy(0,250)", "");

        Thread.sleep(2000);

        WebElement book2 = driver.findElement(By.linkText("Learning JavaScript Design Patterns"));
        book2.click();

        JavascriptExecutor jse5 = (JavascriptExecutor) driver;
        jse5.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        WebElement addToCollection2 = driver.findElement(By.cssSelector(".text-right.fullButton"));
        addToCollection2.click();

        driver.navigate().back();

        driver.manage().deleteCookieNamed("userID");
        driver.manage().deleteCookieNamed("expires");
        driver.manage().deleteCookieNamed("token");

        Thread.sleep(4000);

        List <WebElement> logInButton = driver.findElements(By.id("item-0"));
        logInButton.get(5).click();


       WebElement username = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[2]/input"));
       username.sendKeys("JelBell");

       WebElement password = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[3]/div[2]/input"));
       password.sendKeys("Jelbell84#");

       WebElement loginMain = driver.findElement(By.id("login"));
       loginMain.click();

        JavascriptExecutor js6 = (JavascriptExecutor) driver;
        js6.executeScript("window.scrollBy(0,250)", "");


        WebElement book11 = driver.findElement(By.linkText("Git Pocket Guide"));
        WebElement book22 = driver.findElement(By.linkText("Learning JavaScript Design Patterns"));

        Assert.assertTrue(book11.isDisplayed());
        Assert.assertTrue(book22.isDisplayed());


        Thread.sleep(3000);
        driver.quit();




    }
}
