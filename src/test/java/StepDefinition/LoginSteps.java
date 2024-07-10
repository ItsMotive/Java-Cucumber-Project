package StepDefinition;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.loginPage;

public class LoginSteps {

    WebDriver driver = null;
    loginPage input;

    @Given("user is on login page")
    public void user_is_on_login_page() {

        try {
            System.out.println("Inside Step - user is on login page.");

            System.getProperty("webdriver.chrome.driver", "src/test/java/alv/resources/chromedriver.exe");

            driver = new ChromeDriver();

            driver.navigate().to("https://practicetestautomation.com/practice-test-login/");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));

            String pageHeader = driver.findElement(By.xpath("//*[@id=\"login\"]/h2")).getText();

            assertEquals(pageHeader, "Test login");

        } catch (Exception e) {
            driver.close();
            driver.quit();
        }
    }

    @When("user enters username and password")
    public void user_enters_username_and_password() {

        input = new loginPage(driver);

        System.out.println("Inside Step - user enters username and password.");

        input.enterUsername("student");
        input.enterPassword("Password123");
    }

    @When("^user enters (.*) and (.*) parameter")
    public void enterUserPassParam(String username, String password) {

        input = new loginPage(driver);

        System.out.println("Inside Step - user enters username and password.");

        input.enterUsername(username);
        input.enterPassword(password);
    }

    @And("^user clicks on login button$")
    public void clicks_on_login_button() {

        System.out.println("Inside Step - user clicks on login button.");

        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
    }

    @Then("user is navigated to the home page")
    public void user_is_navigated_to_the_home_page() {

        input = new loginPage(driver);

        try {

            System.out.println("Inside Step - user is navigated to homepage.");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

            assertEquals(input.getSuccessLoginPageMessage(), "Logged In Successfully");

        } finally {
            driver.close();
            driver.quit();
        }
    }

    @Then("user sees user error popup")
    public void navigatedToUserError() {

        try {
            System.out.println("Inside Step - user sees user error.");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

            String error = driver.findElement(By.xpath("//*[@id=\"error\"]"))
                    .getText();

            assertEquals(error, "Your username is invalid!");

        } finally {
            driver.close();
            driver.quit();
        }

    }

    @Then("user sees pass error popup")
    public void navigatedToPassError() {

        try {
            System.out.println("Inside Step - user sees pass error.");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

            String error = driver.findElement(By.xpath("//*[@id=\"error\"]"))
                    .getText();

            assertEquals(error, "Your password is invalid!");

        } finally {

            driver.close();
            driver.quit();
        }

    }
}