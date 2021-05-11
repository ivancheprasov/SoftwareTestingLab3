package ivancheprasov.testing3.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
    @FindBy(xpath = "//header//a[.//*[contains(text(), 'Wolfram ID')]]")
    public WebElement accountInformationLink;

    @FindBy(xpath = "//a[@routerlink = '/wolframid/change-name']")
    public WebElement updateNameLink;

    @FindBy(xpath = "//input[@formcontrolname='firstName']")
    public WebElement firstNameInput;

    @FindBy(xpath = "//div[contains(@class, 'btn-group')]//button[contains(text(), 'Update')]")
    public WebElement updateInformationButton;

    @FindBy(xpath = "//a[contains(text(), 'Manage your Wolfram ID')]")
    public WebElement manageInformationLink;

    @FindBy(xpath = "//div[./h4[contains(text(), 'Name')]]/div")
    public WebElement nameInformation;

    @FindBy(xpath = "//span[./strong[contains(text(), 'Not verified')]]//a[contains(text(), 'Send')]")
    public WebElement sendEmailLink;

    @FindBy(xpath = "//span[contains(text(), 'Sending...')]")
    public WebElement sendingIndicator;

    @FindBy(xpath = "//span[contains(text(), 'Verification email sent!')]")
    public WebElement emailSentIndicator;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
