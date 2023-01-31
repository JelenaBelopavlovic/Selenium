package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Selenium7D {
    public static void main(String[] args) throws InterruptedException {

        //kod njega Zadatak6

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://wordpress.com/");

        WebElement loginRedirect = driver.findElement(By.linkText("Log In"));
        loginRedirect.click();

        Thread.sleep(3000);

        WebElement emailField = driver.findElement(By.id("usernameOrEmail"));
        String username = "dragoljubqa";
        emailField.sendKeys(username);

        WebElement continueButton = driver.findElement(By.cssSelector(".button.form-button.is-primary"));
        continueButton.click();

        Thread.sleep(2000);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("Swordfish123!@#");

        continueButton.click();

        Thread.sleep(4000);

        WebElement profileName = driver.findElement(By.className("site__title"));

        Assert.assertEquals(profileName.getText(), username);

    }
}
