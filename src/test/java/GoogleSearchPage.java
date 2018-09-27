import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class GoogleSearchPage  extends GoogleBasePage{
    private WebElement searchField;

    @FindBy(xpath = "//div[@id='resultStats']")
    private WebElement searchResultTotal; // тут массив данных

    @FindBy(xpath = "//a[@aria-label='Page 2'")
    private WebElement nextSearhPage;

    @FindBy(xpath = "//div[@id='search']")
    private List<WebElement> searchResults;




    /** Costructor of LinkedinSearchPage.
     *
     * Initiate variables with Page Factory, when they are called.
     * @param driver - driver instance from tests.
     */

    public GoogleSearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitUntilElementVisible(searchResultTotal, 10);
    }

    /**isPageLoaded method - checks URL, title and search results count are found as expected.
     * @return true, when everything found.
     */
    public boolean isPageLoaded(){
        return driver.getCurrentUrl().contains("google.com/search")
               && searchResultTotal.isDisplayed();
    }

    /**  * getSearchResultsNumber method - calculates number of found results on page.
     * @return integer size of link list
     */
    public int getSearchResultsNumber() {
        return searchResults.size();

    }

    /*** getSearchReasultList method - scroll to every found result and get it's text.
     * @return String list of text results.
     */
    public List<String> getSearchResultsList() {
        List<String> serchResultsList = new ArrayList<String>();

        for (WebElement searchResult : searchResults) {
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", searchResult);
            serchResultsList.add(searchResult.getText());
            System.out.println(searchResult);
        }
        return serchResultsList;
    }
    public GoogleSearchPage nextSearchPage(String searchTerm) {
        nextSearhPage.click();
        //  searchField.sendKeys(Keys.ENTER);
        return new GoogleSearchPage(driver);
    }

}
