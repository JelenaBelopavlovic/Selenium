package Domaci5POMWordpress.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WordpressLogInPage {

    public WebDriver driver;
    public WebDriverWait wdwait;

    WebElement emailField;
    WebElement continueButton;
    WebElement passwordField;
    WebElement logInButton;


    public WordpressLogInPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getEmailField() {
        return driver.findElement(By.id("usernameOrEmail"));
    }

    public WebElement getContinueButton() {
        return driver.findElement(By.cssSelector(".button.form-button.is-primary"));
    }

    public WebElement getPasswordField() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getLogInButton() {
        return driver.findElement(By.className("login__form-action"));
    }

    //------------------------------------------------------------------

    public void enterEmailOrUsername(String email) {

        getEmailField().clear();
        getEmailField().sendKeys(email);

    }

    public void clickOnContinueButton() {

        getContinueButton().click();
    }

    public void enterPassword(String password) {

        getPasswordField().clear();
        getPasswordField().sendKeys(password);
    }

    public void clickOnLogInButton() {

        getLogInButton().click();

    }



}
