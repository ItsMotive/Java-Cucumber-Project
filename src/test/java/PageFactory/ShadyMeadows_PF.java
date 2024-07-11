package PageFactory;

import java.time.Duration;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShadyMeadows_PF {

    WebDriver driver;

    // -------------------- Universal Element --------------------//

    // Home Page Text
    @FindBy(xpath = "/html/body/div/div/div/div[2]/div[2]/p")
    WebElement welcomeText;

    // -------------------- TC01 Elements --------------------//

    // Contact Name Input
    @FindBy(css = "input#name")
    WebElement contact_name_input;

    // Contact Email Input
    @FindBy(css = "input#email")
    WebElement contact_email_input;

    // Contact Phone Input
    @FindBy(css = "input#phone")
    WebElement contact_phone_input;

    // Contact Subject Input
    @FindBy(css = "input#subject")
    WebElement contact_subject_input;

    // Contact Description Input
    @FindBy(css = "textarea#description")
    WebElement contact_descr_input;

    // Contact Submit Button
    @FindBy(css = "button#submitContact")
    WebElement contact_submit_button;

    // Contact Success Message
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[5]/div[2]/div/h2")
    WebElement contactSuccess;

    // -------------------- TC02 Elements --------------------//

    // Open Booking button
    @FindBy(css = "button[class='btn btn-outline-primary float-right openBooking']")
    WebElement open_booking_button;

    // Booking first name input
    @FindBy(css = "input[name='firstname']")
    WebElement booking_firstname_input;

    // Booking last name input
    @FindBy(css = "input[name='lastname']")
    WebElement booking_lastname_input;

    // Booking email input
    @FindBy(css = "input[name='email']")
    WebElement booking_email_input;

    // Booking phone input
    @FindBy(css = "input[name='phone']")
    WebElement booking_phone_input;

    // Initial day element
    @FindBy(css = "//div[@class='rbc-date-cell' and contains(.,'01')]/button")
    WebElement initial_day;

    // Final day element
    @FindBy(xpath = "div[class='rbc-day-bg rbc-off-range-bg']")
    WebElement final_day;

    // Book room button
    @FindBy(css = "button[class='btn btn-outline-primary float-right book-room']")
    WebElement book_room_button;

    // Booking Room Success Message
    @FindBy(xpath = "/html/body/div[4]/div/div/div[1]/div[2]/h3")
    WebElement bookingSuccess;

    // -------------------- Universal Functions --------------------//

    // Constructor to initialize driver when called
    public ShadyMeadows_PF(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        PageFactory.initElements(this.driver, this);
    }

    // validate homepage
    public void validatePage() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[2]/div[2]/p")));

        assertTrue(welcomeText.getText().contains("Welcome to Shady Meadows"));
    }

    // -------------------- TC01 Functions --------------------//

    // TC01: Send keys to contact name input
    public void sendContactName(String name) {
        contact_name_input.sendKeys(name);
    }

    // TC01: Send keys to contact name input
    public void sendContactEmail(String email) {
        contact_email_input.sendKeys(email);
    }

    // TC01: Send keys to contact name input
    public void sendContactPhone(String phone) {
        contact_phone_input.sendKeys(phone);
    }

    // TC01: Send keys to contact name input
    public void sendContactSubject(String subject) {
        contact_subject_input.sendKeys(subject);
    }

    // TC01: Send keys to contact name input
    public void sendContactDesc(String desc) {
        contact_descr_input.sendKeys(desc);
    }

    // TC01: Send keys to contact name input
    public void clickContactSubmit() {
        contact_submit_button.click();
    }

    // TC01: Validate contact confirmation message
    public void validateContactConfirmation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[5]/div[2]/div/h2")));

        assertTrue(contactSuccess.getText().contains("Thanks for getting in touch "));
    }

    // -------------------- TC02 Functions --------------------//
    // -------------------- CURRENTLY WIP --------------------//

    // TC02: Clicks on open booking button
    public void clickOpenBookingButton() {
        open_booking_button.click();
    }

    // TC02: Send keys to booking firstname input
    public void sendBookingFirstnameInput(String firstname) {
        booking_firstname_input.sendKeys(firstname);
    }

    // TC02: Send keys to booking lastname input
    public void sendBookingLastnameInput(String lastname) {
        booking_lastname_input.sendKeys(lastname);
    }

    // TC02: Send keys to booking email input
    public void sendBookingEmailInput(String email) {
        booking_email_input.sendKeys(email);
    }

    // TC02: Send keys to booking phone input
    public void sendBookingPhoneInput(String phone) {
        booking_phone_input.sendKeys(phone);
    }

    // Need to figure out how to click and hold for date selection
    // TC02: Click and drag selected days
    public void selectDays() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By
                        .xpath("//*[@id=\"root\"]/div[2]/div/div[4]/div/div[2]/div[2]/div/div[2]/div[4]/div[1]/div[2]")));

        Actions action = new Actions(this.driver);

        // action.moveToElement(initial_day).pause(Duration.ofSeconds(1)).clickAndHold(initial_day)
        // .pause(Duration.ofSeconds(1)).moveToElement(final_day).pause(Duration.ofSeconds(1)).release().perform();

        action.clickAndHold(initial_day).moveToElement(final_day).release().build().perform();
        // action.dragAndDrop(initial_day, final_day);

    }

    // TC02: Clicks on booking room button
    public void clickBookRoomButton() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("button[class='btn btn-outline-primary float-right book-room']")));

        book_room_button.click();

        assertTrue(bookingSuccess.getText().contains("Booking Successful! "));
    }
}
