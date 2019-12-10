package com.codecool.harmadikhet.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class HomePage extends BasePage {

    private ArrayList<String> tabs;

    @FindBy(id = "header-details-user-fullname")
    private WebElement userIcon;

    @FindBy(id = "log_out")
    private WebElement logoutOption;

    @FindBy(css = "body")
    private WebElement frame;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isUserIconDisplayed() {
        return userIcon.isDisplayed();
    }

    public boolean isLogoutOptionDisplayed() {
        return logoutOption.isDisplayed();
    }

    public void clickUserIcon() {
        userIcon.click();
    }

    public void logout() {
        userIcon.click();
        logoutOption.click();
    }

    public void logoutOnMultipleTabs() {
        openNewTabInBrowser();
        tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(baseUrl);
        driver.switchTo().window(tabs.get(0));
        logout();
        driver.switchTo().window(tabs.get(1));
        driver.navigate().refresh();

    }

    public void openNewTabInBrowser() {
        frame.sendKeys(Keys.CONTROL + "t");
        ((JavascriptExecutor) driver).executeScript("window.open()");
    }

    //TODO: create methods for verify logout on both tabs


}
