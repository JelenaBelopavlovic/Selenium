package Practice.PracticePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class PracticePracticePage1 { // U naziv klase stavljamo:
                                     // ime projekta, ime stranice (sad slucajno isto) i rec stranica

    public WebDriver driver;
    public WebDriverWait wdwait;

    WebElement loginPageButton;      // imena web elemenata, malim slovom
    WebElement exceptionsButton;

    public PracticePracticePage1(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getLoginPageButton() {
        return driver.findElement(By.linkText("Test Login Page"));
    }

    public WebElement getExceptionsButton() {
        return driver.findElement(By.linkText("Test Exceptions"));
    }

    //----------------------------------------------------------

  //  @Test
  // OVDE NE PISEMO ANOTACIJE!
  // SAMO METODE KOJE CEMO POZIVATI U ANOTIRANIM METODAMA U lOGINTESTS KLASI

    public void clickOnLoginPageButton() {    // METODE NAZIVAMO PREMA AKCIJAMA

         // loginPageButton.click();
        // NE MOZE OVAKO.. NE POZIVAMO SAMO ELEMENT, JER JE PUTANJA ODREDJENA U GETERU
        // ZATO POZIVAMO GET METODU!

        getLoginPageButton().click();

    }

    public void clickOnExceptionsButton() {

        getExceptionsButton().click();       // SADA PRE PISANJA TESTA, IDEMO U BASE KLASU,
                                            // DA UBACIMO I OVU STRANICU.
                                            // Zatim pozivamo stranicu i metod
                                           // unutar kreiranog LogIn testa u LogInTest klasi
    }





}
