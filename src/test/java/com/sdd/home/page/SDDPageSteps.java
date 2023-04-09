package com.sdd.home.page;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;

public class SDDPageSteps {
    private static WebDriver driver;


    SDDPage sddPage = new SDDPage(DriverFactory.getInstance().getDriver());


//    @BeforeClass
//    public void launchBrower() {
//        WebDriver driver = new ChromeDriver();
//        driver.get(SDDConstants.URL);
//         DriverFactory.getInstance().getDriver().get(SDDConstants.URL);
//         driver.get(SDDConstants.URL);
//    }

    @AfterClass
    public static void closeBrowser() {
//        WebDriver driver=new ChromeDriver();
        driver.quit();
    }

    @Given("^User open's Google Chrome browser and enters \"([^\"]*)\"$")
    public void user_open_s_Google_Chrome_browser_and_enters(String arg1) throws Throwable {
        DriverFactory.getInstance().getDriver().get(SDDConstants.URL);
    }


    @When("^User clicks on \"([^\"]*)\" button on Landing Page$")
    public void userClicksOnLoginButton(String arg0) throws Exception {
        sddPage.clickOnLogInButton(arg0);
    }

    @And("^User enters \"(.*)\" and \"(.*)\"")
    public void userEntersEmailAndPasswordInTextBox(String Email, String Password) throws Exception {
        sddPage.enterEmailAddress(Email);
        sddPage.enterPassword(Password);
        sddPage.validateShopRunnerLoginPage();
    }

    @When("^User clicks on \"([^\"]*)\" check box$")
    public void userClicksOnImNotRobotButton(String arg0) throws Exception {
        sddPage.clickONImNotRobotCheckBox();
    }


    @When("^User validate \"([^\"]*)\" header on landing page$")
    public void userValidateShopRunnerLandingPage(String arg0) throws Exception {
        sddPage.validateShopRunnerHomePage(arg0);
    }

    @When("^User validate \"([^\"]*)\" header on login page$")
    public void userValidateHeaderInLoginPage(String arg0) throws Exception {
        sddPage.validateShopRunnerLoginPage();
    }

    @When("^User clicks on \"([^\"]*)\" button$")
    public void userClicksOnLogInButton(String arg0) throws Exception {
        sddPage.clickOnLogInButtonToSignIn(arg0);
    }

    @When("^User validate \"([^\"]*)\" header on after login$")
    public void userValidateHeaderAfterLogin(String arg0) throws Exception {
        sddPage.validateSearchBoxHeaderAfterLogin();
    }

    @When("^User validate \"([^\"]*)\" text on login page$")
    public void userValidateLoginToContinueText(String arg0) throws Exception {
        sddPage.validateLoginToContinueText();
    }

    @When("^User clicks on \"([^\"]*)\" button on home page$")
    public void userClicksOnUserProfile(String arg0) throws Exception {
        sddPage.clickOnUserProfile();
    }

    @When("^User clicks on \"([^\"]*)\" button to sign off$")
    public void userClicksOnLogIOutButton(String arg0) throws Exception {
        sddPage.clickOnLogOut();
    }
}
