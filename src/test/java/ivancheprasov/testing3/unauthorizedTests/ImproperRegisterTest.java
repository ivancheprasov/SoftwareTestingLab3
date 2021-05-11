package ivancheprasov.testing3.unauthorizedTests;

import ivancheprasov.testing3.BasicBrowserTest;
import ivancheprasov.testing3.pageObjects.AuthPage;
import ivancheprasov.testing3.pageObjects.RegisterPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ImproperRegisterTest extends BasicBrowserTest {
    private static RegisterPage registerPage;
    private static AuthPage authPage;

    @BeforeAll
    public static void init(){
        registerPage = new RegisterPage(driver);
        authPage = new AuthPage(driver);
    }

    @BeforeEach
    public void clearInputFields() {
        driver.get("https://www.wolframalpha.com/");
        mainPage.loginButton.click();
        waitUntilUrlMatches("https://account.wolfram.com/login/oauth2/sign-in");
        waitUntilDocumentIsLoaded();
        waitUntilClickable(authPage.registerLink);
        authPage.registerLink.click();
        waitUntilUrlMatches("https://account.wolfram.com/login/create");
        waitUntilDocumentIsLoaded();
        waitUntilClickable(registerPage.emailInput);
        registerPage.emailInput.clear();
        waitUntilClickable(registerPage.firstNameInput);
        registerPage.firstNameInput.clear();
        waitUntilClickable(registerPage.lastNameInput);
        registerPage.lastNameInput.clear();
        waitUntilClickable(registerPage.passwordInput);
        registerPage.passwordInput.clear();
        waitUntilClickable(registerPage.passwordConfirmInput);
        registerPage.passwordConfirmInput.clear();
    }

    @Test
    public void testEmptyFields() {
        waitUntilClickable(registerPage.registerButton);
        registerPage.registerButton.click();
        waitUntilVisible(registerPage.emailErrorMessage);
        Assertions.assertEquals( "Please enter your email address.", registerPage.emailErrorMessage.getText());
        waitUntilVisible(registerPage.firstNameErrorMessage);
        Assertions.assertEquals( "Please enter your first name.", registerPage.firstNameErrorMessage.getText());
        waitUntilVisible(registerPage.lastNameErrorMessage);
        Assertions.assertEquals("Please enter your last name.", registerPage.lastNameErrorMessage.getText());
        waitUntilVisible(registerPage.passwordErrorMessage);
        Assertions.assertEquals("Please enter your password.", registerPage.passwordErrorMessage.getText());
        waitUntilVisible(registerPage.passwordConfirmErrorMessage);
        Assertions.assertEquals("Please confirm your password.", registerPage.passwordConfirmErrorMessage.getText());
        waitUntilVisible(registerPage.accountAgreementErrorMessage);
        Assertions.assertEquals( "Please review and agree.", registerPage.accountAgreementErrorMessage.getText());
    }

    @Test
    public void testImproperEmail() {
        registerPage.emailInput.sendKeys("improperEmail");
        waitUntilClickable(registerPage.registerButton);
        registerPage.registerButton.click();
        waitUntilVisible(registerPage.emailErrorMessage);
        Assertions.assertEquals("Please enter your email address in the correct format: name@domain.com", registerPage.emailErrorMessage.getText());
    }

    @Test
    public void testImproperPassword() {
        registerPage.emailInput.sendKeys("kabasica291@mail.ru");
        registerPage.firstNameInput.sendKeys("testing3");
        registerPage.lastNameInput.sendKeys("testing3");
        registerPage.passwordInput.sendKeys("test");
        registerPage.passwordConfirmInput.sendKeys("test");
        registerPage.accountAgreementCheckbox.click();
        waitUntilClickable(registerPage.registerButton);
        registerPage.registerButton.click();
        waitUntilVisible(registerPage.passwordErrorMessage);
        Assertions.assertEquals("Your password must contain at least 8 characters.", registerPage.passwordErrorMessage.getText());
    }

    @Test
    public void testImproperPasswordConfirm() {
        registerPage.passwordInput.sendKeys("testing3");
        registerPage.passwordConfirmInput.sendKeys("testing2");
        waitUntilClickable(registerPage.registerButton);
        registerPage.registerButton.click();
        waitUntilVisible(registerPage.passwordConfirmErrorMessage);
        Assertions.assertEquals( "Those passwords don't match. Please try again.", registerPage.passwordConfirmErrorMessage.getText());
    }

    @Test
    public void testExistedEmail() {
        registerPage.emailInput.sendKeys("kabasica291@mail.ru");
        registerPage.firstNameInput.sendKeys("testing3");
        registerPage.lastNameInput.sendKeys("testing3");
        registerPage.passwordInput.sendKeys("testing3");
        registerPage.passwordConfirmInput.sendKeys("testing3");
        registerPage.accountAgreementCheckbox.click();
        waitUntilClickable(registerPage.registerButton);
        registerPage.registerButton.click();
        waitUntilVisible(registerPage.emailErrorMessage);
        Assertions.assertEquals("That email address is unavailable.", registerPage.emailErrorMessage.getText());
    }
}
