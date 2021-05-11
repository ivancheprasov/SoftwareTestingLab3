package ivancheprasov.testing3.unauthorizedTests;

import ivancheprasov.testing3.BasicBrowserTest;
import ivancheprasov.testing3.pageObjects.SocialPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SocialMediaLinksTest extends BasicBrowserTest {
    private static SocialPage socialPage;

    @BeforeAll
    public static void init() {
        socialPage = new SocialPage(driver);
    }

    @BeforeEach
    public void getToSocialPage() {
        driver.get("https://www.wolframalpha.com/");
        waitUntilClickable(mainPage.socialMediaLink);
        mainPage.socialMediaLink.click();
        waitUntilUrlMatches("https://www.wolframalpha.com/social");
        waitUntilDocumentIsLoaded();
    }

    @Test
    public void testSocialMediaLinks() {
        waitUntilClickable(socialPage.facebookLink);
        socialPage.facebookLink.click();
        waitUntilNumberOfTabs(2);
        waitUntilClickable(socialPage.twitterLink);
        socialPage.twitterLink.click();
        waitUntilNumberOfTabs(3);
        waitUntilClickable(socialPage.tumblrLink);
        socialPage.tumblrLink.click();
        waitUntilNumberOfTabs(4);
        waitUntilClickable(socialPage.linkedInLink);
        socialPage.linkedInLink.click();
        waitUntilNumberOfTabs(5);
    }
}
