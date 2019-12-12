package com.codecool.harmadikhet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProjectSettingsVersionsPage extends BasePage {

    @FindBy(xpath = "//input[@name='name']")
    private WebElement versionNameField;
    @FindBy(xpath = "//input[@name='description']")
    private WebElement descriptionField;
    @FindBy(xpath = "//button[text()='Add']")
    private WebElement addButton;
    @FindBy(xpath = "//td[starts-with(@class,'versions-table')]")
    private List<WebElement> versionDetails;

    public ProjectSettingsVersionsPage(WebDriver driver) {
        super(driver);
    }

    public void createNewVersion(String name, String description) {
        navigateTo("/plugins/servlet/project-config/PP5/administer-versions?status=unreleased");
        versionNameField.sendKeys(name);
        descriptionField.sendKeys(description);
        addButton.click();
    }
}
