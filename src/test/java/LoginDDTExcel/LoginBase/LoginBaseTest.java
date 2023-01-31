package LoginDDTExcel.LoginBase;

import LoginDDTExcel.LoginPages.LoginLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class LoginBaseTest {

    // Sada zelimo da sprovodimo testove koristeci DDT - data driven tests.
    // Zelimo dokument gde cemo svrstati sve svoje podatke, bilo da su u pitanju URLovi, usernameovi, sifre..
    // Sve sto saljemo od podataka, hocemo da se nalazi u tom jednom dokumentu.
    // Tj. hocemo da pozivamo podatke iz tog dokumenta (stringove npr.).
    // Ideja je da se kreira klasa - Excel dokument, tj. Excel reader

    // Primena metoda iz Excel reader klase:
    // Excel reader nam omogucava da mozemo da posaljemo lokaciju gde nam se nalaze podaci,
    // i odatle da ih izvlacimo.
    // Mozemo da posaljemo: String, integer;
    // Last row metoda sluzi ako budemo imali petlju, da kazemo dokle ta petlja ide.

    //JAKO VAZNO - SAVE-OVATI SVE UNOSE U EXCEL TABELU NA NASEM DESKTOPU! Nece ih Excel dokument sam zapamtiti.

    // (Excel reader i petlje su narocito korisne za regitracije.
    // Npr. postoje uslovi koliko i kakvih karaktera treba da ima,
    // mozemo da stavimo da je ispunjen jedan uslov, pa dva, pa tri.. i da kombinujemo.)

    // Kada hocemo da testiramo PRAZNO POLJE, napraviti poseban test za to,
    // izgleda da ne moze preko excel readera.

    // II NACIN DA SE URADI OVAJ ZADATAK (okaceno na drive), jeste preko anotacija @FindBy.
    // On podrazumeva da izmenimo/dodamo:
    // 1. u Base klasi, public STATIC WebDriver driver;
    // 2. Da svi Pagevi + Test klasa, nasledjuju Base klasu
    // 3. Da se kreira drugaciji konstruktor za stranicu (umesto za web elemente)
    //    - poziva se PageFactory, da bismo mogli da inicijalizujemo elemente
    // 3. Da se umesto getera, elementi pronalaze preko anotacija @FindBy.
    // Primer
    // Konstruktor:
    // public SidebarPage() {PageFactory.initElements(driver, this);}
    //
    // Elementi, preko anotacija:
    //    public @FindBy (id = "menu-item-20")
    //    WebElement PracticeButton;

    //    TRY CATCH metoda funkcionise samo ako se putem anotacija pronalaze elementi:
    //    public boolean isDisplayed(WebElement element) {
    //        boolean webelement = false;
    //        try {
    //            webelement = element.isDisplayed();
    //        } catch (Exception e) {
    //
    //        }
    //        return webelement;
    //    }


    public WebDriver driver;
    public WebDriverWait wdwait;

    public ExcelReader excelReader;  // 1. deklarisemo
    public String homeURL;  // 3. deklarisemo

    public LoginLoginPage loginLoginPage; // Objekat pravi u LoginTest klasi, u BeforeMethod;
    // Kada je radio zadatak na drugi nacin, objekat je pravio unutar samih stranica - LoginPage

    @BeforeClass
    public void setUp() throws IOException {  // i kod nega je ubaceno ovo throws IOException

        WebDriverManager.chromedriver().setup();   // NE ZABORAVI WEB DRIVER MANAGER
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        excelReader = new ExcelReader("C:\\Users\\Administrator\\Desktop\\TestData.xlsx");
        // 2. Kreiramo objekat.
        // Ovde ubacujemo string path, tako sto na excel dokument idemo:
        // properties, kopiramo, pa ovde paste ovde Location,
        // na kraju dodajemo dva slesa, naziv dokumenta i ekstenziju xlsx
        // (ekstenziju za excel fajlove)

        homeURL = excelReader.getStringData("URL", 1, 0);

        // 4. Kreiramo objekat.
        // Sada kada hocemo da izvucemo neki podatak, pozovemo excel reader,
        // zatim njegovu metodu - getStringData ili integer,
        // i potom prosledimo informacije: SHEET name, row number i cell number.
        // Row brojimo odozgo nadole, cell s leve na desnu stranu (0).
        // I rows i cells su indexirani, tako da ne krecu od 1 kao sto pise u excelu, vec od 0.

        // Sada program preko excel readera pronalazi dokument s tim imenom,
        // unutar njega sheet s datim imenom, i celiju u navedenom redu s tim brojem


    }

    @AfterClass
    public void tearDown() {

       // driver.manage().deleteAllCookies();
       // driver.quit();



    }




}
