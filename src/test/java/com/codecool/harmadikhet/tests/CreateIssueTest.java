package com.codecool.harmadikhet.tests;

import com.codecool.harmadikhet.pages.CreateIssuePage;
import com.codecool.harmadikhet.pages.HomePage;
import com.codecool.harmadikhet.pages.IssueDetailsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CreateIssueTest extends BaseTest {
    private CreateIssuePage createIssuePage;

    @BeforeEach
    void setupTest() {
        createIssuePage = new CreateIssuePage(driver);
        logInPage.logIn(username, password);
    }

    @Test
    void testCreateIssue() {
        String expectedUUID = createIssuePage.getUUIDinString();
        IssueDetailsPage issueDetailsPage = createIssuePage.createIssue(
                "Main Testing Project", "Bug"
        );
        assertEquals(expectedUUID, issueDetailsPage.getIssueSummary());
        issueDetailsPage.deleteIssue();
    }

    @ParameterizedTest
    @CsvSource({
            "Coala", "Toucan", "Jeti"
    })
    void testSpecificIssueTypesInSpecificProjects(String projectName) {
        List<String> expectedIssueTypes = createExpectedIssueTypes("Story", "Task", "Bug");

        HomePage homePage = new HomePage(driver);
        homePage.clickCreateButton();

        CreateIssuePage createIssuePage = new CreateIssuePage(driver);
        createIssuePage.fillProjectNameField(projectName);

        List<String> actualIssueTypes = createIssuePage.getAvailableIssueTypes();
        for (String expectedIssueType : expectedIssueTypes) {
            assertThat(actualIssueTypes, hasItem(expectedIssueType));
        }

    }

    List<String> createExpectedIssueTypes(String... issueTypes) {
        return new ArrayList<>(Arrays.asList(issueTypes));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/createSubTaskData.csv", numLinesToSkip = 1)
    void testIfSubTaskIsCreatable(String projectName, String issueType) {
        CreateIssuePage createIssuePage = new CreateIssuePage(driver);
        IssueDetailsPage currentIssue = createIssuePage.createIssue(projectName, issueType);

        String uuidString = UUID.randomUUID().toString();
        currentIssue.createSubTask(uuidString);

        List<WebElement> allSubTaskSummaries = currentIssue.getAllSubTaskSummaries();

        verifySubTaskSummaries(uuidString, allSubTaskSummaries);
        currentIssue.deleteIssue();
    }

    private void verifySubTaskSummaries(String uuidString,List<WebElement> allSubTaskSummaries) {
        for (WebElement subTaskSummary : allSubTaskSummaries) {
            assertEquals(uuidString, subTaskSummary.getText());
        }
    }

}
