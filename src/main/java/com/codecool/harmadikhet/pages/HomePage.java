package com.codecool.harmadikhet.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class HomePage extends BasePage {

    private LogoutConfirmationPage logoutConfirmationPage = new LogoutConfirmationPage(driver);
    private LogInPage logInPage = new LogInPage(driver);
    private boolean isLoggedInFirstTab = true;
    private boolean isLoggedInSecondTab = true;

    @FindBy(id = "header-details-user-fullname")
    private WebElement userIcon;

    @FindBy(id = "log_out")
    private WebElement logoutOption;

    @FindBy(id = "create_link")
    private WebElement createBtn;

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

    public void clickCreateButton() {
        createBtn.click();
    }

    public void logout() {
        userIcon.click();
        logoutOption.click();
    }

    public void logoutOnMultipleTabs() {
        openNewTabInBrowser();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(baseUrl);
        driver.switchTo().window(tabs.get(0));
        logout();
        if (logoutConfirmationPage.isLogoutConfirmed()) {
            setLoggedInFirstTab(false);
        }
        driver.switchTo().window(tabs.get(1));
        driver.navigate().refresh();
        if (logInPage.isLoginButtonInNavbarVisibleAfterLogout()) {
            setLoggedInSecondTab(false);
        }
    }

    public void openNewTabInBrowser() {
        frame.sendKeys(Keys.CONTROL + "t");
        ((JavascriptExecutor) driver).executeScript("window.open()");
    }

    public void setLoggedInFirstTab(boolean loggedInFirstTab) {
        isLoggedInFirstTab = loggedInFirstTab;
    }

    public void setLoggedInSecondTab(boolean loggedInSecondTab) {
        isLoggedInSecondTab = loggedInSecondTab;
    }

    public boolean isLoggedInFirstTab() {
        return isLoggedInFirstTab;
    }

    public boolean isLoggedInSecondTab() {
        return isLoggedInSecondTab;
    }
}
