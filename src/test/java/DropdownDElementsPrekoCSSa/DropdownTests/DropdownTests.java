package DropdownDElementsPrekoCSSa.DropdownTests;

import DropdownDElementsPrekoCSSa.DropdownBase.DropdownBaseTest;
import DropdownDElementsPrekoCSSa.DropdownPages.DropdownListPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropdownTests extends DropdownBaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        dropdownListPage = new DropdownListPage();
    }

    public void landingPageAssert() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/dropdown");
        Assert.assertEquals(dropdownListPage.getPlaceholderText(), "Please select an option");
    }

    @Test
    public void selectOption1() {
        landingPageAssert();
        selectByValue(dropdownListPage.DropdownList, "1"); //jedinica je pod navodnicima jer je takva
                                                                // i u HTMLu (tj. string je)
        //selectByText(dropdownListPage.DropdownList, "Option 1");
        //selectByIndex(dropdownListPage.DropdownList, 1);
        Assert.assertEquals(dropdownListPage.getPlaceholderText(), "Option 1");
        Assert.assertEquals(dropdownListPage.Placeholder.size(), 1);
    }

    @Test
    public void selectOption2() {
        landingPageAssert();
        //selectByValue(dropdownListPage.DropdownList, "2");
        selectByText(dropdownListPage.DropdownList, "Option 2");
        //selectByIndex(dropdownListPage.DropdownList, 2);
        Assert.assertEquals(dropdownListPage.getPlaceholderText(), "Option 2");
        Assert.assertEquals(dropdownListPage.Placeholder.size(), 1);
    }

    @Test
    public void changeSelectedOption() {
        landingPageAssert();
        selectByValue(dropdownListPage.DropdownList, "1");
        Assert.assertEquals(dropdownListPage.getPlaceholderText(), "Option 1");
        Assert.assertEquals(dropdownListPage.Placeholder.size(), 1);

        selectByValue(dropdownListPage.DropdownList, "2");
        Assert.assertEquals(dropdownListPage.getPlaceholderText(), "Option 2");
        Assert.assertEquals(dropdownListPage.Placeholder.size(), 1);
    }

}
