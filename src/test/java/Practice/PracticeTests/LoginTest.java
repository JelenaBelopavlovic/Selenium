/* package Practice.PracticeTests;


import Practice.PracticeBase.PracticeBaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends PracticeBaseTest {

    @BeforeMethod
    public void pageSetUp() {

        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/");
    }

    @Test
    public void userCanLogIn() {
        practiceSidebarPage.clickOnPracticeButton();
        practicePracticePage.clickOnTestLoginPageButton();
        practiceLoginPage.insertUsername("student");
        practiceLoginPage.insertPassword("Password123");
        practiceLoginPage.clickOnSubmitButton();
        Assert.assertTrue(practiceProfilePage.getLogOutButton().isDisplayed());
    }
} */


