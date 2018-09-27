package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import page.GoogleStartPage;


public class GoogleBaseTest {
    WebDriver driver;
    GoogleStartPage googleStartPage;

    /**
     * BeforeMethod - method executed before every Test.
     * <p>
     * Scenario:
     * - Open Chrome browser.
     * - Navigate to test site link.
     * - Create GoogleStartPage.
     */

    //   @Parameters({"browserName","domCountry"})
    @BeforeMethod
    public void beforeMethod(@Optional("chrome") String browserName, @Optional("https://www.google.com/") String domCountry) throws Exception {

        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            default:
                throw new Exception("Browser : " + browserName + " is not supported");

        }

        driver.get(domCountry);
        googleStartPage = new GoogleStartPage(driver);
    }


    /**
     * AfterMethod - method executed after every Test.
     * <p>
     * Scenario:
     * -Quit from browser.
     */
    @AfterMethod(alwaysRun = true)
    public void afterMethod() throws Exception {
        driver.quit();
    }
}
