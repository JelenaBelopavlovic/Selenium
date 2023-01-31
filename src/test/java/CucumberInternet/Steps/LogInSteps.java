package CucumberInternet.Steps;

import CucumberInternet.Pages.TheInternetLogInPage;
import Domaci6TheInternetPOMdva.Base.TheInternetBaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LogInSteps extends TheInternetBaseTest {

    @Given("User is on login page")
    public void userIsOnLogInPage() {
      //  theInternetLogInPage.logIn();
    }

    @When("User inserts username")
    public void userInsertsUsername() {
        theInternetLogInPage.enterUsername("tomsmith");
    }

    @When("User inserts password")
    public void userInsertsPassword() {
        theInternetLogInPage.enterPassword("SuperSecretPassword!");
    }


}
