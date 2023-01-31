package Domaci6TheInternetPOMdva.Tests;

import Domaci6TheInternetPOMdva.Base.TheInternetBaseTest;
import Domaci6TheInternetPOMdva.Pages.TheInternetLogOutPage;
import Domaci6TheInternetPOMdva.Pages.TheInternetLogInPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TheInternetLogInTest extends TheInternetBaseTest {

    @BeforeMethod
    public void pageSetUp() {

        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get(homeURL);

        theInternetLogInPage = new TheInternetLogInPage();
        theInternetLogOutPage = new TheInternetLogOutPage();

    }

    @Test (priority = 10)
    public void userCanLogIn() {

        theInternetLogInPage.enterUsername(excelReader2.getStringData("LogIn", 1, 0));
        theInternetLogInPage.enterPassword(excelReader2.getStringData("LogIn", 1,1));
        theInternetLogInPage.clickOnLogInButton();

        String expectedURL = "https://the-internet.herokuapp.com/secure";

        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertEquals(theInternetLogOutPage.getNotificationLoggedInText(), "You logged into a secure area!\n" + "×");
        Assert.assertTrue(theInternetLogOutPage.LogOutButton.isDisplayed());

    }

    @Test (priority = 20)
    public void userCanNotLogInWithInvalidUsername() {

        for(int i=1; i< excelReader2.getLastRow("LogIn"); i++) {

            String invalidUsername = excelReader2.getStringData("LogIn", i, 2);
            String validPassword = excelReader2.getStringData("LogIn", 1,1);

            theInternetLogInPage.enterUsername(invalidUsername);
            theInternetLogInPage.enterPassword(validPassword);
            theInternetLogInPage.clickOnLogInButton();

            String expectedURL = "https://the-internet.herokuapp.com/login";

           Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

           boolean logOut = false;
           try {
               logOut = TheInternetLogOutPage.LogOutButton.isDisplayed();

           } catch (Exception e) {


           }
           Assert.assertFalse(logOut);

         Assert.assertEquals(theInternetLogInPage.getNotificationInvalidText(), "Your username is invalid!\n" + "×");

        }

        }


    @Test (priority = 30)
    public void userCanNotLogInWithInvalidPassword() {

        for(int i=1; i< excelReader2.getLastRow("LogIn"); i++) {

            String validUsername = excelReader2.getStringData("LogIn", 1, 0);
            String invalidPassword = excelReader2.getStringData("LogIn", i,3);

            theInternetLogInPage.enterUsername(validUsername);
            theInternetLogInPage.enterPassword(invalidPassword);
            theInternetLogInPage.clickOnLogInButton();

            String expectedURL = "https://the-internet.herokuapp.com/login";

            Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

            boolean logOut = false;
            try {
                logOut = TheInternetLogOutPage.LogOutButton.isDisplayed();

            } catch (Exception e) {


            }
            Assert.assertFalse(logOut);

            Assert.assertEquals(theInternetLogInPage.getNotificationInvalidText(), "Your password is invalid!\n" + "×");

        }

    }

    @Test (priority = 40)
    public void userCanNotLogInWithInvalidUsernameAndPassword() {

        for(int i=1; i< excelReader2.getLastRow("LogIn"); i++) {

            String invalidUsername = excelReader2.getStringData("LogIn", i, 2);
            String invalidPassword = excelReader2.getStringData("LogIn", i,3);

            theInternetLogInPage.enterUsername(invalidUsername);
            theInternetLogInPage.enterPassword(invalidPassword);
            theInternetLogInPage.clickOnLogInButton();

            String expectedURL = "https://the-internet.herokuapp.com/login";

            Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

            boolean logOut = false;
            try {
                logOut = TheInternetLogOutPage.LogOutButton.isDisplayed();

            } catch (Exception e) {


            }
            Assert.assertFalse(logOut);

            Assert.assertEquals(theInternetLogInPage.getNotificationInvalidText(), "Your username is invalid!\n" + "×");

        }


    }

    @Test (priority = 50)
    public void userCanNotLogInWithEmptyUsernameField() {

        String emptyUsername= "";
        String validPassword = excelReader2.getStringData("LogIn", 1,1);

        theInternetLogInPage.enterUsername(emptyUsername);
        theInternetLogInPage.enterPassword(validPassword);
        theInternetLogInPage.clickOnLogInButton();

        String expectedURL = "https://the-internet.herokuapp.com/login";

        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        boolean logOut = false;
        try {
            logOut = TheInternetLogOutPage.LogOutButton.isDisplayed();

        } catch (Exception e) {


        }
        Assert.assertFalse(logOut);

        Assert.assertEquals(theInternetLogInPage.getNotificationInvalidText(), "Your username is invalid!\n" + "×");

    }

    @Test (priority = 60)
    public void userCanNotLogInWithEmptyPasswordField() {

        String validUsername = excelReader2.getStringData("LogIn", 1, 0);
        String emptyPassword = "";

        theInternetLogInPage.enterUsername(validUsername);
        theInternetLogInPage.enterPassword(emptyPassword);
        theInternetLogInPage.clickOnLogInButton();

        String expectedURL = "https://the-internet.herokuapp.com/login";

        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        boolean logOut = false;
        try {
            logOut = TheInternetLogOutPage.LogOutButton.isDisplayed();

        } catch (Exception e) {


        }
        Assert.assertFalse(logOut);

        Assert.assertEquals(theInternetLogInPage.getNotificationInvalidText(), "Your password is invalid!\n" + "×");


    }

    @Test (priority = 70)
    public void userCanNotLogInWithBothEmptyFields() {

        String emptyUsername= "";
        String emptyPassword = "";

        theInternetLogInPage.enterUsername(emptyUsername);
        theInternetLogInPage.enterPassword(emptyPassword);
        theInternetLogInPage.clickOnLogInButton();

        String expectedURL = "https://the-internet.herokuapp.com/login";

        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        boolean logOut = false;
        try {
            logOut = TheInternetLogOutPage.LogOutButton.isDisplayed();

        } catch (Exception e) {


        }
        Assert.assertFalse(logOut);

        Assert.assertEquals(theInternetLogInPage.getNotificationInvalidText(), "Your username is invalid!\n" + "×");


    }

    @AfterMethod
    public void thearDown() {

       driver.manage().deleteAllCookies();
       driver.close();

    }


}
