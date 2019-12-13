package com.codecool.harmadikhet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class IssueDetailsPage extends BasePage {

    @FindBy(xpath = "//a[@id='project-name-val']")
    private WebElement projectName;

    @FindBy(xpath = "//a[@id='key-val']")
    private WebElement projectKey;

    @FindBy(xpath = "//h1[@id='summary-val']")
    private WebElement issueTitle;

    @FindBy(xpath = "//a[@id='edit-issue']")
    private WebElement editButton;

    @FindBy(xpath = "//div[@id='aui-flag-container']")
    private WebElement confirmationAlert;

    @FindBy(id = "opsbar-operations_more")
    private WebElement moreBtn;

    @FindBy(id = "summary-val")
    private WebElement issueSummary;

    @FindBy(id = "delete-issue")
    private WebElement deleteOption;

    @FindBy(id = "delete-issue-submit")
    private WebElement submitDeleteBtn;

    @FindBy(className = "stsummary")
    private List<WebElement> allSubTaskSummaries;

    public void deleteIssue() {
        moreBtn.click();
        deleteOption.click();
        wait.until(ExpectedConditions.elementToBeClickable(submitDeleteBtn)).click();
    }

    public IssueDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToIssueDetailPage(String url) {
        driver.get(baseUrl + url);
        if (driver.getTitle().equals("- Jira")) {
            System.out.println("You can't view this issue. " +
                    "It may have been deleted or you don't have permission to view it.");
        }
    }

    public String getProjectName() {
        return projectName.getText();
    }

    public String getProjectKey() {
        return projectKey.getText();
    }

    public String getEditedIssueSummary() {
        wait.until(ExpectedConditions.invisibilityOf(confirmationAlert));
        return issueTitle.getText();
    }

    public String getIssueSummary() {
        return issueTitle.getText();
    }

    public void editGivenIssue() {
        editButton.click();
    }

    public void createSubTask(String uuidString) {
        moreBtn.click();
        WebElement createSubTaskBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a[href^='/secure/CreateSubTaskIssue']"))
        );
        createSubTaskBtn.click();
        CreateSubTaskModalPage createSubTaskModalPage = new CreateSubTaskModalPage(driver);
        createSubTaskModalPage.createSubTask(uuidString);
    }

    public List<WebElement> getAllSubTaskSummaries() {
        return allSubTaskSummaries;
    }
}


