package com.codecool.harmadikhet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateSubTaskModalPage extends BasePage {

    @FindBy(id = "summary")
    private WebElement summaryField;

    @FindBy(id = "create-issue-submit")
    private WebElement createBtn;

    public CreateSubTaskModalPage(WebDriver driver) {
        super(driver);
    }

    public void createSubTask(String UUIDString) {
        summaryField.sendKeys(UUIDString);
        createBtn.click();
    }
}
