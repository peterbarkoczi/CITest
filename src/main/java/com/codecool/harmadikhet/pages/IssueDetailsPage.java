package com.codecool.harmadikhet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    public String getProjectSummary() {
        wait.until(ExpectedConditions.invisibilityOf(confirmationAlert));
        //return driver.findElement(By.xpath("//h1[@id='summary-val']")).getText();
        return issueTitle.getText();
    }

    public void editGivenIssue() {
        editButton.click();
    }
}


