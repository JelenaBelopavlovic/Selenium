package Domaci5POMWordpress.Tests;

import Domaci5POMWordpress.Base.WordpressBaseTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WordpressLogInTest extends WordpressBaseTest {


    @BeforeMethod
    public void setUp() {

        driver.manage().window().maximize();
        driver.get("https://wordpress.com/?apppromo");
    }

    @Test
    public void userCanLogIn() {

        wordpressHomePage.clickOnLogInButton();
        wdwait.until(ExpectedConditions.visibilityOf(wordpressLogInPage.getEmailField()));
        wordpressLogInPage.enterEmailOrUsername("jelenabelopavlovic@yahoo.com");
        wordpressLogInPage.clickOnContinueButton();
        wdwait.until(ExpectedConditions.visibilityOf(wordpressLogInPage.getPasswordField()));
        wordpressLogInPage.enterPassword("belarada4321#");
        wordpressLogInPage.clickOnLogInButton();

        String expectedURL = "https://wordpress.com/home/jecabell3.wordpress.com";
        wdwait.until(ExpectedConditions.urlToBe(expectedURL));
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertTrue(wordpressProfilePage.getProfileButton().isDisplayed());

        boolean button = false;
        try {
            button = wordpressLogInPage.getLogInButton().isDisplayed();

        } catch (Exception e) {

        }
        Assert.assertFalse(button);
    }













// Asertovi: URL, domain i LogIn button nije prikazano

}
