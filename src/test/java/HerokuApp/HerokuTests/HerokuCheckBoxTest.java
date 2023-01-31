package HerokuApp.HerokuTests;

import HerokuApp.HerokuBase.HerokuBaseTest;
import HerokuApp.HerokuPages.HerokuCheckboxesPage;
import HerokuApp.HerokuPages.HerokuHomePage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HerokuCheckBoxTest extends HerokuBaseTest {


    @BeforeMethod
    public void setUpPage() {

        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(19));
        driver.manage().window().maximize();

        driver.get(homeURL);

        herokuHomePage = new HerokuHomePage();
        herokuCheckboxesPage = new HerokuCheckboxesPage();

    }

    public void openCheckboxesPage() {

        herokuHomePage.clickOnCheckBoxesHiperlink();

        String expectedURL = "https://the-internet.herokuapp.com/checkboxes";

        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
       // Assert.assertEquals(herokuCheckboxesPage.getTitleCheckboxesText(), "Checkboxes");


    }


    @Test (priority = 10)
    public void checkBoxesCanBeMarked() {

       openCheckboxesPage();

       if (herokuCheckboxesPage.getCheckBox1value() == true)
           herokuCheckboxesPage.CheckBox1.click();

       if (herokuCheckboxesPage.getCheckBox2value() == true)
           herokuCheckboxesPage.CheckBox2.click();


        herokuCheckboxesPage.CheckBox1.click();
        herokuCheckboxesPage.CheckBox2.click();

        Assert.assertTrue(herokuCheckboxesPage.getCheckBox1value());
        Assert.assertTrue(herokuCheckboxesPage.getCheckBox2value());

    }

    @Test (priority = 20)
    public void checkBoxesCanBeUnmarked() {

        openCheckboxesPage();

        if (herokuCheckboxesPage.getCheckBox1value() == false)
            herokuCheckboxesPage.CheckBox1.click();

        if (herokuCheckboxesPage.getCheckBox2value() == false)
            herokuCheckboxesPage.CheckBox2.click();


        herokuCheckboxesPage.CheckBox1.click();
        herokuCheckboxesPage.CheckBox2.click();

        Assert.assertFalse(herokuCheckboxesPage.getCheckBox1value());
        Assert.assertFalse(herokuCheckboxesPage.getCheckBox2value());

    }


    @AfterMethod
    public void shutDown() {

        driver.manage().deleteAllCookies();
        driver.close();

    }



}
