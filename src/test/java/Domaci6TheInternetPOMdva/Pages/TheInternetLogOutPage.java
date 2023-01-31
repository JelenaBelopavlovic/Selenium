package Domaci6TheInternetPOMdva.Pages;

import Domaci6TheInternetPOMdva.Base.TheInternetBaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TheInternetLogOutPage extends TheInternetBaseTest {

    public TheInternetLogOutPage() {

        PageFactory.initElements(driver, this);
    }

    public @FindBy (id = "flash")
    WebElement NotificationLoggedIn;

    public static @FindBy (css = ".icon-2x.icon-signout")
    WebElement LogOutButton;

    //------------------------------------

    public String getNotificationLoggedInText() {

        return NotificationLoggedIn.getText();
    }

    public void clickOnLogOutButton() {

        LogOutButton.click();

    }



}
