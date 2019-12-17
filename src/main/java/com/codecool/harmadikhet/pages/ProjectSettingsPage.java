package com.codecool.harmadikhet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProjectSettingsPage extends BasePage {

    @FindBy(xpath = "//a[@class='project-issuetype']")
    private List<WebElement> types;

    public ProjectSettingsPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getIssueTypesFromProjectSettings() {
        navigateTo("/plugins/servlet/project-config/PP5/summary");
        List<String> issueTypes = new ArrayList<>();
        for (WebElement type : types) {
            issueTypes.add(type.getAttribute("title"));
        }
        Collections.sort(issueTypes);
        return issueTypes;
    }
}
