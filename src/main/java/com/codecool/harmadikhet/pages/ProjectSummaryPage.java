package com.codecool.harmadikhet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectSummaryPage extends BasePage {

    @FindBy(xpath = "//*[@id='summary-body']/div/div[2]/dl/dd[2]")
    private WebElement projectKey;

    public ProjectSummaryPage(WebDriver driver) {
        super(driver);
    }

    public void viewProjectSummary() {
        this.navigateTo("/projects/MTP/summary");
    }

    public String getProjectKey() {
        return projectKey.getText();
    }

}
