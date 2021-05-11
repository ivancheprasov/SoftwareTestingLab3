package ivancheprasov.testing3.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SocialPage {
    @FindBy(xpath = "//a[.//span[contains(text(), 'Facebook')]]")
    public WebElement facebookLink;

    @FindBy(xpath = "//a[.//span[contains(text(), 'Twitter')]]")
    public WebElement twitterLink;

    @FindBy(xpath = "//a[.//span[contains(text(), 'Tumblr')]]")
    public WebElement tumblrLink;

    @FindBy(xpath = "//a[.//span[contains(text(), 'LinkedIn')]]")
    public WebElement linkedInLink;

    public SocialPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
