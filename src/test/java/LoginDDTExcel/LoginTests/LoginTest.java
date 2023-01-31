package LoginDDTExcel.LoginTests;

import LoginDDTExcel.LoginBase.LoginBaseTest;
import LoginDDTExcel.LoginPages.LoginLoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends LoginBaseTest {

    @BeforeMethod
    public void setUpPage() {

        driver.manage().window().maximize();
        loginLoginPage = new LoginLoginPage(driver);

    }

    public void logIn() {


    }

    @Test
    public void userCanLogin() {  // izvlacimo podatke iz excel dokumenta

        String validUsername = excelReader.getStringData("Login", 1, 0);
        String validPassword = excelReader.getStringData("Login", 1,1);


        loginLoginPage.insertUsername(validUsername);
        loginLoginPage.insertPassword(validPassword);
        loginLoginPage.clickOnSubmitButton();

    }

    @Test
    public void userCanNotLogInWithInvalidUsername() {

        // Sad pravimo petlju koja ce iz excel dokumenta uzeti svaki put po jedan invalid username.

        for(int i=1; i<excelReader.getLastRow("Login"); i++) {   // OVDE TACKA ZAREZ!
            // posto nam invalid username-ovi idu od 1. do 4. reda, i "i = 1", tj. krecemo od 1 u petlji

            String invalidUsername = excelReader.getStringData("Login", i, 2);
            // ovde menjamo rowNumber iz 1 u i, jer treba da prolazi kroz redove.. 1., 2., 3...
            String validPassword = excelReader.getStringData("Login", 1, 1);


            loginLoginPage.insertUsername(invalidUsername);
            loginLoginPage.insertPassword(validPassword);
            loginLoginPage.clickOnSubmitButton();

            Assert.assertTrue(loginLoginPage.getSubmitButton().isDisplayed());

            // Ako radimo s kolonama koje imaju vise redova od ostalih, treba ih staviti u novi sheet.

        }

    }

    @Test
    public void userCanNotLogInWithInvalidPassword() {

        for(int i=1; i<excelReader.getLastRow("Login"); i++) {

            String validUsername = excelReader.getStringData("Login", 1, 0);

            String invalidPassword = excelReader.getStringData("Login", i, 3);


            loginLoginPage.insertUsername(validUsername);
            loginLoginPage.insertPassword(invalidPassword);
            loginLoginPage.clickOnSubmitButton();

            Assert.assertTrue(loginLoginPage.getSubmitButton().isDisplayed());
        }

    }

    @Test
    public void userCanNotLogInWithInvalidUsernameAndPassword() {

        for(int i=1; i<excelReader.getLastRow("Login"); i++) {

            String invalidUsername = excelReader.getStringData("Login", i, 2);

            String invalidPassword = excelReader.getStringData("Login", i, 3);


            loginLoginPage.insertUsername(invalidUsername);
            loginLoginPage.insertPassword(invalidPassword);
            loginLoginPage.clickOnSubmitButton();

            Assert.assertTrue(loginLoginPage.getSubmitButton().isDisplayed());
        }

    }






}
