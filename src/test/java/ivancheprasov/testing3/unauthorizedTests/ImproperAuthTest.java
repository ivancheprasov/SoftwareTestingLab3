package ivancheprasov.testing3.unauthorizedTests;

import ivancheprasov.testing3.BasicBrowserTest;
import ivancheprasov.testing3.pageObjects.AuthPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ImproperAuthTest extends BasicBrowserTest {
    public static AuthPage authPage;

    @BeforeAll
    public static void init(){
        authPage = new AuthPage(driver);
    }

    @BeforeEach
    public void clearCache() {
        driver.manage().getCookies().clear();
        driver.get("https://www.wolframalpha.com/");
    }

    @Test
    public void testImproperEmail(){
        mainPage.loginButton.click();
        waitUntilUrlMatches("https://account.wolfram.com/login/oauth2/sign-in");
        waitUntilDocumentIsLoaded();
        waitUntilClickable(authPage.emailInput);
        authPage.emailInput.clear();
        waitUntilClickable(authPage.continueButton);
        authPage.continueButton.click();
        waitUntilVisible(authPage.fieldErrorMessage);
        Assertions.assertEquals("Please enter your email address.", authPage.fieldErrorMessage.getText());
        waitUntilClickable(authPage.emailInput);
        authPage.emailInput.sendKeys("improperEmail");
        waitUntilClickable(authPage.continueButton);
        authPage.continueButton.click();
        waitUntilVisible(authPage.fieldErrorMessage);
        Assertions.assertEquals( "Please enter your email address in the correct format: name@domain.com", authPage.fieldErrorMessage.getText());
        authPage.emailInput.clear();
        authPage.emailInput.sendKeys("_improper_E_m_a_i_l_@mail.ru");
        waitUntilClickable(authPage.continueButton);
        authPage.continueButton.click();
        waitUntilVisible(authPage.globalErrorMessage);
        Assertions.assertEquals("This email doesn't exist.", authPage.globalErrorMessage.getText().trim());
    }

    @Test
    public void testImproperPassword(){
        mainPage.loginButton.click();
        waitUntilUrlMatches("https://account.wolfram.com/login/oauth2/sign-in");
        waitUntilDocumentIsLoaded();
        waitUntilClickable(authPage.emailInput);
        authPage.emailInput.clear();
        authPage.emailInput.sendKeys("kabasica291@mail.ru");
        waitUntilClickable(authPage.continueButton);
        authPage.continueButton.click();
        waitUntilUrlMatches("https://account.wolfram.com/login/oauth2/enter-password");
        waitUntilDocumentIsLoaded();
        waitUntilClickable(authPage.signInButton);
        authPage.signInButton.click();
        waitUntilVisible(authPage.fieldErrorMessage);
        Assertions.assertEquals("Please enter your password.", authPage.fieldErrorMessage.getText());
        waitUntilClickable(authPage.passwordInput);
        authPage.passwordInput.sendKeys("123");
        waitUntilClickable(authPage.signInButton);
        authPage.signInButton.click();
        waitUntilVisible(authPage.globalErrorMessage);
        Assertions.assertEquals("The email address or password is not correct.", authPage.globalErrorMessage.getText().trim());
    }
}
