package com.sdd.home.page;


import com.sdd.home.commonMethods.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SDDPage extends BasePage {

    @FindBy(xpath = "//*[contains(@class, 'sc-citwmv kajamm ak72o6-0 dySRin')]")
    private WebElement shopRunnerHomePage;
    @FindBy(xpath = "//nav[@class='ak72o6-2 cBlLSF']//a[@class='sc-1mjlf0n-3 glCvaS'][normalize-space()='Log in']")
    private WebElement logInButton;
    ////a[@class="sc-1mjlf0n-3 glCvaS" and text()='Log in']
    @FindBy(xpath = "//header[@class='sc-bczRLJ kjxCmW']//*[name()='svg']")
    private WebElement shopRunnerLoginPage;
    @FindBy(xpath = "//legend[contains(@class, 'sc-eCYdqJ eyiars') and text() = 'Log in to ShopRunner to continue']")
    private WebElement shopRunnerLoginToContinue;
    @FindBy(xpath = "//input[@id='email']")
    private WebElement enterEmail;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement enterPassword;
    @FindBy(xpath = "//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.recaptcha.net/recaptcha/enterprise/anchor?ar=1&k=6LfF57QgAAAAADIYJThi-aFsuV78G6vTW3zvvgag&co=aHR0cHM6Ly9sb2dpbi5zaG9wcnVubmVyLmNvbTo0NDM.&hl=en&v=Nh10qRQB5k2ucc5SCBLAQ4nA&size=normal&cb=s3mal7yl15oh')]")
    private WebElement imNotRobotCheckBox;
    @FindBy(xpath = "(//span[@class='sc-eCYdqJ fMVQkY'])")
    private WebElement clickOnPage;
    @FindBy(xpath = "//*[@id=\"__next\"]/div/main/form/button")
    private WebElement shopRunnerLogInButton;
    @FindBy(xpath = "(//input[@id='search-header-search'])[2]")
    private WebElement searchHeader;
    @FindBy(xpath = "//nav[@class='ak72o6-2 cBlLSF']//div[@class='sc-1mjlf0n-0 cxfMHw']//div[@class='sc-1mjlf0n-4 pzIxj']//div[@class='sc-1n3tgbr-0 eINBni']//div//button[@role='button']//*[name()='svg']")
    private WebElement userProfile;
    @FindBy(xpath = "//a[normalize-space()='Log out']")
    private WebElement logOut;
    @FindBy(xpath = "//a[normalize-space()='My Account']")
    private WebElement myAccount;


    public SDDPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /*public void isPageLoaded() {
        SDDPage.isElementPresent(driver, PageTitle);
        Assert.assertTrue(PageTitle.isDisplayed());
    }

    public void clickSignInButton() {
        Utils.isElementPresent(driver, signInButton);
        signInButton.click();
    }*/

    /**
     * This method validates Shop Runner Home page
     *
     * @throws Exception
     * @author Kalpana
     */
    public void validateShopRunnerHomePage(String arg0) throws Exception {
        isElementPresent(shopRunnerHomePage);
        waitForElementVisibility(shopRunnerHomePage);
        shopRunnerHomePage.isDisplayed();
    }

    /**
     * This method clicks on Login Page
     *
     * @return NA
     * @throws Exception
     * @author Kalpana
     */

    public void clickOnLogInButton(String arg0) throws Exception {
        isElementPresent(logInButton);
        waitForElementVisibility(logInButton);
        waitForElementIsClickable(logInButton);
        javaScript_click(logInButton);
    }

    /**
     * This method validates Login Page
     *
     * @return NA
     * @throws Exception
     * @author Kalpana
     */

    public void validateShopRunnerLoginPage() throws Exception {
        try {
            isElementPresent(shopRunnerLoginPage);
            shopRunnerLoginPage.isDisplayed();
        } catch (Exception exception) {
            throw new Exception("Unable find Home page");
        }
    }

    /**
     * This method validates Login to continue text
     *
     * @return NA
     * @throws Exception
     * @author Kalpana
     */

    public void validateLoginToContinueText() throws Exception {
        try {
            shopRunnerLoginToContinue.isDisplayed();
        } catch (Exception exception) {
            throw new Exception("Unable Login to continue text");
        }
    }

    /**
     * This method enters Email
     *
     * @return NA
     * @throws Exception
     * @author Kalpana
     */

    public void enterEmailAddress(Object email) throws Exception {
        refreshPage();
        waitUntilSSDLoginPageIsLoaded();
        Thread.sleep(10000);
//        imNotRobotCheckBox.isDisplayed();
        try {
            isElementPresent(enterEmail);
            enterEmail.sendKeys(email.toString());
        } catch (Exception exception) {
            throw new Exception("Unable enter Email");
        }
    }

    /**
     * This method enters Password
     *
     * @return NA
     * @throws Exception
     * @author Kalpana
     */

    public void enterPassword(Object password) throws Exception {
        try {
            isElementPresent(enterPassword);
            enterPassword.sendKeys(password.toString());
        } catch (Exception exception) {
            throw new Exception("Unable enter Password");
        }
    }

    /**
     * This method clicks reCAPTACHA check box
     *
     * @return NA
     * @throws Exception
     * @author Kalpana
     */

    public void clickONImNotRobotCheckBox() throws Exception {
        Thread.sleep(2000);
        reCaptacha_Click();
    }

    /**
     * This method clicks on Login button to signin
     *
     * @return NA
     * @throws Exception
     * @author Kalpana
     */

    public void clickOnLogInButtonToSignIn(String arg0) throws Exception {
        Thread.sleep(5000);
        javaScript_click(shopRunnerLogInButton);
    }

    /**
     * This method validates search Box after login
     *
     * @return NA
     * @throws Exception
     * @author Kalpana
     */

    public void validateSearchBoxHeaderAfterLogin() throws Exception {
        try {
            searchHeader.isDisplayed();
        } catch (Exception exception) {
            throw new Exception("Unable find Search box");
        }
    }

    /**
     * This method clicks on User Profile
     *
     * @return NA
     * @throws Exception
     * @author Kalpana
     */

    public void clickOnUserProfile() throws Exception {
        try {
            userProfile.click();
        } catch (Exception exception) {
            throw new Exception("Unable click on User Profile");
        }
    }

    /**
     * This method clicks on Logout button
     *
     * @return NA
     * @throws Exception
     * @author Kalpana
     */

    public void clickOnLogOut() throws Exception {
        try {
            logOut.click();
        } catch (Exception exception) {
            throw new Exception("Unable to click on Logout button");
        }
    }

    /**
     * This method clicks on reCAPTACHA check box
     *
     * @return NA
     * @throws Exception
     * @author Kalpana
     */
    public void reCaptacha_Click() {
        WebDriverWait wait = new WebDriverWait(driver, WebDriverWait.DEFAULT_SLEEP_TIMEOUT);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name, 'a-')]")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='recaptcha-anchor-label']"))).click();
    }
}

