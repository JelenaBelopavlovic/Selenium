package Selenium;

import org.testng.annotations.*;

public class Selenium10Anotacije {

    // Anotacije su deo TestNG biblioteke, one oznacavaju odredjene delove koda,
    // i pomocu njih mozemo da napravimo redosled kojim se izvrsavaju metode
    // Kada koristimo anotacije, vise nam ne treba main metoda.
    // Svaka pocinje sa @, i ona je kao neki hashtag za metodu na koju se odnosi,
    // i koja se pise u sledecem redu

    // Ovo moze biti pitanje na itervjuu - poredjati anotacije redosledom izvrsavanja.

    // Testove mozemo pokrenuti jedan po jedan, ili gore, sve odjednom, da se redom izvrsavaju.

    // Prioritete pisemo pored anotacija. Bolje je u dvocifrenim brojevima, jer cemo lakse moci da ubacimo
    // neki novi test.
    // Ako negde ne stavimo prioritet, ta metoda ima default vrednot koja je 0, tj. prva ce se izvrsiti.

    // V. kaze: poenta je da testovi budu nezavisni jedan od drugog. Da se samostalno izvrsavaju.

    @BeforeClass   // ova metoda se izvrsava SAMO JEDNOM na pocetku
    public void beforeClass() {

        System.out.println("Ispis iz before class.");

    }

    @BeforeMethod       // ova metoda se izvrsava PRE SVAKE TEST metode
                        // (izvrsice se onoliko puto koliko test metoda imamo)
    public void beforeMethod() {

        System.out.println("Ispis iz before method.");

    }

    @Test (priority = 30)
    public void test1() {

        System.out.println("Ispis iz test1.");

    }

    @Test (priority = 10)
    public void test2() {

        System.out.println("Ispis iz test2.");

    }

    @Test (priority = 20)
    public void test3() {

        System.out.println("Ispis iz test3.");

    }

    @Test (priority = 24)
    public void test4() {

        System.out.println("Ispis iz test4.");

    }

    @AfterMethod        // ova metoda se izvrsava NAKON SVAKE TEST metode
    public void afterMethod() {

        System.out.println("Ispis iz after metod.");

    }

    @AfterClass    // ova metoda se izvrsava SAMO JEDNOM na kraju
    public void afterClass() {

        System.out.println("Ispis iz after class.");

    }




}
