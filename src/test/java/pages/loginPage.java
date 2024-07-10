package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {

    WebDriver driver;

    By username_input = By.cssSelector("input[id='username']");
    By password_input = By.cssSelector("input#password");

    By success_login = By.cssSelector("h1.post-title");

    // Constructor
    public loginPage(WebDriver driver) {

        this.driver = driver;
    }

    // Enters username
    public void enterUsername(String username) {

        driver.findElement(username_input).sendKeys(username);
    }

    // Enters password
    public void enterPassword(String password) {

        driver.findElement(password_input).sendKeys(password);
    }

    // Successful Login Page
    public String getSuccessLoginPageMessage() {

        return driver.findElement(success_login).getText();
    }
}
