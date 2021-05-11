package ivancheprasov.testing3.authorizedTests;

import ivancheprasov.testing3.AuthorizedTest;
import ivancheprasov.testing3.pageObjects.UpgradePage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AuthorizedUpgradeTest extends AuthorizedTest {
    private static UpgradePage upgradePage;

    @BeforeAll
    public static void init() {
        upgradePage = new UpgradePage(driver);
    }

    @BeforeEach
    public void returnToMainPage() {
        driver.get("https://www.wolframalpha.com/");
    }

    @Test
    public void testUpgradeFeature(){
        mainPage.upgradeButton.click();
        waitUntilClickable(mainPage.pricingLink);
        mainPage.pricingLink.click();
        waitUntilUrlMatches("https://www.wolframalpha.com/pro/pricing");
        waitUntilDocumentIsLoaded();
        waitUntilClickable(mainPage.acceptCookiesButton);
        mainPage.acceptCookiesButton.click();
        waitUntilClickable(upgradePage.selectLink);
        upgradePage.selectLink.click();
        waitUntilUrlMatches("https://billing.wolfram.com/checkout");
        waitUntilDocumentIsLoaded();
    }
}
