package org.daedusp.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage extends BasePage {

    private By searchBox = By.name("q");
    private By firstResult = By.xpath("//h3[.='Naruto - Wikipedia, la enciclopedia libre']");

    public GoogleSearchPage(WebDriver driver) {
        super(driver);
    }

    public void enterSearchAndSubmitQuery(String query) {
        driver.findElement(searchBox).sendKeys(query);
        driver.findElement(searchBox).submit();
    }

    public void clickFirstResult() {
        driver.findElement(firstResult).click();
    }
}
