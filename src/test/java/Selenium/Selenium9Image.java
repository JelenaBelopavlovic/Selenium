package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Selenium9Image {

    public static void main(String[] args) {

        /* Upload slike */

        // Za upload slike, prvo na sajtu trazimo dugme za upload;
        // tom dugmetu saljemo string - lokaciju nase slike s imenom i njenom ekstenzijom

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://crop-circle.imageonline.co/");

        WebElement uploadImage = driver.findElement(By.id("inputImage"));

        // Sada NE KLIKCEMO NA DUGME, vec samo SALJEMO KROZ SEND KEYS, LOKACIJU GDE SE MOJA SLIKA NALAZI

        uploadImage.sendKeys("C:\\Users\\Administrator\\Desktop\\CVjevi\\pero.png");

        // Na slici na nasem kompu:
        // desni klik - properties - location - copy
        // u sendKeyz:
        // prvo znaci navoda, pa paste (da bi odmah ubacio duple sleseve),
        // na kraju dodajemo: jos dva slesa, ime slike, tacku i njenu ekstenziju - \\pero.png
        // (nalazi se u Type of file, iznad Location)


    }
}
