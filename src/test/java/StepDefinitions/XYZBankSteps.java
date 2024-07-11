package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import DriverManager.DriverManager;
import PageFactory.XYZBank_PF;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class XYZBankSteps {

    // Creates Instance Driver
    WebDriver driver;

    // Creates Instance PageFactory
    XYZBank_PF banking_pages;

    // Constructor to initialize driver and page factory
    public XYZBankSteps() {
        this.driver = DriverManager.getDriver();
        banking_pages = new XYZBank_PF(driver);
    }

    // -------------------- Global Gherkin Actions -------------------- //

    @Given("user is on banking login")
    public void userIsOnLoginPage() {
        System.out.println("Given Step: User is on Login Page");

        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        banking_pages.validateHomePage();

    }

    // -------------------- TC01 Gherkin Actions -------------------- //

    @When("user clicks on customer login")
    public void userClicksOnCustomerLogin() {
        System.out.println("When Step: User clicks on customer login button");

        banking_pages.clickCustomerLoginButton();
    }

    @And("^user selects (.*) profile")
    public void userClicksDropDown(String user) {
        System.out.println("And Step: User clicks on drop down object");

        banking_pages.selectDropDownOption(user);
    }

    @And("user clicks on bank login")
    public void userClicksOnLoginButton() {
        System.out.println("And Step: User clicks on login button");

        banking_pages.clickUserLoginButton();
    }

    @Then("user should be navigated to welcome page")
    public void validateSuccessfulLogin() {
        System.out.println("Then Step: User is navigated to customer homepage");

        banking_pages.validateUserLogin();
    }

    // -------------------- TC02 Gherkin Actions -------------------- //

}
