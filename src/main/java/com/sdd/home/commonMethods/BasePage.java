package com.sdd.home.commonMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BasePage {

    protected static WebDriver driver;
    private final By loginPageHeader = By.xpath("//header[@class='sc-bczRLJ kjxCmW']//*[name()='svg']");
    private final By logIn = By.xpath("//nav[@class='ak72o6-2 cBlLSF']//a[@class='sc-1mjlf0n-3 glCvaS'][normalize-space()='Log in']");
    protected WebDriverWait driverWait;
    protected JavascriptExecutor js;

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
    }

    /*protected BasePage() {
        this.driver = StatefulSingleton.instance().getDriver();
        driverWait = new WebDriverWait(driver, WEBDRIVERWAIT_TIMEOUT, WEBDRIVERWAIT_POLLING_TIMEOUT);
        js = (JavascriptExecutor) driver;
    }

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        driverWait = new WebDriverWait(driver, WEBDRIVERWAIT_TIMEOUT, WEBDRIVERWAIT_POLLING_TIMEOUT);
        js = (JavascriptExecutor) driver;
    }*/

    public static boolean isElementPresent(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void waitUntilPageIsLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(loginPageHeader));
    }

    /*public void waitForElementVisibility(WebElement element) {
        waitFor(ExpectedConditions.visibilityOf(element));
    }*/

    public void waitUntilSSDLoginPageIsLoaded() {
        waitVisibilityThenInvisibilityOfWebElementLocated(loginPageHeader, 1, 45);
        waitUntilPageIsLoaded();
    }

    public void waitForElementVisibility(WebElement element) {
        waitFor(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementIsClickable(WebElement element) {
        waitFor(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilLoginPageIsLoaded() {
        waitVisibilityThenInvisibilityOfWebElementLocated(logIn, 1, 45);
        //waitUntilPageIsLoaded();
    }

    public void actions_Click(WebElement element) {
        Actions builder = new Actions(driver);
        builder.moveToElement(element).click().build().perform();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void javaScript_click(WebElement element) {
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("arguments[0].click();", element);
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    private void waitFor(ExpectedCondition<WebElement> visibilityOfElementLocated) {
    }

    private void waitFor(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    private void waitVisibilityThenInvisibilityOfWebElementLocated(By searchProgressBar, int i, int i1) {
    }

    public String getWindowHandleByTitle(String title) {
        Set<String> ids = driver.getWindowHandles();
        String windowHandle = "";
        for (int i = 0; i < ids.toArray().length; i++) {
            driver.switchTo().window(ids.toArray()[i].toString());
            if (driver.getTitle().equals(title)) {
                windowHandle = ids.toArray()[i].toString().replace("\"", "");
                break;
            }
        }
        return windowHandle;
    }

    public void navigateToWindow(String title) {
        String wh = getWindowHandleByTitle(title);
        driver.switchTo().window(wh);
    }

    public void delay(long timeout, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void visibility(By by, String message, int timeout) {
        wait(ExpectedConditions.visibilityOfElementLocated(by), message, timeout);
    }

    private void wait(ExpectedCondition<WebElement> visibilityOfElementLocated, String message, int timeout) {
    }

}
