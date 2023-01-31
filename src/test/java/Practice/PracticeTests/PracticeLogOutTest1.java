package Practice.PracticeTests;

import Practice.PracticeBase.PracticeBaseTest1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeLogOutTest1 extends PracticeBaseTest1 {

    @BeforeMethod
    public void pageSetup() {

        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/");
    }

    public void loginToProfilePage() {

        practiceSidebarPage1.clickOnPracticeButton();
        practicePracticePage1.clickOnLoginPageButton();
        practiceLoginPage1.insertUsername("student");
        practiceLoginPage1.insertPassword("Password123");
        practiceLoginPage1.clickOnSubmitButton();
        Assert.assertTrue(practiceProfilePage1.getLogOutButton().isDisplayed());

    }

    @Test
    public void userCanLogOut() {

        loginToProfilePage();   // Moramo se ulogovati da bismo testirali log out.

        practiceProfilePage1.clickOnLogOutButton();
        Assert.assertTrue(practiceLoginPage1.getUsernameField().isDisplayed());
        Assert.assertTrue(practiceLoginPage1.getPasswordField().isDisplayed());
        Assert.assertTrue(practiceLoginPage1.getSubmitButton().isDisplayed());

    }


}
