package com.codecool.harmadikhet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogIn extends BasePage {

    @FindBy(id = "login-form-username")
    private WebElement usernameInput;

    @FindBy(id = "login-form-password")
    private WebElement passwordInput;

    @FindBy(id = "login")
    private WebElement loginBtn;

    @FindBy(id = "login-container")
    private WebElement logInContainer;

    public LogIn(WebDriver driver) {
        super(driver);
    }

    public void logIn(String username, String password) {
        driver.get(baseUrl);
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

    public boolean isLoginFieldsVisibleAfterLogout() {
        return logInContainer.isDisplayed();
    }

}
