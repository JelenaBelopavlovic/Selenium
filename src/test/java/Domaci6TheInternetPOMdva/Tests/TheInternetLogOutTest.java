package Domaci6TheInternetPOMdva.Tests;

import Domaci6TheInternetPOMdva.Base.TheInternetBaseTest;
import Domaci6TheInternetPOMdva.Pages.TheInternetLogInPage;
import Domaci6TheInternetPOMdva.Pages.TheInternetLogOutPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TheInternetLogOutTest extends TheInternetBaseTest {

    @BeforeMethod
    public void pageSetUp() {

        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get(homeURL);

        theInternetLogInPage = new TheInternetLogInPage();
        theInternetLogOutPage = new TheInternetLogOutPage();

    }


    @Test(priority = 10)
    public void userCanLogOut() {

        theInternetLogInPage.enterUsername(excelReader2.getStringData("LogIn", 1, 0));
        theInternetLogInPage.enterPassword(excelReader2.getStringData("LogIn", 1,1));
        theInternetLogInPage.clickOnLogInButton();

        String expectedURL = "https://the-internet.herokuapp.com/secure";

        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertEquals(theInternetLogOutPage.getNotificationLoggedInText(), "You logged into a secure area!\n" + "×");
        Assert.assertTrue(theInternetLogOutPage.LogOutButton.isDisplayed());

        theInternetLogOutPage.clickOnLogOutButton();

        String expectedURL2 = "https://the-internet.herokuapp.com/login";

        Assert.assertEquals(driver.getCurrentUrl(), expectedURL2);
        Assert.assertEquals(theInternetLogInPage.getNotificationLoggedOutText(), "You logged out of the secure area!\n" + "×");
        Assert.assertTrue(theInternetLogInPage.LogInButton.isDisplayed());

    }

    @AfterMethod
    public void thearDown() {

        driver.manage().deleteAllCookies();
        driver.quit();

    }


}
