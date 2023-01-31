package CucumberInternet.Pages;

import Domaci6TheInternetPOMdva.Base.TheInternetBaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TheInternetLogInPage extends TheInternetBaseTest {

    public static WebDriver driver;
     public TheInternetLogInPage () {

         PageFactory.initElements(driver, this);
     }

     public @FindBy (id = "username")
     WebElement UsernameField;

     public @FindBy (id = "password")
     WebElement PasswordField;

     public @FindBy (className = "radius")
     WebElement LogInButton;


     //----------------------------------

    public static void logIn() {

        driver.get("https://the-internet.herokuapp.com/login");
    }

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



}
