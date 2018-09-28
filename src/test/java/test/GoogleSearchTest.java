package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.GoogleSearchPage;
import page.GoogleSecondSearchPage;
import java.util.List;

// находим поле для  поиска
//находим кнопки
// проверяем
// вводим поисковый термин
// переход на страницу поиска


public class GoogleSearchTest extends GoogleBaseTest {

    @DataProvider
    public Object[][] caseDataProvider() {
        return new Object[][]{
                {"Selenium", 10},
                {"selenium", 10},
                {"maven", 9},

        };
    }


    @Test(dataProvider = "caseDataProvider")
    public void basicSearchTest(String searchTerm, int numberResults) {

        Assert.assertTrue(googleStartPage.isPageLoaded(), "Start Google page is not loaded");
        GoogleSearchPage googleSearchPage = googleStartPage.search(searchTerm);
        Assert.assertTrue(googleSearchPage.isPageLoaded(), "Search page is not loaded.");

        Assert.assertEquals(googleSearchPage.getSearchResultsNumber(), numberResults, "Wrong number of searchResults on Search page.");
        List<String> searchResultsList = googleSearchPage.getSearchResultsList();
        for (String searchResult : searchResultsList) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()),
                    "SearchTerm " + searchTerm + " not found in:\n" + searchResult);
        }

        GoogleSecondSearchPage googleSecondSearchPage = googleSearchPage.goToSecondPage();
        Assert.assertTrue(googleSecondSearchPage.isPageLoaded(), "Search page is not loaded.");

        Assert.assertEquals(googleSecondSearchPage.getSearchResultsNumber(), numberResults,
                "Wrong number of searchResults on Search page");

        List<String> searchSecondResultsList = googleSecondSearchPage.getSearchResultsList();

        for (String searchResult : searchSecondResultsList) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()),
                    "SearchTerm " + searchTerm + " not found in:\n" + searchResult);
        }
    }
}

