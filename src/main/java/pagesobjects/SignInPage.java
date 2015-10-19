package pagesobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.Setup;

import java.util.concurrent.TimeUnit;

public class SignInPage {

    private WebDriver driver;

    @FindBy(id = "form-email")
    WebElement loginField;

    @FindBy(id = "form-psw")
    WebElement pswField;

//    @FindBy(css = "button.btn-submit.js-tap-indication")
    @FindBy(css = ".btn-submit.js-tap-indication")
    WebElement submitButton;

    @FindBy(css = ".avatar-image")
    WebElement avatarMenu;

    public void loginUser(WebDriver driver, String login, String psw) throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(AccessDataSet.TESTURL);

        loginField.clear();
        loginField.sendKeys(login);
//        Thread.sleep(1000);
        pswField.clear();
        pswField.sendKeys(psw);
        driver.manage().window().maximize();
//        Thread.sleep(1000);
        submitButton.click();
//        Thread.sleep(8000);
    }

    public WebElement getAvatarMenu() {
        return avatarMenu;
    }
}
