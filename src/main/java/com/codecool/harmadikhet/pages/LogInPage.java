package com.codecool.harmadikhet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogInPage extends BasePage {
    private final By byUserIcon = By.id("header-details-user-fullname");

    @FindBy(id = "login-form-username")
    private WebElement usernameInput;

    @FindBy(id = "login-form-password")
    private WebElement passwordInput;

    @FindBy(id = "login")
    private WebElement loginBtn;

    @FindBy(id = "login-container")
    private WebElement logInContainer;

    @FindBy(xpath = "//li[@id='user-options']")
    private WebElement loginBtnNavbar;

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public void logIn(String username, String password) {
        driver.get(baseUrl);
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(byUserIcon));
        } catch (TimeoutException TE) {
            System.out.println("Login attempt failed");
        }
    }

    public boolean isLoginFieldsVisibleAfterLogout() {
        return logInContainer.isDisplayed();
    }

    public boolean isLoginButtonInNavbarVisibleAfterLogout() {
        return loginBtnNavbar.isDisplayed();
    }

}
