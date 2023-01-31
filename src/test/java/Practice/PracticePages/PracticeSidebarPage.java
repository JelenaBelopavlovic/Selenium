/* package PracticePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticeSidebarPage {

    public WebDriver driver;
    public WebDriverWait wdwait;

    WebElement homeButton;
    WebElement practiceButton;
    WebElement coursesButton;
    WebElement blogButton;
    WebElement contactButton;

    public PracticeSidebarPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getHomeButton() {
        return driver.findElement(By.linkText("Home"));
    }

    public WebElement getPracticeButton() {
        return driver.findElement(By.id("menu-item-20"));
    }

    public WebElement getCoursesButton() {
        return driver.findElement(By.linkText("Courses"));
    }

    public WebElement getBlogButton() {
        return driver.findElement(By.linkText("Blog"));
    }

    public WebElement getContactButton() {
        return driver.findElement(By.linkText("Contact"));
    }

    //------------------------------------

    public void clickOnHomeButton() {
        getHomeButton().click();
    }

    public void clickOnPracticeButton() {
        getPracticeButton().click();
    }

    public void clickOnCoursesButton() {
        getCoursesButton().click();
    }

    public void clickOnBlogButton() {
        getBlogButton().click();
    }

    public void clickOnContactButton() {
        getContactButton().click();
    }

} */

