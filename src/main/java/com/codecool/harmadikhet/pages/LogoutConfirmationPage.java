package com.codecool.harmadikhet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutConfirmationPage extends BasePage {

    @FindBy(xpath = "//h1[text()='Logout']")
    private WebElement logoutConfirmation;

    public LogoutConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLogoutConfirmed() {
        return logoutConfirmation.isDisplayed();
    }

    public void browseBackAfterLogout() {
        driver.navigate().back();
    }
}
