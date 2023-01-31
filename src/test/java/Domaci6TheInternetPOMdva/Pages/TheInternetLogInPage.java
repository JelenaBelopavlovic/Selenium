package Domaci6TheInternetPOMdva.Pages;

import Domaci6TheInternetPOMdva.Base.TheInternetBaseTest;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TheInternetLogInPage extends TheInternetBaseTest {

     public TheInternetLogInPage () {

         PageFactory.initElements(driver, this);
     }

     public @FindBy (id = "username")
     WebElement UsernameField;

     public @FindBy (id = "password")
     WebElement PasswordField;

     public @FindBy (className = "radius")
     WebElement LogInButton;

     public @FindBy (id = "flash-messages")
     WebElement NotificationLoggedOut;

     public @FindBy (id = "flash-messages")
     WebElement NotificationInvalid;


     //----------------------------------

    public void enterUsername(String username) {
        UsernameField.clear();
        UsernameField.sendKeys(username);

    }

    public void enterPassword(String password) {
        PasswordField.clear();
        PasswordField.sendKeys(password);

    }

    public void clickOnLogInButton() {

        LogInButton.click();
    }

    public String getNotificationLoggedOutText() {

        return NotificationLoggedOut.getText();
    }

    public String getNotificationInvalidText() {  // Kod GET TEXT, izgleda da mora da bude String, i return!

        return NotificationInvalid.getText();
    }



}
