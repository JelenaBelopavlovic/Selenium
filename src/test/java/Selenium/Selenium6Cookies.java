package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Selenium6Cookies {

    public static void main(String[] args) throws InterruptedException {

        // Ulogovati se na https://wordpress.com/log-in?redirect_to=https%3A%2F%2Fwordpress.com%2F
        // preko kukija

        // NE RADI preko kukija... peske hoce

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://wordpress.com/log-in?redirect_to=https%3A%2F%2Fwordpress.com%2F");

        Thread.sleep(2000);

        Cookie logedIn = new Cookie("wordpress_logged_in", "jelenabell%7C1768578657%7CgX2dtjH2Q39iOTR0tJ7gDAJrUHlOCfuBMaZdqNkzf0w%7Cb880b812152a2284100004635dbf6dc1cdae0d7752723f47f62d0f79aaddc244");

        driver.manage().addCookie(logedIn);

        driver.navigate().refresh();


    }
}

