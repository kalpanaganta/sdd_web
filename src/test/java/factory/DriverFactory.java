package factory;

import com.sdd.home.page.ConfigFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFactory {
    private static final DriverFactory instance = new DriverFactory();
    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>() {
        @Override
        protected WebDriver initialValue() {
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("useAutomationExtension", false);
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            options.addArguments("start-maximized");
            options.addArguments("disable-infobars");
            options.addArguments("--disable-extensions");
            ConfigFileReader configFileReader = new ConfigFileReader();
            System.setProperty("webdriver.chrome.driver", ConfigFileReader.getDriverPath());
            return new ChromeDriver(options);
        }
    };

    private DriverFactory() {

    }

    public static DriverFactory getInstance() {
        return instance;
    }

    public static boolean isElementPresent(WebDriver driver, WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public void removeDriver() {
        driver.get().quit();
        driver.remove();
    }

    public void visibility(By by, String message, int timeout) {
        wait(ExpectedConditions.visibilityOfElementLocated(by), message, timeout);
    }

    private void wait(ExpectedCondition<WebElement> visibilityOfElementLocated, String message, int timeout) {
    }

    /*public void isPageLoaded() {
        Utils.isElementPresent(driver, PageTitle);
        Assert.assertTrue(PageTitle.isDisplayed());
    }*/

    /*public void clickSignInButton() {
        Utils.isElementPresent(driver, signInButton);
        signInButton.click();
    }*/


}