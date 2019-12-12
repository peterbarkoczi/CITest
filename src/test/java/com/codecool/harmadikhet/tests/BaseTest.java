package com.codecool.harmadikhet.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

@TestInstance(Lifecycle.PER_CLASS)
public class BaseTest {
    protected String username;
    protected String password;
    protected WebDriver driver;

    @BeforeAll
    public void setupTestEnvironment() {
        this.username = System.getenv("JIRA_USERNAME");
        this.password = System.getenv("JIRA_PASSWORD");
    }

    @BeforeEach
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", getBasePath() + "/src/test/resources/chromedriver");
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
