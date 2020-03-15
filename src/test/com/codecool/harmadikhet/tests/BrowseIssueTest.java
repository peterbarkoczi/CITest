package com.codecool.harmadikhet.tests;

import com.codecool.harmadikhet.pages.IssueDetailsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrowseIssueTest extends BaseTest {

    private IssueDetailsPage issueDetailsPage;

    @BeforeEach
    void setUp() {
        issueDetailsPage = new IssueDetailsPage(driver);
        logInPage.logIn(username, password);
    }

    /**
     * This test case validates Jira's browse issue feature by a given URL in TOUCAN, JETI and COALA projects.
     * It checks the first three issues in the given project (no. 1,2,3).
     *
     * @param url
     * @param projectName
     * @param projectKey
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/browseIssueTestData.csv", numLinesToSkip = 1)
    void testBrowseIssuesInCoalaJetiToucanProjects(String url, String projectName, String projectKey) {
        issueDetailsPage.navigateToIssueDetailPage(url);
        assertEquals(projectName, issueDetailsPage.getProjectName());
        assertEquals(projectKey, issueDetailsPage.getProjectKey());
    }

    @ParameterizedTest
    @CsvSource({"/browse/MTP-123, Main Testing Project, MTP-123"})
    void testBrowseIssuesInAGivenProject(String url, String projectName, String projectKey) {
        issueDetailsPage.navigateToIssueDetailPage(url);
        assertEquals(projectName, issueDetailsPage.getProjectName());
        assertEquals(projectKey, issueDetailsPage.getProjectKey());
    }
}
