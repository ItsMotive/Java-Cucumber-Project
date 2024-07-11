package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PracticeTestAutomationLogin_PF {

    // Locator for Username Input Box
    @FindBy(css = "input#username")
    WebElement username_input;

    // Locator for Password Input Box
    @FindBy(css = "input#password")
    WebElement password_input;

    // Locator for Login Button
    @FindBy(css = "button#submit")
    WebElement login_button;

    // Locator for Login Page Image
    @FindBy(css = "img[alt='Practice Test Automation']")
    WebElement login_title;

    // Locator for Logout Button
    @FindBy(css = "a[href='https://practicetestautomation.com/practice-test-login/']")
    WebElement logout_button;

    // Locator for Error popup
    @FindBy(css = "div#error")
    WebElement error_popup;

    // Initializes WebDriver
    WebDriver driver;

    // Constructor
    public PracticeTestAutomationLogin_PF(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        PageFactory.initElements(this.driver, this);
    }

    public boolean homepageIsDisplayed() {
        return login_title.isDisplayed();
    }

    public void enterUsername(String username) {
        username_input.sendKeys(username);
    }

    public void enterPassword(String password) {
        password_input.sendKeys(password);
    }

    public void clickLogin() {
        login_button.click();
    }

    public void logoutIsDisplayed() {
        logout_button.isDisplayed();

    }

    public String errorTextIsCorrect() {
        return error_popup.getText();
    }

}
