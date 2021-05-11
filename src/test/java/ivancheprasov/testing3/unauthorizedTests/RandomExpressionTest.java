package ivancheprasov.testing3.unauthorizedTests;

import ivancheprasov.testing3.BasicBrowserTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RandomExpressionTest extends BasicBrowserTest {
    @BeforeEach
    public void returnToMainPage() {
        driver.get("https://www.wolframalpha.com/");
    }

    @Test
    public void testRandomExpression() {
        waitUntilClickable(mainPage.randomExpressionButton);
        mainPage.randomExpressionButton.click();
        waitUntilUrlMatches("/input");
        waitUntilDocumentIsLoaded();
        waitUntilVisible(mainPage.expressionInput);
        String oneExpression = mainPage.expressionInput.getAttribute("value");
        String anotherExpression;
        do {
            waitUntilClickable(mainPage.randomExpressionButton);
            mainPage.randomExpressionButton.click();
            waitUntilClickable(mainPage.expressionInput);
            anotherExpression = mainPage.expressionInput.getAttribute("value");
        } while (oneExpression.equals(anotherExpression));
    }
}
