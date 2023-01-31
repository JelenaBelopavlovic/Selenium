package Domaci4AnotacijeKnjige;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class AnotacijeDodavanjeKnjiga {

    // Domaci:
    // Prethodni zadatak za dodavanje knjiga uraditi koristeci Anotacije.
    // Da jedan test bude sa dodavanjem jedne knjige,
    // drugi test sa dodavanjem dve knjige, treci sa tri itd.

    WebDriver driver;
    WebDriverWait wdwait;

    @BeforeClass
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @BeforeMethod
    public void setUpPage() {

        driver.manage().window().maximize();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://demoqa.com/login");

    }

    public void logInPage() {

        Cookie userID = new Cookie("userID", "ae7c4869-15a0-47d1-8cf6-111be28cebbb");
        Cookie expires = new Cookie("expires", "2023-01-28T12%3A39%3A51.212Z");
        Cookie token = new Cookie("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6IkplbEJlbGwiLCJwYXNzd29yZCI6IkplbGJlbGw4NCMiLCJpYXQiOjE2NzQzMDQ3OTF9.tfp1pA8Q2LrBPYNaJ5H5BzLq3MYR0qLghZvKWXiSBL8");
        driver.manage().addCookie(userID);
        driver.manage().addCookie(expires);
        driver.manage().addCookie(token);

        driver.navigate().refresh();

    }

    public void logInPage2() throws InterruptedException {

        Thread.sleep(3000);

        List <WebElement> logInButton = driver.findElements(By.id("item-0"));
        logInButton.get(5).click();

        WebElement username = driver.findElement(By.id("userName"));
        username.sendKeys("JelBell");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Jelbell84#");

        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,250)", "");

        wdwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("login"))));

        WebElement logIn = driver.findElement(By.id("login"));
        logIn.click();

    }

    public void logOut() {

        driver.manage().deleteCookieNamed("userID");
        driver.manage().deleteCookieNamed("expires");
        driver.manage().deleteCookieNamed("token");

        driver.navigate().refresh();
    }

    public void assertation1() throws InterruptedException {

        Thread.sleep(3000);

        logInPage2();

        JavascriptExecutor js4 = (JavascriptExecutor) driver;
        js4.executeScript("window.scrollBy(0,250)", "");

        Thread.sleep(2000);

        WebElement book1 = driver.findElement(By.linkText("Git Pocket Guide"));
        String expectedTitle = "Git Pocket Guide";
        String actualTitle = book1.getText();
        Assert.assertEquals(book1.getText(), expectedTitle);
    }

    public void assertation2() {

        JavascriptExecutor js7 = (JavascriptExecutor) driver;
        js7.executeScript("window.scrollBy(0,250)", "");

        WebElement pageImage2 = driver.findElement(By.cssSelector(".rt-tr.-even"));
        Assert.assertTrue(pageImage2.isDisplayed());

    }

    public void assertation3() {

        JavascriptExecutor js9 = (JavascriptExecutor) driver;
        js9.executeScript("window.scrollBy(0,250)", "");

        WebElement book3 = driver.findElement(By.linkText("Designing Evolvable Web APIs with ASP.NET"));
        Assert.assertTrue(book3.isDisplayed());
    }


    @Test (priority = 20)
    public void adding1Book() throws InterruptedException {

        logInPage();

        wdwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("profile"))));

        WebElement profile = driver.findElement(By.linkText("profile"));
        profile.click();

        JavascriptExecutor jse1 = (JavascriptExecutor) driver;
        jse1.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        wdwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("gotoStore"))));

        WebElement GoToBookStore = driver.findElement(By.id("gotoStore"));
        GoToBookStore.click();

        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollBy(0,200)", "");

        Thread.sleep(2000);

        WebElement book1 = driver.findElement(By.linkText("Git Pocket Guide"));
        book1.click();

        JavascriptExecutor jse3 = (JavascriptExecutor) driver;
        jse3.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        WebElement addToCollection = driver.findElement(By.cssSelector(".text-right.fullButton"));
        addToCollection.click();

        driver.navigate().back();

        Thread.sleep(2000);

        logOut();

        assertation1();


    }

    @Test (priority = 30)
    public void adding2Books() throws InterruptedException {

        logInPage();

        WebElement profile = driver.findElement(By.linkText("profile"));
        profile.click();

        JavascriptExecutor jse1 = (JavascriptExecutor) driver;
        jse1.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        wdwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("gotoStore"))));

        WebElement GoToBookStore = driver.findElement(By.id("gotoStore"));
        GoToBookStore.click();

        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollBy(0,250)", "");

        Thread.sleep(2000);

        WebElement book1 = driver.findElement(By.linkText("Git Pocket Guide"));
        book1.click();

        JavascriptExecutor jse3 = (JavascriptExecutor) driver;
        jse3.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        WebElement addToCollection = driver.findElement(By.cssSelector(".text-right.fullButton"));
        addToCollection.click();

        driver.navigate().back();

        JavascriptExecutor js4 = (JavascriptExecutor) driver;
        js4.executeScript("window.scrollBy(0,250)", "");

        wdwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Learning JavaScript Design Patterns"))));

        WebElement book2 = driver.findElement(By.linkText("Learning JavaScript Design Patterns"));
        book2.click();

        JavascriptExecutor jse5 = (JavascriptExecutor) driver;
        jse5.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        WebElement addToCollection2 = driver.findElement(By.cssSelector(".text-right.fullButton"));
        addToCollection2.click();

        driver.navigate().back();

        Thread.sleep(2000);

        logOut();

        assertation1();

        assertation2();

    }

    @Test (priority = 40)
    public void adding3Books() throws InterruptedException {

        logInPage();

        WebElement profile = driver.findElement(By.linkText("profile"));
        profile.click();

        JavascriptExecutor jse1 = (JavascriptExecutor) driver;
        jse1.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        wdwait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("gotoStore"))));

        WebElement GoToBookStore = driver.findElement(By.id("gotoStore"));
        GoToBookStore.click();

        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollBy(0,250)", "");

        Thread.sleep(2000);

        WebElement book1 = driver.findElement(By.linkText("Git Pocket Guide"));
        book1.click();

        JavascriptExecutor jse3 = (JavascriptExecutor) driver;
        jse3.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        WebElement addToCollection = driver.findElement(By.cssSelector(".text-right.fullButton"));
        addToCollection.click();

        driver.navigate().back();

        Thread.sleep(2000);

        JavascriptExecutor js4 = (JavascriptExecutor) driver;
        js4.executeScript("window.scrollBy(0,250)", "");

        wdwait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Learning JavaScript Design Patterns"))));

        WebElement book2 = driver.findElement(By.linkText("Learning JavaScript Design Patterns"));
        book2.click();

        JavascriptExecutor jse5 = (JavascriptExecutor) driver;
        jse5.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        WebElement addToCollection2 = driver.findElement(By.cssSelector(".text-right.fullButton"));
        addToCollection2.click();

        driver.navigate().back();

        JavascriptExecutor js5 = (JavascriptExecutor) driver;
        js5.executeScript("window.scrollBy(0,250)", "");

        wdwait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Designing Evolvable Web APIs with ASP.NET"))));

        WebElement book3 = driver.findElement(By.linkText("Designing Evolvable Web APIs with ASP.NET"));
        book3.click();

        JavascriptExecutor jse6 = (JavascriptExecutor) driver;
        jse6.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        WebElement addToCollection3 = driver.findElement(By.cssSelector(".text-right.fullButton"));
        addToCollection3.click();

        driver.navigate().back();

        Thread.sleep(2000);

        logOut();

        assertation1();

        assertation2();

        assertation3();

    }

    @AfterMethod
    public void tearDown() {

        driver.quit();

    }


}
