package ivancheprasov.testing3.unauthorizedTests;

import ivancheprasov.testing3.BasicBrowserTest;
import ivancheprasov.testing3.pageObjects.ResultPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExpressionInputTest extends BasicBrowserTest {
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
    public void testExpressionInput() {
        waitUntilClickable(mainPage.expressionInput);
        mainPage.expressionInput.sendKeys("2+2");
        waitUntilClickable(mainPage.equalsButton);
        mainPage.equalsButton.click();
        waitUntilVisible(resultPage.expressionOutput);
        Assertions.assertEquals("2 + 2", resultPage.expressionOutput.getAttribute("alt"));
        waitUntilVisible(resultPage.resultOutput);
        Assertions.assertEquals("4", resultPage.resultOutput.getAttribute("alt"));
    }

    @Test
    public void testExpressionClearButton() {
        waitUntilClickable(mainPage.expressionInput);
        mainPage.expressionInput.sendKeys("2+2");
        Assertions.assertEquals("2+2", mainPage.expressionInput.getAttribute("value"));
        waitUntilClickable(mainPage.clearButton);
        mainPage.clearButton.click();
        Assertions.assertEquals("", mainPage.expressionInput.getAttribute("value"));
    }

    @Test
    public void testCyrillicInput() {
        waitUntilClickable(mainPage.expressionInput);
        mainPage.expressionInput.sendKeys("выражение");
        waitUntilClickable(mainPage.equalsButton);
        mainPage.equalsButton.click();
        waitUntilVisible(resultPage.cyrillicInputWarning);
    }

    @Test
    public void testClearInput() {
        driver.get("https://www.wolframalpha.com/input");
        waitUntilClickable(mainPage.expressionInput);
        mainPage.expressionInput.clear();
        waitUntilClickable(mainPage.equalsButton);
        mainPage.equalsButton.click();
        waitUntilVisible(resultPage.emptyInputWarning);
    }

    @Test
    public void testPlotInput() {
        waitUntilClickable(mainPage.expressionInput);
        mainPage.expressionInput.sendKeys("plot x=y");
        waitUntilClickable(mainPage.equalsButton);
        mainPage.equalsButton.click();
        waitUntilVisible(resultPage.expressionInterpolationOutput);
        Assertions.assertEquals("plot | x = y", resultPage.expressionInterpolationOutput.getAttribute("alt"));
        waitUntilVisible(resultPage.plotOutput);
    }
}
