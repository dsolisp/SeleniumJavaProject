package org.daedusp.pages;


import org.daedusp.locators.GoogleResultLocators;
import org.daedusp.locators.GoogleSearchLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class GoogleSearchPage extends BasePage {
    GoogleSearchLocators googleSearchLocators = new GoogleSearchLocators();
    GoogleResultLocators googleResultLocators = new GoogleResultLocators();

    public GoogleSearchPage(WebDriver driver) {
        super(driver);
    }

    public void enterSearchAndSubmitQuery(String query) {
        driver.findElement(googleSearchLocators.searchBox).sendKeys(query);
        driver.findElement(googleSearchLocators.searchBox).submit();

        // Wait until the search results are visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(googleResultLocators.searchResultLinks));
    }

    public List<String> getSearchResults() {
        List<String> results = new ArrayList<>();
        List<WebElement> resultLinks = driver.findElements(googleResultLocators.searchResultLinks);

        for (WebElement link : resultLinks) {
            results.add(link.getAttribute("innerText"));
        }

        return results;
    }

    public void clickResultByText(String text) {
        driver.findElement(googleResultLocators.getResultByText(text)).click();
    }

    public void clickResultByIndex(String text) {
        driver.findElement(googleResultLocators.getResultByIndex(text)).click();
    }
}
