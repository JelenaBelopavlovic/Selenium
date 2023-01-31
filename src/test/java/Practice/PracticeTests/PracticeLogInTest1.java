package Practice.PracticeTests;

import Practice.PracticeBase.PracticeBaseTest1;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeLogInTest1 extends PracticeBaseTest1 {   // OVDE EXTENDUJEMO BASE PACKAGE!

    // Uvek pri kreiranju testova imati sajt ispred sebe,
    // ne pisati korake napamet!

    // Kada test ne prolazi - izmeniti redosled asertova; ubaciti wdwait

    @BeforeMethod
    public void pageSetup() {

        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/");
    }

    public void loginToProfilePage() {  // Da li je ok ovako iskopirato jedan Test u pomocnu metodu?

        practiceSidebarPage1.clickOnPracticeButton();
        practicePracticePage1.clickOnLoginPageButton();
        practiceLoginPage1.insertUsername("student");
        practiceLoginPage1.insertPassword("Password123");
        practiceLoginPage1.clickOnSubmitButton();
        Assert.assertTrue(practiceProfilePage1.getLogOutButton().isDisplayed());

    }

    @Test
    public void userCanLogIn() {   // Ovde POZIVAMO stranicu, pa METODU kreiranu unutar nje


        practiceSidebarPage1.clickOnPracticeButton();   // Sada smo unutar nove stranice - Practice,
                                                        // pa se vracamo da je kreiramo u Pages package
        practicePracticePage1.clickOnLoginPageButton(); //ovde sad NE zovemo getere, nego nazive nasih metoda!
        practiceLoginPage1.insertUsername("student");
        practiceLoginPage1.insertPassword("Password123");
        practiceLoginPage1.clickOnSubmitButton();
        Assert.assertTrue(practiceProfilePage1.getLogOutButton().isDisplayed());

        // I u asertaciji ne pozivamo obican web element,
        // vec naglasavamo o kojoj stranici je rec,
        // pozivamo odgovarajucu get metodu
        // i pisemo "radnju"

        // OVDE JE GLAVNA IDEJA - AUTOMATIZOVATI NASE TEST CASE-VE.
        // OVI KORACI ISPISANI UNUTAR METODE "USER CAN LOG IN", SU USTVARI KORACI IZ TEST CASE-VA
        // (ZATO TAKO NAZIVAMO METODE).
        // TAKODJE, DALEKO JE PREGLEDNIJE OD MALOPREDJASNJEG NACINA TESTIRANJA

    }


    @Test
    public void userCantLoginWithWrongUsername() {

        practiceSidebarPage1.clickOnPracticeButton();
        practicePracticePage1.clickOnLoginPageButton();
        practiceLoginPage1.insertUsername("user");
        practiceLoginPage1.insertPassword("Password123");
        practiceLoginPage1.clickOnSubmitButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");
        Assert.assertTrue(practiceLoginPage1.getNotification().isDisplayed());
    }

    @Test
    public void userCantLoginWithWrongPassword() {

        practiceSidebarPage1.clickOnPracticeButton();
        practicePracticePage1.clickOnLoginPageButton();
        practiceLoginPage1.insertUsername("student");
        practiceLoginPage1.insertPassword("Password");
        practiceLoginPage1.clickOnSubmitButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");
        Assert.assertTrue(practiceLoginPage1.getNotification().isDisplayed());

    }

    @Test
    public void userCantLoginWithEmptyUsernameField() {

        practiceSidebarPage1.clickOnPracticeButton();
        practicePracticePage1.clickOnLoginPageButton();
        practiceLoginPage1.getUsernameField().clear();
        practiceLoginPage1.insertPassword("Password123");
        practiceLoginPage1.clickOnSubmitButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");
        Assert.assertTrue(practiceLoginPage1.getNotification().isDisplayed());

    }

    @Test
    public void userCantLoginWithEmptyPasswordField() {

        practiceSidebarPage1.clickOnPracticeButton();
        practicePracticePage1.clickOnLoginPageButton();
        practiceLoginPage1.insertUsername("student");
        practiceLoginPage1.getPasswordField().clear();
        practiceLoginPage1.clickOnSubmitButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");
        wdwait.until(ExpectedConditions.visibilityOf(practiceLoginPage1.getNotification()));
        Assert.assertTrue(practiceLoginPage1.getNotification().isDisplayed());
    }

    @Test
    public void userCantLoginWithBothEmptyFields() {

        practiceSidebarPage1.clickOnPracticeButton();
        practicePracticePage1.clickOnLoginPageButton();
        practiceLoginPage1.getUsernameField().clear();
        practiceLoginPage1.getPasswordField().clear();
        practiceLoginPage1.clickOnSubmitButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");
        Assert.assertTrue(practiceLoginPage1.getNotification().isDisplayed());
    }

    @AfterMethod
    public void closing() {

       // driver.close();   NESTO NE RADI S OVOM METODOM
    }


}
