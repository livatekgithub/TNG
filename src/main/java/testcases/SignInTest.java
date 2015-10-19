package testcases;

import org.junit.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pagesobjects.SignInPage;
import pagesobjects.AccessDataSet;
import setup.Setup;

import java.net.MalformedURLException;

import static org.junit.Assert.assertTrue;

public class SignInTest implements AccessDataSet  {

    private static WebDriver driver;

    @BeforeTest
    @Parameters({"browser"})
    public void setUp(String browser) throws MalformedURLException {
        driver = Setup.getDriver(browser);
    }

    @Test(groups = {"positive","login"},priority = 1)
    public void positiveSignIn() throws InterruptedException {

        SignInPage page= PageFactory.initElements(driver, SignInPage.class);
        page.loginUser(driver,TESTLOGIN, TESTPASSWORD);
        assertTrue(page.getAvatarMenu().isDisplayed());
    }

    /*
    @Test(groups = {"negative","login"},priority = 1)
    public void negativeSignIn() throws InterruptedException {

        SignInPage page= PageFactory.initElements(driver, SignInPage.class);
        page.loginUser(driver, WRONGTESTLOGIN, WRONGTESTPASSWORD);
        assertTrue(page.getAvatarMenu().isDisplayed());
    }
    */

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}