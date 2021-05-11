package ivancheprasov.testing3.authorizedTests;

import ivancheprasov.testing3.AuthorizedTest;
import org.junit.jupiter.api.Test;

public class LogoutTest extends AuthorizedTest {
    @Test
    public void testLogout() {
        waitUntilClickable(mainPage.accountMenuButton);
        mainPage.accountMenuButton.click();
        waitUntilClickable(mainPage.logoutButton);
        mainPage.logoutButton.click();
        waitUntilVisible(mainPage.loginButton);
    }
}
