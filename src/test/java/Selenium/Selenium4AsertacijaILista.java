package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.LinkedList;
import java.util.List;

public class Selenium4AsertacijaILista {

    public static void main(String[] args) throws InterruptedException {

        /* Pretraga elemenata po listi prioriteta;
           Lista Web elemenata - google search button;
           Asertacija */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

       // WebElement googleBox1 = driver.findElement(By.className("gLFyf"));
       // googleBox.click();

       WebElement searchBox = driver.findElement(By.name("q"));
       searchBox.click();
       searchBox.sendKeys("Wikipedia");
       searchBox.sendKeys(Keys.ENTER);


       // Thread.sleep(2000);

        // Posto postoje dva ista "search button" dugmeta
        // (jedno ispod search boxa i drugo koje se pojavi u padajucem meniju)
        // i oba imaju istu klasu i ime - pravimo listu.
        // vazno je staviti - driver.findElementS U MNOZINI (By.name...)
        // Program treba da prodje kroz sve elemente i klikne na onaj koji je u tom trenutku vidljiv
        // (s datim imenom)

        // Thread.sleep(4000);

        List<WebElement> searchButton = driver.findElements(By.name("btnK"));
        searchButton.get(1).click();   //- PROBLEM je sto ovo malo radi, malo ne radi


        // Inspect Wikipedia - pojavljuje se jedna nestabilna klasa i "a href link"..
        // probacemo preko njega - By.linkText

       // WebElement wikipedia = driver.findElement(By.linkText("https://www.wikipedia.org/"));
       // wikipedia.click();

        // nece da ga pronadje, jer UZ LINK mora biti vezan bar jedan STRING
        // u slucaju kad nema pouzdanog elementa, ipak biramo nestabilnu klasu - By.className


        // WebElement wikipedia2 = driver.findElement(By.className("LC20lb MBeuO DKV0Md"));
        // wikipedia2.click();

        // Medjutim className ne moze da se sastoji od odvojenih stringova
        // zato className menjamo u - By.cssSelector, stringove spajamo tackom i jednu stavljamo na pocetak

        //Thread.sleep(2000);

       WebElement wikipedia2 = driver.findElement(By.cssSelector(".LC20lb.MBeuO.DKV0Md"));
       wikipedia2.click();

       // Thread.sleep(2000);

        // WebElement wikipedia = driver.findElement(By.partialLinkText("https://www.wikipedia.org/"));
        // wikipedia.click();

        // I By.partialLinktext zahteva da neki string stoji pored.
        // Ako vidimo link u domu, SAMO ako na kraju stoji rec ispisana belom bojom,
        // onda mozemo da koristimo tu rec,
        // i u programu pretragu vrsimo preko - linkText ili partialLinkText

        WebElement wikiSearchBox = driver.findElement(By.id("searchInput"));
        wikiSearchBox.sendKeys("Nikola Tesla");


        // Iako prikazuje da se vrednost ID-a pojavljuje 3 puta, ona se drugi put javlja vezana za for=..
        // a treci put u delu velikog teksta. Iako nije obelezena zutom i ne vidimo gde je, to smatramo nevaznim
        // (vrv pokazatelj da nije vezana za drugi ID)

        WebElement wikiSearchButton = driver.findElement(By.cssSelector(".sprite.svg-search-icon"));
        wikiSearchButton.click();

        // ASERTACIJA

        // Mozda najvazniji deo nasih testova jeste provera da li smo na pravoj stranci, tj. ASERTACIJA
        // Treba pronaci par kriterijuma premo kojima cemo to testirati (ni suvise detaljnih, ni suvise opstih)
        // To ce biti: URL, naslov i postojanje neke slike
        // (ne mora potvrda da je bas ta slika u pitanju, jer se moze menjati)
        // Tri aserta su sasvim dovoljna da bismo nesto potvrdili.. cak i dva su ok.

        // Uvozimo biblioteke za asertaciju sa Maven Repository - biblioteka TestNG
        // (ubacujemo dependecy-je, pa reload)

        // Proveravamo ocekivani URL date stranice, tako sto ga kopiramo,
        // zatim kreiramo String tog URLa,
        // kako bi program mogao da poredi dva podatka

        String expectedURL = "https://en.wikipedia.org/wiki/Nikola_Tesla";

        // Pozivamo asert funkciju, iz org.testing biblioteke koju smo uvezli
        // Assert.equals/notEquals/True
        // Prvi podatak koji se unosi je podatak koji je zaista dobijen - driver.getCurrentUrl,
        // a drugi je ocekivani podatak - expectedURL (tj. naziv naseg stringa)

        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        // Pokrecemo program, ako u konzoli pise "expected result 0", test je dobar.

        // Da bismo bili sigurni, OBARAMO test, tako sto brisemo jedno slovo iz naseg URLa (u stringu)
        // Ako je test pao, znaci da je dobar.

        // Sada proveravamo NASLOV, koraci su:

        // 1. inspect na naslov (class)
        // 2. kreiramo web-element - pageTitle

        WebElement pageTitle = driver.findElement(By.className("mw-page-title-main"));

        // 3. sada kreiramo 2 Stringa:
        // a) prvi je expectedTitle u koji kopiramo tekst - naslov:

                String expectedTitle = "Nikola Tesla";

        // b) u drugom pozivamo metodu (vrv iz NG biblioteke), koja ce da pozove tekst - naslov sa stranice.
        // Znaci kao i za URL, idemo preko get metode().. dohvati mi aktuelan URL ili naslov
        // (mogla je i samo naredba direktno, bez stringa, kao za URL):

                String actualTitle = pageTitle.getText();

        // 4. Kucamo Assert funkciju:

                Assert.assertEquals(pageTitle.getText(), expectedTitle);

        // 5. Provera ispravnosti testa, onjegovim obaranjem (brisemo slovo iz expected title)

        // Provera SLIKE ukljucuje sledece korake:
        // 1. inspect na sliku
        // 2. kreiramo web-element - pageImage
        // 3. i pozivamo Assert (tvrditi, izjaviti) samo da potvrdimo da je slika prisutna:
        //    Assert.assertTrue(pageImage.isDisplayed());
        // 4. Obaramo test radi provere, tako sto TRUE menjamo u FALSE

        WebElement pageImage = driver.findElement(By.className("infobox-image"));

        Assert.assertTrue(pageImage.isDisplayed());

        // .isDisplayed mozemo da koristimo za bilo koji element, ako nas zanima da li je prisutan ili ne;
        // npr. mogli smo da trazimo godinu ili naslov preko .isDisplayed;
        // samo za URL nema smisla, jer URL uvek postoji

        // CSS selektor ce se koristiti za neki ID ili klasu; u krajnjem slucaju mozemo koristiti i x-path;
        // on se u trenutku kreiranja testa moze pokazati kao dobar, ali bi ga trebalo kasnije zameniti,
        // jer je nestabilan

        // Ovo testiranje sprovodi QA analyst - nema veze sa stvaranjem proizvoda, vec testira finalni;
        // Radi se s onim sto imamo, nema dogovaranja s developerima.
        // Kada se radi na projektu gde ima kontakta s dev., onda oni mogu ubaciti dataTestID,
        // i njega pretrazujemo preko CSS selektora






        Thread.sleep(2000);
        driver.close();


    }
}
