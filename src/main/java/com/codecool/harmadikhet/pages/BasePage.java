package com.codecool.harmadikhet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver driver;
    String baseUrl;
    WebDriverWait wait;

    public BasePage(){}

    public BasePage(WebDriver driver) {
        this.driver = driver;
        int timeOutInSeconds = 20;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, timeOutInSeconds), this);
        baseUrl = "https://jira.codecool.codecanvas.hu";
        wait = new WebDriverWait(driver, timeOutInSeconds);
    }

    public void navigateTo(String extendedUrl) {
        driver.get(baseUrl + extendedUrl);
    }
}
