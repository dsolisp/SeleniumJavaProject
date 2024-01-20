package org.daedusp.tests;

import org.daedusp.pages.GoogleSearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleSearchTest extends BaseTest {

    @Test
    public void googleSearchTest() {
        GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);
        googleSearchPage.enterSearchAndSubmitQuery("Naruto");
        googleSearchPage.clickFirstResult();
        Assert.assertTrue(googleSearchPage.getTitle().contains("Naruto"), "Search results are not displayed");
    }
}
