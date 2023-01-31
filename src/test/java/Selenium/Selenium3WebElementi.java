package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium3WebElementi {

    public static void main(String[] args) {

        /* Web elementi, pronalazenje po Xpath-u */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.google.com");

        // Kopiranje Xpath-a:
        // desni klik na element/naziv sajta, inspect
        // ponoviti
        // u desnom prozoru, "domu', otvaraju se kodovi, tj. svi podaci vezani za stranicu
        // desni klik na zaplavljen deo, copy, full Xpath

        WebElement searchBox = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
        searchBox.sendKeys("ITbootcamp");
        // searchButton.click();
        // searchBox.sendKeys(Keys.ENTER);

        WebElement searchButton = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]"));
        searchButton.click(); //?

        // Kada idemo na neki sajt: odemo na Google,
        // i kad se izlistaju stranice za taj sajt,
        // desni klik na "naslov" i inspect


        WebElement website = driver.findElement(By.xpath("/html/body/div[7]/div/div[11]/div/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/div/div[1]/a/h3"));
        website.click();
        // ovde bira element "a href" (jedan iznad onog obelezenog plavom)..??










    }
}
