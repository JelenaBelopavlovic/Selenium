package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium1 {

    public static void main(String[] args) {

        /* Otvaranje, refresovanje i zatvaranje stranica */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //driver.get("https://www.google.com"); //isto kao navigate, samo prvo refresuje stranicu
       driver.navigate().to("https://www.google.com");
        System.out.println(driver.getCurrentUrl());
       driver.navigate().to("https://www.youtube.com");
        System.out.println(driver.getCurrentUrl());
       driver.navigate().back();
       driver.navigate().forward();
       driver.navigate().refresh();
       driver.navigate().back();

       for (int i=0; i<5; i++) {
          driver.navigate().refresh();
       }

        System.out.println(driver.getCurrentUrl());

      //  driver.close(); //necemo upocetku koristiti za nase testove,
                        // jer hocemo da vidimo dokle smo stigli u pisanju testa;
                        // zatvara samo tab na koji smo fokusirani

        driver.quit(); // zatvara sve tabove
















    }
}
