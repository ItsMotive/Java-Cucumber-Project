package StepDefinition;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchSteps {

    WebDriver driver = null;

    @Given("browser is open")
    public void openBrowser() {
        System.out.println("Inside Step - Browser is open.");
        System.getProperty("webdriver.chrome.driver", "src/test/java/alv/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));

        driver.manage().window().maximize();
    }

    @Given("user is on google search page")
    public void validateGooglePage() {
        System.out.println("Inside Step - User is on Google search page.");

        driver.navigate().to("https://www.google.com");
    }

    @When("user enters a text in search page")
    public void enterText() {
        System.out.println("Inside Step - User enters text into search bar.");

        driver.findElement(By.name("q")).sendKeys("Automation Step by Step");

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
    }

    @When("hits enter")
    public void clickEnter() {
        System.out.println("Inside Step - User clicks enter.");

        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
    }

    @Then("user is navigated to search results")
    public void validateSearchResults() {
        System.out.println("Inside Step - User is navigated to search results.");

        boolean validate = driver.getPageSource().contains("Online Courses");

        assertEquals(validate, true);

        driver.close();
        driver.quit();
    }
}
