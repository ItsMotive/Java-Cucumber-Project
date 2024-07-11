package PageFactory;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class XYZBank_PF {

    // Create instance Driver
    WebDriver driver;
    String user_name;

    // Constructor to initialize driver and PageFactory
    public XYZBank_PF(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    // Prevents leaking 'this' in constructor
    private void initElements() {
        PageFactory.initElements(this.driver, this);
    }

    // -------------------- Global Elements -------------------- //

    // -------------------- TC01 Elements -------------------- //

    // Element for logout button
    @FindBy(css = "button.logout")
    WebElement logout_button;

    // Element for user drop down
    @FindBy(css = "select#userSelect")
    WebElement user_drop_down;

    // Element for user login button
    @FindBy(css = "button.btn-default")
    WebElement user_login_button;

    // Element for customer login button
    @FindBy(css = "button[ng-click = 'customer()']")
    WebElement customer_login_button;

    // Element for manager login button
    @FindBy(css = "button[ng-click = 'manager()']")
    WebElement manager_login_button;

    // Element for home button
    @FindBy(css = "button[ng-click = 'home()']")
    WebElement home_button;

    // Element for home page title
    @FindBy(css = "strong.mainHeading")
    WebElement home_page_title;

    // Element for successful user login
    @FindBy(css = "span.fontBig")
    WebElement user_login_title;

    // -------------------- Unused Functions -------------------- //

    public void clickLogoutButton() {
        logout_button.click();
    }

    // -------------------- TC01 Functions -------------------- //

    public void clickCustomerLoginButton() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[ng-click = 'customer()']")));

        customer_login_button.click();
    }

    public void clickManagerLoginButton() {
        manager_login_button.click();
    }

    public void clickHomeButton() {
        home_button.click();
    }

    public void clickUserLoginButton() {
        user_login_button.click();
    }

    public void validateHomePage() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("strong.mainHeading")));

        assertEquals(home_page_title.getText(), "XYZ Bank");
    }

    public void validateUserLogin() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.fontBig")));

        assertEquals(user_login_title.getText(), user_name);
    }

    public void selectDropDownOption(String selection) {

        user_name = selection;

        Select selector = new Select(user_drop_down);

        selector.selectByVisibleText(selection);

    }

    // -------------------- TC02 Functions -------------------- //

}
