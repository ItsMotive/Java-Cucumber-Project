package PageFactory;

import java.time.Duration;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShadyMeadows_PF {

    WebDriver driver;

    // Contact Name Input
    @FindBy(css = "input#name")
    WebElement name_input;

    // Contact Email Input
    @FindBy(css = "input#email")
    WebElement email_input;

    // Contact Phone Input
    @FindBy(css = "input#phone")
    WebElement phone_input;

    // Contact Subject Input
    @FindBy(css = "input#subject")
    WebElement subject_input;

    // Contact Description Input
    @FindBy(css = "textarea#description")
    WebElement descr_input;

    // Contact Submit Button
    @FindBy(css = "button#submitContact")
    WebElement submit_button;

    // Welcome Text
    @FindBy(xpath = "/html/body/div/div/div/div[2]/div[2]/p")
    WebElement welcomeText;

    // Contact Success Message
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[5]/div[2]/div/h2")
    WebElement contactSuccess;

    // *[@id="root"]/div/div/div[5]/div[2]/div/h2

    public ShadyMeadows_PF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void enterName(String name) {
        name_input.sendKeys(name);
    }

    public void enterEmail(String email) {
        email_input.sendKeys(email);
    }

    public void enterPhone(String phone) {
        phone_input.sendKeys(phone);
    }

    public void enterSubject(String subject) {
        subject_input.sendKeys(subject);
    }

    public void enterDesc(String desc) {
        descr_input.sendKeys(desc);
    }

    public void clickSubmit() {
        submit_button.click();
    }

    public void validatePage() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[2]/div[2]/p")));

        assertTrue(welcomeText.getText().contains("Welcome to Shady Meadows"));
    }

    public void validateThanksMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[5]/div[2]/div/h2")));

        assertTrue(contactSuccess.getText().contains("Thanks for getting in touch "));
    }
}
