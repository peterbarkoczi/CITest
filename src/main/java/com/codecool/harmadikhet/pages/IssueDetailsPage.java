package com.codecool.harmadikhet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IssueDetailsPage extends BasePage {

    @FindBy(xpath = "//a[@id='project-name-val']")
    private WebElement projectName;
    @FindBy(xpath = "//a[@id='key-val']")
    private WebElement projectKey;

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
}


