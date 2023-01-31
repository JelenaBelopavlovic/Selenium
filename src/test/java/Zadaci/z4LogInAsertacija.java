package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class z4LogInAsertacija {

    public static void main(String[] args) throws InterruptedException {

        // Ulogovati se na sajt https://practicetestautomation.com/
        // Zatim proveriti da li smo ulogovani

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/");

        // LOGOVANJE

        WebElement practice = driver.findElement(By.id("menu-item-20"));
        practice.click();

        // Thread.sleep(3000);
        // WebElement logInPage = driver.findElement(By.xpath("/html/body/div/div/section/div/div/article/div[2]/div[1]/div[1]/p/a"));

        // BY.LINKTEXT - kada u domu imamo tekst pored linka, TAJ TEKST se moze iskoristiti kao put do elementa
        // (sto i pise u komandi - linkovanim TEKSTOM)

        WebElement logInPage = driver.findElement(By.linkText("Test Login Page"));
        logInPage.click();

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("student");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Password123");

        // Drugi nacin je:
        // nakon kreiranog webElementa, pravimo String, i taj string prosledjujemo webElementu:
        // String validUsername = "student";
        // username.sendKeys(validUsername);


        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        // PROVERA DA LI SMO ULOGOVANI

        String expectedURL = "https://practicetestautomation.com/logged-in-successfully/";

        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        WebElement logOutButton = driver.findElement(By.cssSelector(".wp-block-button__link.has-text-color.has-background.has-very-dark-gray-background-color"));

        Assert.assertTrue(logOutButton.isDisplayed());

        WebElement postTitle = driver.findElement(By.className("post-title"));

        Assert.assertTrue(postTitle.isDisplayed());



        Thread.sleep(2000);
        driver.close();



    }
}
