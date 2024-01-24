package org.daedusp.locators;

import org.openqa.selenium.By;

public class GoogleResultLocators {

    private String resultByName = "//h3[.='%s']";
    private String resultByIndex = "(//h3)[%s]";

    public By getResultByText(String text) {
        return By.xpath(String.format(resultByName, text));
    }

    public By getResultByIndex(String text) {
        return By.xpath(String.format(resultByIndex, text));
    }

    public By searchResultLinks = By.xpath("//span//a//cite");
}
