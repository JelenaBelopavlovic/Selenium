package LoginDDTExcel.LoginPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginLoginPage {

    public WebDriver driver;

    WebElement usernameField;
    WebElement passwordField;
    WebElement submitButton;

    public LoginLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUsernameField() {
        return driver.findElement(By.id("username"));
    }

    public WebElement getPasswordField() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getSubmitButton() {
        return driver.findElement(By.id("submit"));
    }

    //-------------------------------------------

    public void insertUsername(String username) {

        getUsernameField().clear();
        getUsernameField().sendKeys(username);
    }

    public void insertPassword(String password) {

        getPasswordField().clear();
        getPasswordField().sendKeys(password);

    }

    public void clickOnSubmitButton() {

        getSubmitButton().click();
    }




}
