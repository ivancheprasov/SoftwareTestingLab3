package ivancheprasov.testing3.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthPage {
    @FindBy(xpath = "//form//input[@type = 'email']")
    public WebElement emailInput;

    @FindBy(xpath = "//form//button[contains(@class, 'submit-btn')]")
    public WebElement continueButton;

    @FindBy(xpath = "//form//input[@type = 'password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//form//button[contains(@class, 'submit-btn') and @type = 'submit']")
    public WebElement signInButton;

    @FindBy(xpath = "//form//div[contains(@class, 'error-text')]/p")
    public WebElement fieldErrorMessage;

    @FindBy(xpath = "//form//div[contains(@class, 'alert-danger')]")
    public WebElement globalErrorMessage;

    @FindBy(xpath = "//form//a[contains(@wal-event, 'Create one')]")
    public WebElement registerLink;

    public AuthPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
