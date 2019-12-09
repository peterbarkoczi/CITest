package com.codecool.harmadikhet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "header-details-user-fullname")
    private WebElement userIcon;

    @FindBy(id = "log_out")
    private WebElement logoutOption;

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


}
