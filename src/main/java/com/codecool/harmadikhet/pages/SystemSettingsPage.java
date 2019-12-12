package com.codecool.harmadikhet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SystemSettingsPage extends BasePage {

    @FindBy(xpath = "//a[@class='project-issuetype']")
    private List<WebElement> types;

    public SystemSettingsPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getIssueTypesSystemSettings() {
        navigateTo("/plugins/servlet/project-config/PP5/summary");
        List<String> issueTypes = new ArrayList<>();
        for (WebElement type : types) {
            issueTypes.add(type.getAttribute("title"));
        }
        Collections.sort(issueTypes);
        return issueTypes;
    }
}
