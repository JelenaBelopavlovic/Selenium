package Practice.PracticePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticeLoginPage1 {

    // Nije mi jasno kako se nekad ne vide oznake, npr. ID, osim ako se maximalno ne prosiri prozor.

    // Ako je prilikom asserta tesko naci element, ili driver nece da ga pronadje, promeni element.

    public WebDriver driver;
    public WebDriverWait wdwait;

    WebElement usernameField;
    WebElement passwordField;
    WebElement submitButton;

    WebElement notification;

    public PracticeLoginPage1(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
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

    public WebElement getNotification() {
        return driver.findElement(By.className("show"));
    }

    //-------------------------------------------------

    public void insertUsername(String username) { // Posto necemo da zakucamo jedan username,
                                                  // ovde ubacujemo parametar
                                                  // tj. String, i nazivamo ga username

        getUsernameField().clear();    // PRVO HOCEMO DA OCISTIMO POLJE, PA DA MU POSALJEMO NEKI STRING
        getUsernameField().sendKeys(username); // ovde ubacujemo naziv parametra koji cemo kasnije proslediti
                                                // u Test klasi, u @Test anotiranoj metodi
    }

    public void insertPassword(String password) {

        getPasswordField().clear();
        getPasswordField().sendKeys(password);

    }

    public void clickOnSubmitButton() {

        getSubmitButton().click();
    }



}
