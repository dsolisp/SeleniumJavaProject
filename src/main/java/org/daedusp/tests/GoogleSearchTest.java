package org.daedusp.tests;

import org.daedusp.pages.GoogleSearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GoogleSearchTest extends BaseTest {


    @Test
    public void simpleGoogleSearchTest() {
        GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);
        googleSearchPage.enterSearchAndSubmitQuery("Naruto");
        googleSearchPage.clickResultByText("Naruto - Wikipedia, la enciclopedia libre");
        Assert.assertTrue(googleSearchPage.getTitle().contains("Naruto"), "Search results are not displayed");
    }

    @Test
    public void sqlGoogleSearchTest() {
        GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);

        // Retrieve search queries from the database
        String searchResult = getTrackNameFromDatabase();

        googleSearchPage.enterSearchAndSubmitQuery(searchResult);
        googleSearchPage.clickResultByIndex("1");
        Assert.assertTrue(googleSearchPage.getTitle().toLowerCase().contains(searchResult.toLowerCase()), "Search results are not displayed");
    }



    private String getTrackNameFromDatabase() {
        String trackName = null;
        try {
            String query = "SELECT Name FROM tracks WHERE TrackId = '1'";
            try (PreparedStatement statement = sqliteConnection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {
                    trackName = resultSet.getString("Name");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trackName;
    }


}
