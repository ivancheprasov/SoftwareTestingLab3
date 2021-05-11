package ivancheprasov.testing3.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExamplesPage {
    @FindBy(xpath = "//div[contains(@class, 'example-link-wrapper')]/a[contains(text(), 'People')]")
    public WebElement peopleSubsectionButton;

    @FindBy(xpath = "//a[.//span[contains(text(), 'Tom Hanks, Steven Spielberg, John Williams')]]")
    public WebElement tomHanksLink;

    public ExamplesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
