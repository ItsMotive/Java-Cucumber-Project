package PageFactory;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.Alert;
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

    // Element for home button
    @FindBy(css = "button[ng-click = 'home()']")
    WebElement home_button;

    // -------------------- Homepage Elements -------------------- //

    // Element for customer login button
    @FindBy(css = "button[ng-click = 'customer()']")
    WebElement customer_login_button;

    // Element for manager login button
    @FindBy(css = "button[ng-click = 'manager()']")
    WebElement manager_login_button;

    // Element for home page title
    @FindBy(css = "strong.mainHeading")
    WebElement home_page_title;

    // -------------------- Customer Selection Page Elements -------------------- //

    // Element for user drop down
    @FindBy(css = "select#userSelect")
    WebElement user_drop_down;

    // Element for user login button
    @FindBy(css = "button.btn-default")
    WebElement user_login_button;

    // -------------------- Customer Page Elements -------------------- //

    // Element for logout button
    @FindBy(css = "button.logout")
    WebElement logout_button;

    // Element for successful user login
    @FindBy(css = "span.fontBig")
    WebElement user_login_title;

    // -------------------- Bank Manager Page Elements -------------------- //

    // --------- Add Customer --------- //

    // Element to add customer
    @FindBy(css = "button[ng-click='addCust()']")
    WebElement add_customer_button;

    // Element for Add First Name
    @FindBy(css = "input[ng-model='fName']")
    WebElement add_first_name;

    // Element for Add First Name
    @FindBy(css = "input[ng-model='lName']")
    WebElement add_last_name;

    // Element for Add First Name
    @FindBy(css = "input[ng-model='postCd']")
    WebElement add_postal;

    // Element for processing add customer
    @FindBy(css = "button[type='submit']")
    WebElement add_submit;

    // --------- Open Account --------- //

    // Element to open account
    @FindBy(css = "button[ng-click='openAccount()']")
    WebElement open_account_button;

    // Element to select customer option
    @FindBy(css = "select#userSelect")
    WebElement select_user_account;

    // Element to select currency option
    @FindBy(css = "select#currency")
    WebElement select_currency;

    // Element to click process
    @FindBy(css = "button[type='submit']")
    WebElement process_button;

    // --------- Show Customer --------- //

    // Element to show customer
    @FindBy(css = "button[ng-click='showCust()']")
    WebElement show_customer_button;

    // Element to search customers
    @FindBy(css = "input[ng-model='searchCustomer']")
    WebElement customer_search_bar;

    // Element to delete customer
    @FindBy(css = "button[ng-click='deleteCust(cust)']")
    WebElement delete_customer;

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

    public void clickManagerLogin() {

        manager_login_button.click();
    }

    public void clickAddCustomer() {

        add_customer_button.click();
    }

    public void addEnterFirstName(String first) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[ng-model='fName']")));

        add_first_name.sendKeys(first);
    }

    public void addEnterLastName(String last) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[ng-model='lName']")));

        add_last_name.sendKeys(last);
    }

    public void addEnterPostal(String postal) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[ng-model='postCd']")));

        add_postal.sendKeys(postal);
    }

    public void addProcessAddCustomer() {

        add_submit.click();
    }

    public void validatePopup() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        String alert_message = alert.getText();

        assertTrue(alert_message.contains("Customer added successfully"));

        alert.accept();
    }

}
