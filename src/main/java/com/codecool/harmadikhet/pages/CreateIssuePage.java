package com.codecool.harmadikhet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.UUID;

public class CreateIssuePage extends BasePage {

    @FindBy(id = "project-field")
    private WebElement projectField;

    @FindBy(className = "aui-blanket")
    private WebElement fullModal;

    public CreateIssuePage(WebDriver driver) {
        super(driver);
    }

    public void setModalField(WebElement field, String input) {
        field.sendKeys(input, Keys.ENTER);
    }

    public void catchPopup() {
//        wait.until(ExpectedConditions.invisibilityOf(fullModal));
        WebElement popUpWindow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("aui-message-success")));
        popUpWindow.findElement(By.tagName("a")).click();
    }

    public void createIssue() {
        HomePage homePage = new HomePage(driver);
        UUID uuid = UUID.randomUUID();
        homePage.clickCreateButton();
        setModalField(projectField, "Main Testing Project");

        WebElement summaryField = wait.until(ExpectedConditions.elementToBeClickable(By.id("summary")));
        setModalField(summaryField, uuid.toString());

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("create-issue-submit"))).click();
        wait.until(ExpectedConditions.invisibilityOf(fullModal));
        catchPopup();

    }

}
