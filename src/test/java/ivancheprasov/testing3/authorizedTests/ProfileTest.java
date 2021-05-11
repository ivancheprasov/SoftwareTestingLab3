package ivancheprasov.testing3.authorizedTests;

import ivancheprasov.testing3.AuthorizedTest;
import ivancheprasov.testing3.pageObjects.ProfilePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.ElementClickInterceptedException;

public class ProfileTest extends AuthorizedTest {
    private static ProfilePage profilePage;

    @BeforeAll
    public static void getToProfilePage(){
        profilePage = new ProfilePage(driver);
        waitUntilClickable(mainPage.accountMenuButton);
        mainPage.accountMenuButton.click();
        waitUntilClickable(mainPage.profileLink);
        mainPage.profileLink.click();
        waitUntilUrlMatches("https://account.wolfram.com/products/wolfram-alpha");
        waitUntilDocumentIsLoaded();
    }

    @Test
    public void testInformationEditing () throws InterruptedException {
        waitUntilClickable(profilePage.accountInformationLink);
        try {
            profilePage.accountInformationLink.click();
        } catch (ElementClickInterceptedException e){
            Thread.currentThread().sleep(8000);
            profilePage.accountInformationLink.click();
        }
        waitUntilClickable(profilePage.updateNameLink);
        try {
            profilePage.updateNameLink.click();
        } catch (ElementClickInterceptedException e){
            Thread.currentThread().sleep(3000);
            profilePage.updateNameLink.click();
        }
        waitUntilClickable(profilePage.firstNameInput);
        String oldName = profilePage.firstNameInput.getAttribute("value");
        String newName = oldName.equals("Ivan") ? "Anton" : "Ivan";
        profilePage.firstNameInput.clear();
        profilePage.firstNameInput.sendKeys(newName);
        waitUntilClickable(profilePage.updateInformationButton);
        profilePage.updateInformationButton.click();
        waitUntilClickable(profilePage.manageInformationLink);
        try {
            profilePage.manageInformationLink.click();
        } catch (ElementClickInterceptedException e){
            Thread.currentThread().sleep(3000);
            profilePage.manageInformationLink.click();
        }
        waitUntilVisible(profilePage.nameInformation);
        Assertions.assertTrue(profilePage.nameInformation.getText().contains(newName));
    }

    @Test
    public void testVerificationStatusChange() throws InterruptedException {
        waitUntilClickable(profilePage.accountInformationLink);
        try {
            profilePage.accountInformationLink.click();
        } catch (ElementClickInterceptedException e){
            Thread.currentThread().sleep(8000);
            profilePage.accountInformationLink.click();
        }
        waitUntilClickable(profilePage.sendEmailLink);
        try {
            profilePage.sendEmailLink.click();
        } catch (ElementClickInterceptedException e){
            Thread.currentThread().sleep(3000);
            profilePage.sendEmailLink.click();
        }
        waitUntilVisible(profilePage.sendingIndicator);
        waitUntilVisible(profilePage.emailSentIndicator);
    }
}
