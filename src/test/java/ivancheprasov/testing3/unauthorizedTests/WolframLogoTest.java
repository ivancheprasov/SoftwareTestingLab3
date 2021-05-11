package ivancheprasov.testing3.unauthorizedTests;

import ivancheprasov.testing3.BasicBrowserTest;
import ivancheprasov.testing3.pageObjects.ResultPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WolframLogoTest extends BasicBrowserTest {
    private static ResultPage resultPage;

    @BeforeAll
    public static void init() {
        resultPage = new ResultPage(driver);
    }

    @BeforeEach
    public void returnToMainPage() {
        driver.get("https://www.wolframalpha.com/");
    }

    @Test
    public void testWolframLogoClick() {
        mainPage.expressionInput.sendKeys("2+2");
        waitUntilClickable(mainPage.equalsButton);
        mainPage.equalsButton.click();
        waitUntilVisible(resultPage.resultOutput);
        waitUntilClickable(mainPage.wolframLogo);
        mainPage.wolframLogo.click();
        waitUntilUrlMatches("https://www.wolframalpha.com/");
        waitUntilDocumentIsLoaded();
    }
}
