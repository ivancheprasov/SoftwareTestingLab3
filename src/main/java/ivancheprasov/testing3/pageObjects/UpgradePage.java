package ivancheprasov.testing3.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpgradePage {
    @FindBy(xpath = "//div[.//span[text() = 'Pro']]//a[.//span[contains(text(), 'SELECT')]]")
    public WebElement selectLink;

    public UpgradePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
