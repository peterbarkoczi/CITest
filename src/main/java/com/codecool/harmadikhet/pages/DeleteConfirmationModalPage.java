package com.codecool.harmadikhet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteConfirmationModalPage extends BasePage {

    @FindBy(xpath = "//div[@class='jira-dialog-heading']")
    private WebElement confirmationModalElement;


    @FindBy(xpath = "//input[@id='submit']")
    private WebElement confirmDelete;

    public DeleteConfirmationModalPage(WebDriver driver) {
        super(driver);
    }

    public void acceptDelete() {
        confirmDelete.submit();
    }

    public WebElement getConfirmDelete() {
        return confirmDelete;
    }

    public WebElement getConfirmationModalElement() {
        return confirmationModalElement;
    }
}
