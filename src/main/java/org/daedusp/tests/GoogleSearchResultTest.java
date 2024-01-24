package org.daedusp.tests;

import org.daedusp.pages.GoogleSearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GoogleSearchResultTest extends BaseTest {

    @Test
    public void verifySearchResults() {
        GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);

        // Perform a search
        googleSearchPage.enterSearchAndSubmitQuery("Test Automation with Selenium");

        // Verify the search results
        List<String> searchResults = googleSearchPage.getSearchResults();

        // Example: Verify that at least 5 search results are displayed
        Assert.assertTrue(searchResults.size() >= 5, "Expected at least 5 search results");

        // Example: Verify that each search result contains the search query
        for (String result : searchResults) {
            Assert.assertFalse(result.isEmpty(),"Result is empty");
        }
    }
}
