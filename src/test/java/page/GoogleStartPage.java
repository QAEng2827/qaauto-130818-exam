package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleStartPage extends GoogleBasePage{

    @FindBy(xpath = "//input[@id='lst-ib']")
    private WebElement searchField;

    @FindBy(xpath = "//input[@name='btnK']" )
    private WebElement submitButton;

    @FindBy(xpath = "//input[@name='btnK']" )
    private WebElement luckyButton;

    /**
     * Constructor for linkedInLoginPage;
     *
     * @param driver -  driver instance fom test,  КС-приложение между библиотекой вебдрейверa и браузерom.
     */
    public GoogleStartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this); //  просто считывает значения, но не ищет
        assertElementIsVisible(submitButton, 5, "main Google page is not loaded.");
    }

    /** * isPageLoaded method. Checks URL, title and signIn Button are found as expected.
     * @return true, when everything found.
     */
    public boolean isPageLoaded(){
        return getCurrentUrl().contains(".google.com/")
                && getCurrentTitle().contains("Google")
                && searchField.isDisplayed()
                && submitButton.isDisplayed()
                && luckyButton.isDisplayed();

    }

    /*** search method - insert a search word with enter.
     *
     * @param searchTerm - word is searched.
     * @return - LinkedinSearchPage with results
     *
     */
    public GoogleSearchPage search(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);
        return new GoogleSearchPage(driver);
    }
}
