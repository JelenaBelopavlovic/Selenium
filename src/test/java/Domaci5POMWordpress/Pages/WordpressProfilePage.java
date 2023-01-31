package Domaci5POMWordpress.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WordpressProfilePage {

    public WebDriver driver;
    public WebDriverWait wdwait;

    WebElement profileButton;


    public WordpressProfilePage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getProfileButton() {
        return driver.findElement(By.cssSelector(".gravatar.masterbar__item-me-gravatar"));
    }
}
