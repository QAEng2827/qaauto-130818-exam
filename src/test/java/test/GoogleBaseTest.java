package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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

    //   @Parameters({"browserName","prefixCountry"})
    @BeforeMethod
    public void beforeMethod() {
        //   открываем браузер и заходим на страницу
        driver = new ChromeDriver();
        driver.get("https://google.com/");
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
