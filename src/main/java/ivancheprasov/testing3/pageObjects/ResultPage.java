package ivancheprasov.testing3.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultPage {
    @FindBy(xpath = "//main//section[.//h2[text() = 'Result:']]/div//img[@alt]")
    public WebElement resultOutput;

    @FindBy(xpath = "//main//section[.//h2[text() = 'Input:']]/div//img[@alt]")
    public WebElement expressionOutput;

    @FindBy(xpath = "//main//section[.//h2[text() = 'Input interpretation:']]/div//img[@alt]")
    public WebElement expressionInterpolationOutput;

    @FindBy(xpath = "//main//section[.//h2[text() = 'Plot:']]/div//img[@alt]")
    public WebElement plotOutput;

    @FindBy(xpath = "//main//span[text() = 'Wolfram|Alpha does not yet understand this Cyrillic language.']")
    public WebElement cyrillicInputWarning;

    @FindBy(xpath = "//main//span[contains(text(), \"Wolfram|Alpha doesn't understand your query\")]")
    public WebElement emptyInputWarning;

    public ResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
