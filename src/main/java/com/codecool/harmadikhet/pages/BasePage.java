package com.codecool.harmadikhet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public abstract class BasePage {
    protected WebDriver driver;
    protected int timeOutInSeconds = 20;
    protected String baseUrl;

    public BasePage(){}

    BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, timeOutInSeconds), this);
        baseUrl = "https://jira.codecool.codecanvas.hu";
    }
}
