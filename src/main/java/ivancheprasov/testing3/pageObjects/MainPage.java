package ivancheprasov.testing3.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    @FindBy(xpath = "//header//button//*[contains(text(), 'サインイン') or contains(text(), 'Sign in')]")
    public WebElement loginButton;

    @FindBy(xpath = "//header//li[4]/button")
    public WebElement accountMenuButton;

    @FindBy(xpath = "//header//li[4]/button/span")
    public WebElement accountName;

    @FindBy(xpath = "//header//li[4]/ul//span[contains(text(), 'Sign Out')]")
    public WebElement logoutButton;

    @FindBy(xpath = "//header//li[4]/ul//a[.//span[contains(text(), 'Account')]]")
    public WebElement profileLink;

    @FindBy(xpath = "//form//input")
    public WebElement expressionInput;

    @FindBy(xpath = "//form//button[@type = 'submit']")
    public WebElement equalsButton;

    @FindBy(xpath = "//form//button[@type = 'button']")
    public WebElement clearButton;

    @FindBy(xpath = "//img[@alt='WolframAlpha computational knowledge AI']")
    public WebElement wolframLogo;

    @FindBy(xpath = "//img[@alt='WolframAlpha 計算知能 AI']")
    public WebElement wolframLogoJapanese;

    @FindBy(xpath = "//button[@type='button'][.//span[contains(text(), 'Random')]]")
    public WebElement randomExpressionButton;

    @FindBy(xpath = "//button[@type='button'][.//span[contains(text(), 'Extended Keyboard')]]")
    public WebElement extendedKeyboardButton;

    @FindBy(xpath = "//a[.//span[contains(text(), 'Examples')]]")
    public WebElement showExamplesButton;

    @FindBy(xpath = "//button[@aria-label='square root']")
    public WebElement squareRootButton;

    @FindBy(xpath = "//button[@type='button'][.//span[contains(text(), 'Upload')]]")
    public WebElement uploadImageButton;

    @FindBy(xpath = "//img[@alt='QuinSconce.png thumbnail']")
    public WebElement testImageButton;

    @FindBy(xpath = "//footer//button[@aria-label = 'Language Selector' or @aria-label = '言語を選択してください']")
    public WebElement languageSelector;

    @FindBy(xpath = "//footer//button[@aria-label = 'English, English' or @aria-label = 'English, 英語']")
    public WebElement englishOption;

    @FindBy(xpath = "//footer//button[@aria-label = '日本語, Japanese' or @aria-label = '日本語, 日本語']")
    public WebElement japaneseOption;

    @FindBy(xpath = "//button[contains(text(), 'Accept')]")
    public WebElement acceptCookiesButton;

    @FindBy(xpath = "//a[.//span[contains(text(), 'Connect')]]")
    public WebElement socialMediaLink;

    @FindBy(xpath = "//header//button[.//span[contains(text(), 'UPGRADE TO PRO')]]")
    public WebElement upgradeButton;

    @FindBy(xpath = "//header//section[.//span[contains(text(), 'For Everyone')]]//a[.//span[contains(text(), 'Pricing')]]")
    public WebElement pricingLink;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
