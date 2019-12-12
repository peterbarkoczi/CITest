package com.codecool.harmadikhet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GlassDocumentationPage extends BasePage {

    private List<String> issueTypes = new ArrayList<>();
    @FindBy(xpath = "//td[@class='glass-meta-value'] // child::span")
    private List<WebElement> summaryItems;

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
}
