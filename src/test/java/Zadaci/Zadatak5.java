package Zadaci;

import com.github.dockerjava.api.command.UpdateServiceCmd;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak5 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practicetestautomation.com/contact/");

        WebElement practice = driver.findElement(By.id("menu-item-20"));
        practice.click();

        WebElement login = driver.findElement(By.cssSelector(".is-layout-flow.wp-block-column"));
        login.click();

        driver.quit();



    }
}
