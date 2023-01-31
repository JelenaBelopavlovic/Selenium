package DemoQA.DemoQABase.DemoQATests;/* package DemoQATests;

import DemoQA.DemoQABase.DemoQABaseTest;
import DemoQA.DemoQAPages.HomePage;
import DemoQA.DemoQAPages.SidebarPage;
import DemoQABase.DemoQABaseTest;
import DemoQAPages.HomePage;
import DemoQAPages.SidebarPage;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoQABookstore extends DemoQABaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        homePage = new HomePage(driver, wdwait);
        sidebarPage = new SidebarPage(driver, wdwait); //362c8c84-7846-4bcd-9625-ef0df047ff54
    }

    public void logIn(String userId, String username2, String token, String expires) {
        Cookie userID = new Cookie("userID", userId);
        Cookie username = new Cookie("userName", username2);
        Cookie token = new Cookie("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6ImRyYWdvbGp1YnFhIiwicGFzc3dvcmQiOiJRd2VydHkxMjMhQCMiLCJpYXQiOjE2NzM5MDIxMTh9.ANWhSfME__ZjZkor8DsrtLeTsGaJLc0JnV80EIEQWeU");
        Cookie expires = new Cookie("expires", "2023-01-23T20%3A48%3A38.913Z");
        driver.manage().addCookie(userID);
        driver.manage().addCookie(username);
        driver.manage().addCookie(token);
        driver.manage().addCookie(expires);
        driver.navigate().refresh();
    }

    @Test
    public void test1() {
        scrollIntoView(homePage.getCards().get(5));  // I ovde pozivamo skrol i ubacujemo broj elementa
        homePage.clickOnBookstore();
        logIn("362c8c84-7846-4bcd-9625-ef0df047ff54", "362c8c84-7846-4bcd-9625-ef0df047ff54");
        scrollIntoView(sidebarPage.getButtons().get(sidebarPage.getButtons().size()-1));
                                                                // da skrola na poslednji element
        sidebarPage.clickOnButton("Profile");
    }
} */
