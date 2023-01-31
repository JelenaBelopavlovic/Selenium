package Domaci2NegativeTC;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UsernameSpace {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/");

        WebElement practice = driver.findElement(By.id("menu-item-20"));
        practice.click();

        WebElement logInPage = driver.findElement(By.linkText("Test Login Page"));
        logInPage.click();

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("st udent");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Password123");

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();


        String expectedURL = "https://practicetestautomation.com/practice-test-login/";

        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);


        WebElement username1 = driver.findElement(By.id("username"));

        Assert.assertTrue(username1.isDisplayed());


        WebElement password1 = driver.findElement(By.id("password"));

        Assert.assertTrue(password1.isDisplayed());

        WebElement message = driver.findElement(By.id("error"));

        Assert.assertTrue(message.isDisplayed());


        Thread.sleep(2000);
        driver.close();


    }
}
