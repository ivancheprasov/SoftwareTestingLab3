package ivancheprasov.testing3.unauthorizedTests;

import ivancheprasov.testing3.BasicBrowserTest;
import ivancheprasov.testing3.pageObjects.ResultPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExtendedKeyboardTest extends BasicBrowserTest {
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
    public void testRandomExpression() {
        waitUntilClickable(mainPage.extendedKeyboardButton);
        mainPage.extendedKeyboardButton.click();
        waitUntilClickable(mainPage.squareRootButton);
        mainPage.squareRootButton.click();
        waitUntilClickable(mainPage.expressionInput);
        mainPage.expressionInput.sendKeys("4");
        waitUntilClickable(mainPage.equalsButton);
        mainPage.equalsButton.click();
        waitUntilVisible(resultPage.resultOutput);
        Assertions.assertEquals("2", resultPage.resultOutput.getAttribute("alt"));
    }
}
