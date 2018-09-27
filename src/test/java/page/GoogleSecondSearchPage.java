package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class GoogleSecondSearchPage extends GoogleBasePage {

    @FindBy(xpath = "//div[@id='resultStats']")
    private WebElement searchResultTotal;

    @FindBy(xpath = "//div[@class = 'srg']/div[@class='g']")
    private List<WebElement> searchResults;

    public GoogleSecondSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitUntilElementVisible(searchResultTotal, 20);
    }

    public boolean isPageLoaded() {
        return getCurrentUrl().contains("Selenium")
                && getCurrentTitle().contains("Selenium");
    }


    public List<String> getSearchResultsList() {
        List<String> searchResultList = new ArrayList<String>();
        for (WebElement searchResult : searchResults) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", searchResult);
            searchResultList.add(searchResult.getText());
                }
        return searchResultList;
    }

    /**
     * getSearchResultsNumber method - calculates number of found results on page.
     *
     * @return integer size of link list
     */
    public int getSearchResultsNumber() {
        return searchResults.size();

    }


}