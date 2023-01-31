package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class z9ImageMeme {

    public static void main(String[] args) throws InterruptedException {

        // NE radi

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://imgflip.com/memegenerator");


        WebElement uploadButton = driver.findElement(By.id("mm-show-upload"));
        uploadButton.click();

        WebElement uploadButton2 = driver.findElement(By.id("mm-upload-btn"));
        uploadButton2.click();

        uploadButton2.sendKeys("C:\\Users\\Administrator\\Desktop\\CVjevi\\ij.png");



       // Thread.sleep(3000);
        // driver.close();






    }
}
