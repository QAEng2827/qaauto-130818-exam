import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

// находим поле для  поиска
//находим кнопки
// проверяем
// вводим поисковый термин
// переход на страницу поиска


public class GoogleMainSearchPageTest extends GoogleBaseTest {

    @Test
    public void basicSearchTest() {

        String searchTerm = "Selenium";

        Assert.assertTrue(googleMainPage.isPageLoaded(), "Main Google page is not loaded");


        GoogleSearchPage googleSearchPage = googleMainPage.search(searchTerm);
        Assert.assertTrue(googleSearchPage.isPageLoaded(), "Search page is not loaded.");

        Assert.assertEquals(googleSearchPage.getSearchResultsNumber(), 10, "Wrong number of searchResults on Search page.");

        List<String> searchResultsList = googleSearchPage.getSearchResultsList();
        for (String searchResult : searchResultsList) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()),
                    "SearchTerm " + searchTerm + " not found in:\n" + searchResult);
        }

        System.out.println("Hello");


    }


}
