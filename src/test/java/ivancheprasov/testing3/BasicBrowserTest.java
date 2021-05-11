package ivancheprasov.testing3;

import java.util.concurrent.TimeUnit;

import ivancheprasov.testing3.pageObjects.MainPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicBrowserTest  {
    public static MainPage mainPage;
    public static WebDriver driver;
    public static final Long TO_WAIT = 20L;

    @BeforeAll
    public static void setupBrowser() {
        System.setProperty("webdriver.gecko.driver", "/home/subhuman/geckodriver/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(TO_WAIT, TimeUnit.SECONDS);
        mainPage = new MainPage(driver);
    }

    @AfterAll
    public static void closeBrowser() {
        driver.quit();
    }

    public static void waitUntilVisible(WebElement element) {
        waitUntilVisible(element, TO_WAIT);
    }

    public static void waitUntilInvisible(WebElement element) {
        waitUntilInvisible(element, TO_WAIT);
    }

    public static void waitUntilVisible(WebElement element, long toWait) {
        if (element != null) {
            new WebDriverWait(driver, toWait).until(ExpectedConditions.visibilityOf(element));
        }
    }

    public static void waitUntilInvisible(WebElement element, long toWait) {
        if (element != null) {
            new WebDriverWait(driver, toWait).until(ExpectedConditions.invisibilityOf(element));
        }
    }

    public static void waitUntilClickable(WebElement element) {
        waitUntilClickable(element, TO_WAIT);
    }

    public static void waitUntilClickable(WebElement element, long toWait) {
        if (element != null) {
            new WebDriverWait(driver, toWait).until(ExpectedConditions.elementToBeClickable(element));
        }
    }

    public static void waitUntilDocumentIsLoaded() {
        new WebDriverWait(driver, TO_WAIT).until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState")
                .equals("complete"));
    }

    public static void waitUntilUrlMatches(String url) {
        new WebDriverWait(driver, TO_WAIT).until(ExpectedConditions.urlMatches(url));
    }

    public static void waitUntilNumberOfTabs(int number) {
        new WebDriverWait(driver, TO_WAIT).until(ExpectedConditions.numberOfWindowsToBe(number));
    }
}