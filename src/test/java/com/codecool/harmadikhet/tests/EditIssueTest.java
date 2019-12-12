package com.codecool.harmadikhet.tests;

import com.codecool.harmadikhet.pages.IssueDetailsPage;
import com.codecool.harmadikhet.pages.IssueEditModalPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EditIssueTest extends BaseTest {

    private IssueDetailsPage issueDetailsPage;
    private IssueEditModalPage issueEditModalPage;

    @BeforeEach
    void setUp() {
        issueDetailsPage = new IssueDetailsPage(driver);
        logInPage.logIn(username, password);
        issueEditModalPage = new IssueEditModalPage(driver);
    }

    @ParameterizedTest
    @CsvSource({"/projects/MTP/issues/MTP-899, summary-edit, summary"})
    void testEditGivenIssue(String url, String editedTitle, String originalTitle) {
        issueDetailsPage.navigateToIssueDetailPage(url);
        issueDetailsPage.editGivenIssue();
        issueEditModalPage.editIssue(editedTitle);
        issueEditModalPage.acceptEdit();
        assertEquals(issueDetailsPage.getEditedIssueSummary(), editedTitle);
        revertIssueChanges(originalTitle);
    }

    @ParameterizedTest
    @CsvSource({"/projects/MTP/issues/MTP-899, summary-edit, summary"})
    void testCancelEditingGivenIssue(String url, String editedTitle, String originalTitle) {
        issueDetailsPage.navigateToIssueDetailPage(url);
        issueDetailsPage.editGivenIssue();
        issueEditModalPage.editIssue(editedTitle);
        issueEditModalPage.cancelEdit();
        assertEquals(issueDetailsPage.getIssueSummary(), originalTitle);
    }

    void revertIssueChanges(String originalTitle) {
        issueDetailsPage.editGivenIssue();
        issueEditModalPage.editIssue(originalTitle);
        issueEditModalPage.acceptEdit();
    }
}
