package com.codecool.harmadikhet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GlassDocumentationPage extends BasePage {

    private boolean isNewVersionInGlassDocumentation = false;
    private List<String> issueTypes = new ArrayList<>();
    @FindBy(xpath = "//td[@class='glass-meta-value'] // child::span")
    private List<WebElement> summaryItems;
    @FindBy(xpath = "//a[text()='Versions']")
    private WebElement versions;
    @FindBy(xpath = "//table[@id='versions-table']//descendant::tr")
    private List<WebElement> allVersionsData;


    public GlassDocumentationPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getIssueTypes() {
        navigateTo("/projects/PP5?selectedItem=com.codecanvas.glass:glass");
        for (int i = 6; i > 1; i--) {
            issueTypes.add(summaryItems.get(i).getAttribute("title"));
        }
        Collections.sort(issueTypes);
        return issueTypes;
    }

    public void checkNewVersionInGlassDocumentation(String name, String description) {
        navigateTo("/projects/PP5?selectedItem=com.codecanvas.glass:glass");
        versions.click();
        for (WebElement versionData : allVersionsData) {
            if (versionData.getText().contains(name) && versionData.getText().contains(description)) {
                //System.out.println(versionData.getText());
                isNewVersionInGlassDocumentation = true;
            }
        }
    }

    public boolean isNewVersionInGlassDocumentation() {
        return isNewVersionInGlassDocumentation;
    }
}
