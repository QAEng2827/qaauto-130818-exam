package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleBasePage {

    protected WebDriver driver;


    /**
     * getCurrent Url method.
     *
     * @return curent URL of page.
     */
    protected String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * getCurrent Title method.
     *
     * @return curent title of page.
     */
    protected String getCurrentTitle() {
        return driver.getTitle();
    }

    /**
     * waitUntilElementVisible method.
     * <p>
     * Method waiths untill element become visiable on page,
     *
     * @param webElement   -webelement is waiting for.
     * @param timeOutInSec -max of secunds willl wait.
     * @return webElement that was waied for.
     */

    protected WebElement waitUntilElementVisible(WebElement webElement, int timeOutInSec) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSec);
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected boolean isUrlContains(String partialUrl, int timeOutInSec) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSec);
        try {
            return wait.until(ExpectedConditions.urlContains(partialUrl));
        } catch (TimeoutException e) {
            return false;
        }
    }

    protected void assertElementIsVisible(WebElement webElement, int timeOutInSec, String message) {
        try {
            waitUntilElementVisible(webElement, timeOutInSec);
        } catch (TimeoutException e) {
            throw new AssertionError(message);
        }
    }
}
