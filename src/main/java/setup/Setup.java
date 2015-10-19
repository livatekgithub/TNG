package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pagesobjects.AccessDataSet;

import java.net.MalformedURLException;
import java.net.URL;

public class Setup implements AccessDataSet {

    static WebDriver driver;

    public static WebDriver getDriver(String browser) throws MalformedURLException{

        switch (browser) {
            case "chrome": {
                System.setProperty("webdriver.chrome.driver", "C:\\Kirill\\Java_QA\\ChromeDriver\\2.16\\chromedriver.exe");
                driver = new ChromeDriver();
                driver.get(TESTURL);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    driver.quit();
                }
            }break;

            case "firefox": {
                driver = new FirefoxDriver();
                driver.get(TESTURL);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    driver.quit();
                }
            }break;

            case "firefoxhub": {
                DesiredCapabilities capability = DesiredCapabilities.firefox();
                try {
                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                driver.manage().window().maximize();
                capability.setBrowserName("firefox");
                capability.setVersion("38.0.1");
            }break;

            case "chromehub":{
                URL chrome=new URL("http://localhost:9515");
                driver = new RemoteWebDriver(chrome,DesiredCapabilities.chrome());
                driver.manage().window().maximize();

            }break;

            default:
                break;
        }
        return driver;
    }
}
