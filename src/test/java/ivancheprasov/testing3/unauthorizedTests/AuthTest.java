package ivancheprasov.testing3.unauthorizedTests;

import ivancheprasov.testing3.AuthorizedTest;
import ivancheprasov.testing3.BasicBrowserTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AuthTest extends BasicBrowserTest {

    @BeforeEach
    public void returnToMainPage() {
        driver.get("https://www.wolframalpha.com/");
    }

    @Test
    public void testAuth(){
        AuthorizedTest.authWith("kabasica291@mail.ru", "testing3");
        waitUntilVisible(mainPage.accountName);
        Assertions.assertTrue(mainPage.accountName.getText().contains("kabasica291"));
    }
}
