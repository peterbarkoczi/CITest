package com.codecool.harmadikhet.tests;

import com.codecool.harmadikhet.pages.BrowseProjectsPage;
import com.codecool.harmadikhet.pages.ProjectSummaryPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrowseProjectTest extends BaseTest {
    private BrowseProjectsPage browseProjectsPage;
    private ProjectSummaryPage projectSummaryPage;

    @BeforeEach
    void initObjects() {
        browseProjectsPage = new BrowseProjectsPage(driver);
        projectSummaryPage = new ProjectSummaryPage(driver);
        logInPage.logIn(username, password);
    }

    @ParameterizedTest
    @CsvSource({
            "Main Testing Project, MTP"
    })
    void testBrowseAllProjects(String projectName, String projectKey) {
        browseProjectsPage.navigateTo(browseProjectsPage.getExtensionUrl());
        browseProjectsPage.findProject(projectName);
        projectSummaryPage.viewProjectSummary();
        assertEquals(projectKey, projectSummaryPage.getProjectKey());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testBrowseSpecificProjectsData.csv", numLinesToSkip = 1)
    void testSpecificProjects(String url, String expectedKey) {
        projectSummaryPage.navigateTo(url);
        assertEquals(expectedKey, projectSummaryPage.getProjectKey());
    }
}
