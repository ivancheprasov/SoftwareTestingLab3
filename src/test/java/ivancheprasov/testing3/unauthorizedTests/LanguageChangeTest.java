package ivancheprasov.testing3.unauthorizedTests;

import ivancheprasov.testing3.BasicBrowserTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LanguageChangeTest extends BasicBrowserTest {
    @BeforeEach
    public void returnToMainPage() {
        driver.get("https://www.wolframalpha.com/");
    }

    @Test
    public void testLanguageChange() {
        waitUntilClickable(mainPage.acceptCookiesButton);
        mainPage.acceptCookiesButton.click();
        mainPage.languageSelector.click();
        waitUntilClickable(mainPage.japaneseOption);
        mainPage.japaneseOption.click();
        waitUntilVisible(mainPage.wolframLogoJapanese);
        waitUntilClickable(mainPage.languageSelector);
        mainPage.languageSelector.click();
        waitUntilClickable(mainPage.englishOption);
        mainPage.englishOption.click();
        waitUntilVisible(mainPage.wolframLogo);
    }
}
