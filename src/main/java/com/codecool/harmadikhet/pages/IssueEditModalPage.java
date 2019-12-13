package com.codecool.harmadikhet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IssueEditModalPage extends BasePage {

    private final By editIssueDialog = By.xpath("//div[@id='edit-issue-dialog']");

    @FindBy(xpath = "//input[@id='summary']")
    private WebElement issueSummary;
    @FindBy(xpath = "//input[@id='edit-issue-submit']")
    private WebElement updateButton;
    @FindBy(xpath = "//a[@href='#' and @class='cancel']")
    private WebElement cancelButton;

    public IssueEditModalPage(WebDriver driver) {
        super(driver);
    }

    public void waitForEditDialogModal() {
        wait.until(ExpectedConditions.presenceOfElementLocated(editIssueDialog));
    }

    public void editIssue(String title) {
        waitForEditDialogModal();
        issueSummary.sendKeys(title);
    }

    public void acceptEdit() {
        updateButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(editIssueDialog));
    }

    public void cancelEdit() {
        cancelButton.click();
        driver.switchTo().alert().accept();
    }


}
