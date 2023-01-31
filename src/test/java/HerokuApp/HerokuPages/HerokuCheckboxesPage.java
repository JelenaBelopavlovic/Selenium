package HerokuApp.HerokuPages;

import HerokuApp.HerokuBase.HerokuBaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HerokuCheckboxesPage extends HerokuBaseTest {

    public HerokuCheckboxesPage() {

        PageFactory.initElements(driver, this);
    }

    public @FindBy (linkText = "Checkboxes")
    WebElement TitleChechboxes;   // Izgleda da ne moze ovako da se nadje element,
                                   // jer tekst nije unutar a hrefa..

    public @FindBy (xpath = "/html/body/div[2]/div/div/form/input[1]")
    WebElement CheckBox1;

    public @FindBy (xpath = "/html/body/div[2]/div/div/form/input[2]")
    WebElement CheckBox2;


    // ---------------------------

    public String getTitleCheckboxesText() {

        return TitleChechboxes.getText();
    }


    public boolean getCheckBox1value() {

        return CheckBox1.isSelected();
    }

    public boolean getCheckBox2value() {

        return CheckBox2.isSelected();
    }



}
