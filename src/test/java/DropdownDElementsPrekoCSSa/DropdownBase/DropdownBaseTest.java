package DropdownDElementsPrekoCSSa.DropdownBase;

import DropdownDElementsPrekoCSSa.DropdownPages.DropdownListPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class DropdownBaseTest {
    public static WebDriver driver;
    public WebDriverWait wdwait;
    public DropdownListPage dropdownListPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // sve tri naredne metode su kreirane u biblioteci za select

    public void selectByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void selectByText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void selectByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    /*public void deselectValue(WebElement element, String value) {
        Select select = new Select(element);
        select.deselectByValue(value);
    }*/

}
