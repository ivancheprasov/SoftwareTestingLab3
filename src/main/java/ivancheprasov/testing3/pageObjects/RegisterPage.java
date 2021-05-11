package ivancheprasov.testing3.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    @FindBy(xpath = "//form//input[@type = 'text' and @name = 'email']")
    public WebElement emailInput;

    @FindBy(xpath = "//form//input[@type = 'text' and @name = 'firstName']")
    public WebElement firstNameInput;

    @FindBy(xpath = "//form//input[@type = 'text' and @name = 'lastName']")
    public WebElement lastNameInput;

    @FindBy(xpath = "//form//input[@type = 'password' and @name = 'password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//form//input[@type = 'password' and @name = 'passwordConfirm']")
    public WebElement passwordConfirmInput;

    @FindBy(xpath = "//form//input[@type = 'checkbox' and @name = 'accountAgreement']")
    public WebElement accountAgreementCheckbox;

    @FindBy(xpath = "//form//div[contains(@class, 'form-group')][1]//div[contains(@class, 'error-text')]/p")
    public WebElement emailErrorMessage;

    @FindBy(xpath = "//form//div[contains(@class, 'form-group')][2]//div[contains(@class, 'error-text')]/p")
    public WebElement firstNameErrorMessage;

    @FindBy(xpath = "//form//div[contains(@class, 'form-group')][3]//div[contains(@class, 'error-text')]/p")
    public WebElement lastNameErrorMessage;

    @FindBy(xpath = "//form//div[contains(@class, 'form-group')][4]//div[contains(@class, 'error-text')]/p")
    public WebElement passwordErrorMessage;

    @FindBy(xpath = "//form//div[contains(@class, 'form-group')][5]//div[contains(@class, 'error-text')]/p")
    public WebElement passwordConfirmErrorMessage;

    @FindBy(xpath = "//form//div[contains(@class, 'form-group')][6]//div[contains(@class, 'error-text')]/p")
    public WebElement accountAgreementErrorMessage;

    @FindBy(xpath = "//form//button[contains(@class, 'submit-btn') and @type = 'submit']")
    public WebElement registerButton;

    public RegisterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
