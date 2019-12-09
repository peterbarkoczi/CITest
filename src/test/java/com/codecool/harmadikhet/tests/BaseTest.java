package com.codecool.harmadikhet.tests;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

@TestInstance(Lifecycle.PER_CLASS)
public class BaseTest {
    protected String username;
    protected String password;
    protected WebDriver driver;
    protected String mainUrl;

    @BeforeAll
    public void setupTestEnvironment() {
        this.username = System.getenv("JIRA_USERNAME");
        this.password = System.getenv("JIRA_PASSWORD");
        this.mainUrl = "https://jira.codecool.codecanvas.hu/";
    }

    @BeforeEach
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", getBasePath() + "/src/main/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
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
