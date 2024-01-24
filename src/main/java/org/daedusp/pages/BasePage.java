package org.daedusp.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust the timeout as needed

        // Wait until the title is not an empty string
        wait.until((WebDriver driver) -> !driver.getTitle().isEmpty());

        return this.driver.getTitle();
    }
}

