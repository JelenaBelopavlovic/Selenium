package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class Selenium4D {
    public static void main(String[] args) {

        /* Assert */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.google.com");

        //----------------------

        //Apsolutni xpath
        WebElement searchBar1 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
        //Relativni xpath
        WebElement searchBar2 = driver.findElement(By.xpath("//div/div[2]/input"));
        //Class
        WebElement searchBar3 = driver.findElement(By.className("gLFyf"));
        //Name
        WebElement searchBar4 = driver.findElement(By.name("q"));

        //------------------------

        //Prioritet za pretragu lokatora (selektora)
        //ID - najpouzdaniji jer je najmanje podlozan promenama
        //Name
        //Class
        //Css
        //Xpath - najnepouzdaniji jer je najvise podlozan promenama

        //-------------------

        WebElement searchBar = driver.findElement(By.name("q"));
        searchBar.sendKeys("Wikipedia");

        //searchBar.sendKeys(Keys.ENTER);

        List<WebElement> searchButton = driver.findElements(By.name("btnK"));
        searchButton.get(1).click();

        WebElement wikipediaPage = driver.findElement(By.cssSelector(".LC20lb.MBeuO.DKV0Md"));
        wikipediaPage.click();

        WebElement wikipediaSearch = driver.findElement(By.id("searchInput"));
        wikipediaSearch.sendKeys("Nikola Tesla");

        WebElement wikipediaButton = driver.findElement(By.cssSelector(".pure-button.pure-button-primary-progressive"));
        wikipediaButton.click();

        String expectedURL = "https://en.wikipedia.org/wiki/Nikola_Tesla";

        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        WebElement pageTitle = driver.findElement(By.className("mw-page-title-main"));
        String actualTitle = pageTitle.getText();
        String expectedTitle = "Nikola Tesla";

        Assert.assertEquals(actualTitle, expectedTitle);

        WebElement pageImage = driver.findElement(By.className("infobox-image"));

        Assert.assertTrue(pageImage.isDisplayed());

        /*  Lokatori:

    Prvo trazimo "id" medju lokatorima zato sto je jedinstven element i nije sklon pomenama (u idealnom sistemu)
    Ako nemamo "id" trazimo onda "name"
    Za slucaj da nemamo ni "id" ni "name" onda tek prelazimo na "class"
    ali obavezno treba proveriti da li je element jedinstven
    tako sto se kopira vrednost klase i ubaci u pretragu (CTRL + F).
    Program ce naci cesto mnogo resenja, ali ne znaci da element nije jedinstven.
    Na primer:
    "...
    for="string"
    class="string"
    ..."
    ovde ce pronaci dva elementa ali ako trazite preko class onda je jedinstven

    Ako klasa koju trazite ima vrednost za vise stringova u sebi onda:
    Promenite iz By.ClassName u By.CssSelector
    Obrisete razmake i stavite tacku na njihovo mesto
    Stavite tacku na pocetak vrednosti
    Na primer:
    class = "jedan dva tri"
    onda ne mozete naci kao
    By.ClassName("jedan dva tri");
    nego morate
    By.CssSelector(".jedan.dva.tri");

    Thread.sleep(2000);

    Morace da se doda exception za ovo cekanje (gore kod psvm),
    tako sto kliknete na "sleep" i kliknete ALT + ENTER.

    Videcete u produzetku metode da se dodao exception.

    U zagradi se pisu milisekunde. Ako hocete da sacekate 2 sekunde onda 2000, ako hocete 5 onda 5000  */


    }
}
