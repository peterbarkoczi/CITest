package com.codecool.harmadikhet.tests;

import com.codecool.harmadikhet.pages.LogInPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@TestInstance(Lifecycle.PER_CLASS)
public class BaseTest {
    String username;
    String password;
    WebDriver driver;
    LogInPage logInPage;
    Grid grid;


    @BeforeAll
    public void setupTestEnvironment() {
        this.username = System.getenv("JIRA_USERNAME");
        this.password = System.getenv("JIRA_PASSWORD");
    }

    @BeforeEach
    public void initDriver() {
        grid = new Grid(System.getenv("BROWSER"), System.getenv("PLATFORM"));
        try {
            driver = new RemoteWebDriver(new URL(grid.getNodeURL()), grid.getCapabilities());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        logInPage = new LogInPage(driver);
    }

    @AfterEach
    public void quitDriver() {
        driver.quit();
    }

    public String getBasePath() {
        String basePath;
        try {
            basePath = new File("./").getCanonicalPath();
        } catch (IOException e) {
            basePath = "Driver not found...";
            System.err.println(basePath);
            e.printStackTrace();
        }
        return basePath;
    }
}
