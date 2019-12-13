package com.codecool.harmadikhet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrowseProjectsPage extends BasePage {
    private String extensionUrl;

    @FindBy(id = "project-filter-text")
    private WebElement searchInputField;

    @FindBy(css = "a[title='Main Testing Project']")
    private WebElement mainTestingProjectInList;


    public BrowseProjectsPage(WebDriver driver) {
        super(driver);
        extensionUrl = "/secure/BrowseProjects.jspa?selectedCategory=all&selectedProjectType=all&s=view_projects";
    }

    public String getExtensionUrl() {
        return extensionUrl;
    }

    public void findProject(String projectName) {
        searchInputField.sendKeys(projectName);
        mainTestingProjectInList.click();
    }
}
