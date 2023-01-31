package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class z2ListaCurrentURL {
    public static void main(String[] args) {

        /* Javascript, listaTabova, petlja */

        //Zadatak 2
    //Otvoriti browser i jos 5 tabova
    //Na svakom tabu otvoriti URL po zelji
    //Zatvoriti sve tabove osim onog gde je otvoren Google


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        js.executeScript("window.open()");

        ArrayList<String> listaTabova = new ArrayList <>(driver.getWindowHandles());

        driver.switchTo().window(listaTabova.get(0));
        driver.get("https://www.google.com");
        driver.switchTo().window(listaTabova.get(1));
        driver.get("https://www.instagram.com");
        driver.switchTo().window(listaTabova.get(2));
        driver.get("https://www.bbc.com/serbian/lat");
        driver.switchTo().window(listaTabova.get(3));
        driver.get("https://www.southparkstudios.com/");
        driver.switchTo().window(listaTabova.get(4));
        driver.get("https://www.wikipedia.org/");

        for (int i=0; i<listaTabova.size(); i++) {

            driver.switchTo().window(listaTabova.get(i));

            if(i!=0) {

                driver.close();
            }
        }



        //Prvi nacin

        /* driver.switchTo().window(listaTabova.get(5));
        driver.close();
        driver.switchTo().window(listaTabova.get(4));
        driver.close();
        driver.switchTo().window(listaTabova.get(3));
        driver.close();
        driver.switchTo().window(listaTabova.get(1));
        driver.close();
        driver.switchTo().window(listaTabova.get(0));
        driver.close(); */

        //Treci nacin

       /* for (int i = 0; i < listaTabova.size(); i++) {
            driver.switchTo().window(listaTabova.get(i));
            if (!driver.getCurrentUrl().equals("https://www.google.com/")) {  OVDE JE PROGRAM TRAZIO SLES NA KRAJU
                                                                                GOOGLE URL-A (ON VIDEO TO U KONZOLI)
                driver.close();
            }
        } */




    }
}
