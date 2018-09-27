package test;

import org.testng.Assert;
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

    @Test
    public void basicSearchTest() {

        String searchTerm = "Selenium";

        Assert.assertTrue(googleStartPage.isPageLoaded(), "Start Google page is not loaded");
        GoogleSearchPage googleSearchPage = googleStartPage.search(searchTerm);
        Assert.assertTrue(googleSearchPage.isPageLoaded(), "Search page is not loaded.");

        // System.out.println("Hello");System.out.println("Hello");System.out.println("Hello");
        Assert.assertEquals(googleSearchPage.getSearchResultsNumber(), 10, "Wrong number of searchResults on Search page.");
        List<String> searchResultsList = googleSearchPage.getSearchResultsList();
        for (String searchResult : searchResultsList) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()),
                    "SearchTerm " + searchTerm + " not found in:\n" + searchResult);
        }

        GoogleSecondSearchPage googleSecondSearchPage = googleSearchPage.goToSecondPage();
        Assert.assertTrue(googleSecondSearchPage.isPageLoaded(), "Search page is not loaded.");

        Assert.assertEquals(googleSecondSearchPage.getSearchResultsNumber(), 10,
                "Wrong number of searchResults on Search page");

        List<String> searchSecondResultsList = googleSecondSearchPage.getSearchResultsList();

        for (String searchResult : searchSecondResultsList) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()),
                    "SearchTerm " + searchTerm + " not found in:\n" + searchResult);
        }
    }
}

