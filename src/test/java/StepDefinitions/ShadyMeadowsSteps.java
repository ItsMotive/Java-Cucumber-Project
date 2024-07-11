package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import DriverManager.DriverManager;
import PageFactory.ShadyMeadows_PF;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShadyMeadowsSteps {

    WebDriver driver;

    // Constructor to initialize driver
    public ShadyMeadowsSteps() {
        this.driver = DriverManager.getDriver();
        homepage = new ShadyMeadows_PF(driver);
    }

    ShadyMeadows_PF homepage;

    // -------------------- Universal Gherkin Action -------------------- //

    // Opens and verifies website
    @Given("user is on website")
    public void verifyWebsite() {
        driver.get("https://automationintesting.online/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));

        homepage.validatePage();
    }

    // -------------------- TC01 Gherkin Actions -------------------- //

    // TC01: Sends keys to name input
    @When("^user enters contact name (.*)")
    public void enterContactName(String name) {

        homepage.sendContactName(name);
    }

    // TC01: Sends keys to contact email input
    @And("^user enters contact email (.*)")
    public void enterContactEmail(String email) {

        homepage.sendContactEmail(email);
    }

    // TC01: Sends keys to contact phone input
    @And("^user enters contact phone (.*)")
    public void enterContactPhone(String phone) {

        homepage.sendContactPhone(phone);
    }

    // TC01: Sends keys to contact subject input
    @And("^user enters contact subject (.*)")
    public void enterContactSubject(String subject) {

        homepage.sendContactSubject(subject);
    }

    // TC01: Sends keys to contact message input
    @And("^user enters contact message (.*)")
    public void enterContactDesc(String description) {

        homepage.sendContactDesc(description);
    }

    // TC01: Sends keys to contact email input
    @And("user clicks on contact submit")
    public void clickContactSubmit() {

        homepage.clickContactSubmit();
    }

    // TC01: Successful contact interaction message
    @Then("user is prompted with thanks message")
    public void validateThanksMessage() {

        homepage.validateContactConfirmation();
    }

    // -------------------- TC02 Gherkin Actions -------------------- //

    @When("^user clicks on booking button")
    public void clickOpenBookingButton() {
        homepage = new ShadyMeadows_PF(driver);

        homepage.clickOpenBookingButton();
    }

    @And("^user enters booking first name (.*)")
    public void enterBookingFirstNameInput(String firstname) {
        homepage = new ShadyMeadows_PF(driver);

        homepage.sendBookingFirstnameInput(firstname);
    }

    @And("^user enters booking last name (.*)")
    public void enterBookingLastNameInput(String lastname) {
        homepage = new ShadyMeadows_PF(driver);

        homepage.sendBookingLastnameInput(lastname);
    }

    @And("^user enters booking email (.*)")
    public void enterBookingEmailInput(String email) {
        homepage = new ShadyMeadows_PF(driver);

        homepage.sendBookingEmailInput(email);
    }

    @And("^user enters booking phone (.*)")
    public void enterBookingPhoneInput(String phone) {
        homepage = new ShadyMeadows_PF(driver);

        homepage.sendBookingPhoneInput(phone);
    }

    @And("^user clicks and drags the days requesting")
    public void selectBookingDays() {
        homepage = new ShadyMeadows_PF(driver);

        homepage.selectDays();
    }

    @And("^user clicks on book button")
    public void clickBookingButton() {
        homepage = new ShadyMeadows_PF(driver);

        homepage.clickBookRoomButton();
    }

    @Then("^user sees popup of confirmation")
    public void validateBookingConfirmation() {
        homepage = new ShadyMeadows_PF(driver);
    }

}
