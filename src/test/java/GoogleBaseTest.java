import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class GoogleBaseTest{
    WebDriver driver;
    GoogleMainSearchPage googleMainPage;

    /**
     * BeforeMethod - method executed before every Test.
     *
     * Scenario:
     * - Open Chrome browser.
     * - Navigate to test site link.
     * - Create LinkedinLoginPage.
     */

 //   @Parameters({"browserName","prefixCountry"})

    @BeforeMethod
    public void beforeMethod() {
        //   открываем браузер и заходим на страницу
        driver = new ChromeDriver();
        driver.get("https://google.com/");
        googleMainPage = new GoogleMainSearchPage(driver);
    }


    /**
     * AfterMethod - method executed after every Test.
     *
     * Scenario:
     * -Quit from browser.
     */
    @AfterMethod(alwaysRun = true)
    public void afterMethod() throws Exception {

        driver.quit();
    }
}
