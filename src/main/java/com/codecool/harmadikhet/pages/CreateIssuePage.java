package com.codecool.harmadikhet.pages;

import com.google.common.collect.Lists;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.UUID;

public class CreateIssuePage extends BasePage {
    UUID uuid = UUID.randomUUID();

    @FindBy(id = "project-field")
    private WebElement projectField;

    @FindBy(className = "aui-blanket")
    private WebElement fullModal;

    @FindBy(id = "issuetype-field")
    private WebElement issueTypeField;

    public String getUUIDinString() {
        return this.uuid.toString();
    }

    public CreateIssuePage(WebDriver driver) {
        super(driver);
    }

    public void setModalField(WebElement field, String input) {
        field.click();
        field.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        field.sendKeys(Keys.BACK_SPACE);
        field.sendKeys(input, Keys.ENTER);
    }

    public void catchPopup() {
        WebElement popUpWindow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("aui-message-success")));
        popUpWindow.findElement(By.tagName("a")).click();
    }

    public IssueDetailsPage createIssue(String projectName, String issueType) {
        HomePage homePage = new HomePage(driver);
        homePage.clickCreateButton();
        setModalField(projectField, projectName);

        WebElement issueTypeField = wait.until(ExpectedConditions.elementToBeClickable(By.id("issuetype-field")));
        issueTypeField.click();
        issueTypeField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        issueTypeField.sendKeys(Keys.BACK_SPACE);
        issueTypeField.sendKeys(issueType, Keys.ENTER);

        WebElement summaryField = wait.until(ExpectedConditions.elementToBeClickable(By.id("summary")));
        summaryField.sendKeys(getUUIDinString());

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("create-issue-submit"))).click();
        wait.until(ExpectedConditions.invisibilityOf(fullModal));
        catchPopup();

        return new IssueDetailsPage(driver);
    }

    public void fillProjectNameField(String projectName) {
        setModalField(projectField, projectName);
    }

    public List<String> getAvailableIssueTypes() {
        WebElement issueTypeField = wait.until(ExpectedConditions.elementToBeClickable((By.id("issuetype-field"))));
        issueTypeField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        issueTypeField.sendKeys(Keys.BACK_SPACE);
        issueTypeField.click();

        WebElement dropdownDiv = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("issuetype-suggestions"))
        );

        List<WebElement> dropdownElements = dropdownDiv.findElements(By.cssSelector("a"));
        return Lists.transform(dropdownElements, WebElement::getText);
    }


}
