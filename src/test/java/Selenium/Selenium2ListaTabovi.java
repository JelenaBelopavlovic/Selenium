package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Selenium2ListaTabovi {

    public static void main(String[] args) {

        /* Otvaranje tabova (putem liste - Javascript Executor) */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver; // executor nad driverom

        js.executeScript("window.open()"); // prosledjujemo "js" executoru,
                                                // skriptu "window.open()"
        js.executeScript("window.open()");
        js.executeScript("window.open()");

        // Da bismo upravljali tabovima, potrebna nam je lista
        // u parametru prosledjujemo - driver.getWindowHandles()

        ArrayList <String> listaTabova = new ArrayList<>(driver.getWindowHandles());

        // Kreiramo listu tipa string,
        // i prosledili smo listi naredbu da uhvati sve tabove i da ih smesti u listu

       // System.out.println(listaTabova);

        driver.switchTo().window(listaTabova.get(0));  // na ovaj nacin smo presli na 1. tab
        driver.get("https://www.google.com");         // kazemo - driveru,
                                                     // dohvati mi tab na nultom indexu u listi,
                                                     // i na njega stavi google stranicu
        driver.switchTo().window(listaTabova.get(1));
        driver.get("https://www.youtube.com");
        driver.switchTo().window(listaTabova.get(2));
        driver.get("https://www.linkedin.com");
        driver.switchTo().window(listaTabova.get(3));
        driver.get("https://www.joberty.rs");










    }
}
