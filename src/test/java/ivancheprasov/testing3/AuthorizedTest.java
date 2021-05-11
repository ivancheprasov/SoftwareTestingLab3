package ivancheprasov.testing3;

import ivancheprasov.testing3.pageObjects.AuthPage;
import org.junit.jupiter.api.BeforeAll;

public class AuthorizedTest extends BasicBrowserTest{
    public static AuthPage authPage;

    @BeforeAll
    public static void auth(){
        driver.get("https://www.wolframalpha.com/");
        authWith("kabasica291@mail.ru", "testing3");
    }

    public static void authWith(String email, String password){
        authPage = new AuthPage(driver);
        mainPage.loginButton.click();
        waitUntilUrlMatches("https://account.wolfram.com/login/oauth2/sign-in");
        waitUntilDocumentIsLoaded();
        waitUntilClickable(authPage.emailInput);
        authPage.emailInput.sendKeys(email);
        waitUntilClickable(authPage.continueButton);
        authPage.continueButton.click();
        waitUntilUrlMatches("https://account.wolfram.com/login/oauth2/enter-password");
        waitUntilDocumentIsLoaded();
        waitUntilClickable(authPage.passwordInput);
        authPage.passwordInput.sendKeys(password);
        waitUntilClickable(authPage.signInButton);
        authPage.signInButton.click();
        waitUntilUrlMatches("https://www.wolframalpha.com/");
        waitUntilDocumentIsLoaded();
    }
}
