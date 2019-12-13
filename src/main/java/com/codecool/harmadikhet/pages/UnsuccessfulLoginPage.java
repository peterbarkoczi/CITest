package com.codecool.harmadikhet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UnsuccessfulLoginPage extends BasePage {

    @FindBy(id = "usernameerror")
    private WebElement errorMessage;

    public UnsuccessfulLoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }

}
