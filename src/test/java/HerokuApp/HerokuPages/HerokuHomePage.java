package HerokuApp.HerokuPages;

import HerokuApp.HerokuBase.HerokuBaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HerokuHomePage extends HerokuBaseTest {


    public HerokuHomePage() {

        PageFactory.initElements(driver, this);
    }

    public @FindBy (linkText = "Checkboxes")
    WebElement CheckboxesHiperlink;


    //------------------------------------

    public void clickOnCheckBoxesHiperlink() {

        CheckboxesHiperlink.click();

    }







}
