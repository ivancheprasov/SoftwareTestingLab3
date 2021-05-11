package ivancheprasov.testing3.unauthorizedTests;

import ivancheprasov.testing3.BasicBrowserTest;
import ivancheprasov.testing3.pageObjects.ExamplesPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExamplesTest extends BasicBrowserTest {
    private static ExamplesPage examplesPage;

    @BeforeAll
    public static void init() {
        examplesPage = new ExamplesPage(driver);
    }

    @BeforeEach
    public void showExamples() {
        driver.get("https://www.wolframalpha.com/");
        waitUntilClickable(mainPage.showExamplesButton);
        mainPage.showExamplesButton.click();
        waitUntilUrlMatches("https://www.wolframalpha.com/examples/");
        waitUntilDocumentIsLoaded();
    }

    @Test
    public void testTomHanks() {
        waitUntilClickable(examplesPage.peopleSubsectionButton);
        examplesPage.peopleSubsectionButton.click();
        waitUntilUrlMatches("https://www.wolframalpha.com/examples/society-and-culture/people/");
        waitUntilDocumentIsLoaded();
        waitUntilClickable(examplesPage.tomHanksLink);
        examplesPage.tomHanksLink.click();
        waitUntilUrlMatches("/input");
        waitUntilDocumentIsLoaded();
        waitUntilClickable(mainPage.expressionInput);
        Assertions.assertEquals("Tom Hanks, Steven Spielberg, John Williams", mainPage.expressionInput.getAttribute("value"));
    }
}
