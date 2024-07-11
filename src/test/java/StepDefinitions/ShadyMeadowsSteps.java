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

    private WebDriver driver;

    public ShadyMeadowsSteps() {
        this.driver = DriverManager.getDriver();
    }

    ShadyMeadows_PF homepage;

    @Given("user is on website")
    public void verifyWebsite() {
        homepage = new ShadyMeadows_PF(driver);
        driver.get("https://automationintesting.online/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));

        homepage.validatePage();
    }

    @When("^user enters name (.*)")
    public void enterName(String name) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        homepage = new ShadyMeadows_PF(driver);

        homepage.enterName(name);
    }

    @And("^user enters email (.*)")
    public void enterEmail(String email) {
        homepage = new ShadyMeadows_PF(driver);

        homepage.enterEmail(email);
    }

    @And("^user enters phone (.*)")
    public void enterPhone(String phone) {
        homepage = new ShadyMeadows_PF(driver);

        homepage.enterPhone(phone);
    }

    @And("^user enters subject (.*)")
    public void enterSubject(String subject) {
        homepage = new ShadyMeadows_PF(driver);

        homepage.enterSubject(subject);
    }

    @And("^user enters message (.*)")
    public void enterDesc(String description) {
        homepage = new ShadyMeadows_PF(driver);

        homepage.enterDesc(description);
    }

    @And("user clicks on submit")
    public void clickSubmit() {
        homepage = new ShadyMeadows_PF(driver);

        homepage.clickSubmit();
    }

    @Then("user is prompted with thanks message")
    public void validateThanksMessage() {
        homepage = new ShadyMeadows_PF(driver);

        homepage.validateThanksMessage();
    }
}
