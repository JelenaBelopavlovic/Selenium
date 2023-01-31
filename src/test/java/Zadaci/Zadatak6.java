package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak6 {
    public static void main(String[] args) throws InterruptedException {

        //Ulogovati se na wordpress i proveriti da li smo ulogovani

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://wordpress.com/?apppromo");

       // Thread.sleep(3000);
        WebElement login = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/ul/li[1]/a"));
        login.click();

        WebElement searchBox = driver.findElement(By.id("usernameOrEmail"));

        searchBox.sendKeys("jelenabelopavlovic@yahoo.com");
        searchBox.sendKeys(Keys.ENTER);

        WebElement password = driver.findElement(By.id("password"));

        Thread.sleep(3000);

        password.sendKeys("belarada4321#");
        password.sendKeys(Keys.ENTER);

        String expectedURL = "https://wordpress.com/home/jecabell3.wordpress.com";

        //Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        WebElement jelBell = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/main/div[1]/div[1]/div[2]/a"));

        boolean button = false;
        try {
            //u try bloku kazemo da ako se element pronadje, onda prethodno kreiran boolean treba da se promeni
            //odnosno da primi vrednost true ako je element pronadjen
            button = jelBell.isDisplayed();
        } catch (Exception e) {

        }
        Assert.assertFalse(button);





    }
}
