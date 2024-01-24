package org.daedusp.tests;

import org.daedusp.utils.DriverManager;
import org.daedusp.utils.SQLiteConnectionManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.sql.Connection;

public class BaseTest {

    protected WebDriver driver;
    public Connection sqliteConnection;

    @BeforeClass
    public void setUpClass() {
        // Open the SQLite database connection
        sqliteConnection = SQLiteConnectionManager.getSQLiteConnection("src/main/resources/chinook.db");
    }

    @BeforeMethod
    public void setUp() {
        driver = DriverManager.getDriver(); // Implement your driver initialization logic here
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterClass
    public void tearDownClass() {
        // Close the SQLite database connection
        SQLiteConnectionManager.closeSQLiteConnection();
    }
}