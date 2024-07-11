package StepDefinitions;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.WebDriver;

import DriverManager.DriverManager;
import PageFactory.PracticeTestAutomationLogin_PF;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PracticeTestAutomationLoginSteps {

    WebDriver driver = null;

    public PracticeTestAutomationLoginSteps() {
        this.driver = DriverManager.getDriver();
    }

    PracticeTestAutomationLogin_PF homepage;

    @Given("user is on login homepage")
    public void userOnLoginPage() {

        System.out.println("Step 'Given': User is on login page");

        homepage = new PracticeTestAutomationLogin_PF(driver);

        driver.navigate().to("https://practicetestautomation.com/practice-test-login/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));

        homepage.homepageIsDisplayed();

    }

    @When("^user enters (.*) and (.*) valid")
    public void userEnterCredentials(String username, String password) {
        System.out.println("Step 'And': User enters credential - " + username + " | " + password);

        homepage.enterUsername(username);
        homepage.enterPassword(password);

    }

    @When("^user enters invalid (.*) and valid (.*)")
    public void userEnterInvalidUser(String username, String password) {
        System.out.println("Step 'And': User enters credential - " + username + " | " + password);

        homepage.enterUsername(username);
        homepage.enterPassword(password);

    }

    @When("^user enters valid (.*) and invalid (.*)")
    public void userEnterInvalidPass(String username, String password) {
        System.out.println("Step 'And': User enters credential - " + username + " | " + password);

        homepage.enterUsername(username);
        homepage.enterPassword(password);

    }

    @And("user clicks on login button")
    public void userClicksLogin() {
        System.out.println("Step 'When': User clicks login");

        homepage.clickLogin();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));

    }

    @Then("user is navigated to logout page")
    public void userOnLogoutPage() {
        System.out.println("Step 'Then': User is on logout page");

        homepage.logoutIsDisplayed();

    }

    @Then("user should see invalid username popup")
    public void usernameErrorPopup() {
        System.out.println("Step 'Then': User is on logout page");

        assertEquals(homepage.errorTextIsCorrect(), "Your username is invalid!");

    }

    @Then("user should see invalid password popup")
    public void passwordErrorPopup() {
        System.out.println("Step 'Then': User is on logout page");

        assertEquals(homepage.errorTextIsCorrect(), "Your password is invalid!");

    }

}
