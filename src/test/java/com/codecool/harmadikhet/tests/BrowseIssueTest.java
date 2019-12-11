package com.codecool.harmadikhet.tests;

import com.codecool.harmadikhet.pages.IssueDetailsPage;
import com.codecool.harmadikhet.pages.LogInPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrowseIssueTest extends BaseTest {

    private LogInPage logInPage;
    private IssueDetailsPage issueDetailsPage;

    @BeforeEach
    public void setUp() {
        logInPage = new LogInPage(driver);
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
    public void testBrowseIssueByUrl(String url, String projectName, String projectKey) {
        issueDetailsPage.navigateToIssueDetailPage(url);
        assertEquals(projectName, issueDetailsPage.getProjectName());
        assertEquals(projectKey, issueDetailsPage.getProjectKey());
    }
}
