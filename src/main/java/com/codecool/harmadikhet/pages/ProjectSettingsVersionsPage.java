package com.codecool.harmadikhet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProjectSettingsVersionsPage extends BasePage {

    private DeleteConfirmationModalPage deleteConfirmationModalPage;

    @FindBy(xpath = "//input[@name='name']")
    private WebElement versionNameField;
    @FindBy(xpath = "//input[@name='description']")
    private WebElement descriptionField;
    @FindBy(xpath = "//button[text()='Add']")
    private WebElement addButton;
    @FindBy(xpath = "//td[starts-with(@class,'versions-table')]")
    private List<WebElement> versionDetails;
    @FindBy(xpath = "//td[@class='dynamic-table__actions']//descendant::div[1]")
    private WebElement versionActions;
    @FindBy(linkText = "Delete")
    private WebElement deleteVersion;

    public ProjectSettingsVersionsPage(WebDriver driver) {
        super(driver);
    }

    public void createNewVersion(String name, String description) {
        navigateTo("/plugins/servlet/project-config/PP5/administer-versions?status=unreleased");
        versionNameField.sendKeys(name);
        descriptionField.sendKeys(description);
        addButton.click();
        driver.navigate().refresh();
    }

    public void deleteNewVersion() {
        navigateTo("/plugins/servlet/project-config/PP5/administer-versions?status=unreleased");
        deleteConfirmationModalPage = new DeleteConfirmationModalPage(driver);
        versionActions.click();
        deleteVersion.click();
        wait.until(ExpectedConditions.elementToBeClickable(deleteConfirmationModalPage.getConfirmDelete()));
        deleteConfirmationModalPage.acceptDelete();
        driver.navigate().refresh();
    }

    public String allVersionDetails(List<WebElement> elements) {
        String allDetails = "";
        for (WebElement element : elements) {
            allDetails += element.getText() + " ";
        }
        return allDetails;
    }

    public boolean checkNewVersionInProjectSettings(String name, String description) {
        String allDetails = allVersionDetails(versionDetails);
        return allDetails.contains(name) && allDetails.contains(description);
    }
}
