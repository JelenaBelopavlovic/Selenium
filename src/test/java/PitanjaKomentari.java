public class PitanjaKomentari {

    public static void main(String[] args) {

        // Pokazati Vladi slike iz Images, za notifikaciju koja se javlja u Intelliju kada se otvori..
        // da li da exclude directories or not?

        // Da li u inspect, title = ... moze da nam bude odrednica za pronalazenje elementa?
        // je l to name, ne?
        // Pretraga elementata By.partialLinkText
        // Da li CSS selektor koristimo samo kada u KLASI imamo razmake? A ne i u IDu..

        // Da li zna naredbu za skrol gore?

        // PITATI GA ZA ONE PETLJE, TRY CATCH (SELENIUM 10D ili 11); upotreba waitera i asertova

        // Kako se prave LISTE.. i prosledjuju parametri.. npr. kad hocu da dohvatim konkretan element
        // iz liste elemenata s istim IDjem i Classom?




        // Kako se prosledjuju atributi u metodama?

        // (domaci4Anotacije) Da li mogu unutar metoda s anotacijom @Test, pozivati druge metode
        // s istom anotacijom.. ili samo metode bez anotacije?

        // Kad mi pokaze plavom u konzoli gde je greska, da li tu mogu da vidim i sta je greska?
       // Po tipu exepction

        // Koliko cesto smem da koristim rebuild? Kolko hocu

        // Da li je vazno koja vrsta Assert.Equals se kuca? (Selenium 11)

        // Razlika izmedju public/static metoda?
        // I rekao je da ne moraju sve da budu void? Sta to znaci i koje jos postoje? "kad izvlacimo tekst"?
        // Cemu sluzi konstruktor?

        /* SVAKA METODA DA JE NEZAVISNA I REUSABILNA
        // metoda koja ne vraca nista je void
        // public je metoda kojoj moze da pristupo svako iz svih klasa
        // protected - pristupa joj se samo iz nasledjene klase */

        // NOVA

        // Klase iz Test package ne moram da deklarisem i inicijalizujem u Base klasi?

        // U Base package, uvek samo jedna - Base klasa?

        // Da li je praksa da se u test klasi prave i pomocne metode koje se pozivaju u anotirane ili ne?
        // ILi se ona zapravo prave u BAse klasi? ili je svejedno?

        // Ako radimo POM na I nacin, trazimo elemente preko getera, i s obzirom da tad ne fukncionise
        // tray-catch, da li je onda resenje da se prosto traze dugmici koji su prisutni?
        // Dakle mozemo samo Assert.true, ne i false?

        /* Kada pravim novi prijekat, moram rucno da kopiram dependicies iz prethodnog projekta
           u novi pom fajl.. DA */

        /* Kad trazimo neko resenje: novi tab google, "how to ... selenium java" */

        // Kada mozemo koristiti - link text? samo kad je tekst u a hrefu?

        /* D U excel readeru manje ili JEDNAKO za poslednji red.. i<=excelReader.getLastRow("LogIn"); */

        // D Kada testiramo prazno polje za Username i validan password, mi menjamo dokle ide i?
        // for (int i=1; i<2; i++)  (SwagLabs, LogInTest)
        // D Da li je ok da SVE klase extenduju Base klasu

        // for (int i=1; i<=excelReader.getLastRow("LogIn"); i++) {  NIJE IF nego FOR!!!

        // Thread.sleep(2000);
        // driver.close();


        // driver.navigate().back();
        // driver.navigate().refresh();

        // 31.01. DA LI U SVAKOJ TEST KLASI INICIJALIZUJEMO SVE PAGE KLASE?

        // css selektor ne radi u POMu 2, kada stavimo tackice, ne pronalazi element

        // znaci, kada otvorimo novu stranicu, elemente s te stranice smestamo u novu klasu?

        // PITATI VLADU ZA
        // - FIND BY SELEKTOR (TRECI NACIN - STA JE ATRIBUT, VREDNOST...), primer
        //   u swag labu, twiter dugme
        // - GitHub
        // - CV grupisanje




        // IZDVOJITI OVDE GLAVNE POMOCNE METODE, TIPA Skrol, wdwait i sl.


        // U base klasi smestamo pomocne metode.
        // Za skrol:

       /* public void scrollIntoView(WebElement element) { // ovde cemo proslediti na koji element se odnosi skrol
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element); // i ovde,
            // na kraju u zagradi
        }
        //Pomocne metode za cekanje; prosledimo im ovde da se odnose na web elemente,
        // a u test klasi na koji tacno (tj. ime web elementa)

        public void waitForVisibility(WebElement element) {
            wdwait.until(ExpectedConditions.visibilityOf(element));
        }

        public void waitForClickability(WebElement element) {
            wdwait.until(ExpectedConditions.elementToBeClickable(element));
        }

        // Metoda za vidljivost elementa ne funkcioise na ovaj nacin, nego preko anotacija.. to cemo sutra..

        public boolean elementIsDisplayed() {

            boolean displayed = false;
            try {
                displayed = element.isDIsplayed;

            } catch (Exception e) {


            }
            return displayed;


        }



*/

    }
}
