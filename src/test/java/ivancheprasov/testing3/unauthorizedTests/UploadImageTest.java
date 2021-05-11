package ivancheprasov.testing3.unauthorizedTests;

import ivancheprasov.testing3.BasicBrowserTest;
import ivancheprasov.testing3.pageObjects.ResultPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UploadImageTest extends BasicBrowserTest {
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
        waitUntilClickable(mainPage.uploadImageButton);
        mainPage.uploadImageButton.click();
        waitUntilClickable(mainPage.testImageButton);
        mainPage.testImageButton.click();
        waitUntilClickable(mainPage.equalsButton);
        mainPage.equalsButton.click();
        waitUntilVisible(resultPage.expressionInterpolationOutput);
    }
}
