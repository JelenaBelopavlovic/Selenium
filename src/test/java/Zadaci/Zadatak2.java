package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Zadatak2 {

    public static void main(String[] args) {

        //Zadatak 2
    //Otvoriti browser i jos 5 tabova
    //Na svakom tabu otvoriti URL po zelji
    //Zatvoriti sve tabove osim onog gde je otvoren Google


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.open");
        js.executeScript("window.open");
        js.executeScript("window.open");

        ArrayList <String> listaTabova = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(listaTabova.get(0));
        driver.get("https://www.google.com");

        driver.switchTo().window(listaTabova.get(1));
        driver.get("https://www.psychologytoday.com/us");

        //driver.switchTo().window(listaTabova.get(2));

        driver.quit();





    }
}
