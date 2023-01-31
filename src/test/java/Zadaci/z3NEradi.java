package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class z3NEradi {
    public static void main(String[] args) throws InterruptedException {

        //Zadatak 3
    //Otici na Google
    //Zatim ukucati "Wikipedia" u polje za pretragu
    //Odraditi pretragu i otvoriti stranicu
    //Na stranici Wikipedia pretraziti "Nikola Tesla"


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("Wikipedia");
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys(Keys.ENTER);

        Thread.sleep(4000);

       WebElement wikipediaPage = driver.findElement(By.xpath("/html/body/div[7]/div/div[11]/div/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/div/div[1]/a"));
       wikipediaPage.sendKeys(Keys.ENTER);

        Thread.sleep(4000);

       WebElement wikiSearchBox = driver.findElement(By.xpath("/html/body/div[3]/form/fieldset/div"));
        Thread.sleep(4000);
       wikipediaPage.sendKeys("Nikola Tesla");
       wikipediaPage.sendKeys(Keys.ENTER);

       //NE RADI






    }
}
