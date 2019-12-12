package com.codecool.harmadikhet.tests;

import com.codecool.harmadikhet.pages.GlassDocumentationPage;
import com.codecool.harmadikhet.pages.LogInPage;
import com.codecool.harmadikhet.pages.SystemSettingsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GlassIssueTypesTest extends BaseTest {

    private LogInPage logInPage;
    private GlassDocumentationPage glassDocumentationPage;
    private SystemSettingsPage systemSettingsPage;

    @BeforeEach
    public void setUp() {
        logInPage = new LogInPage(driver);
        logInPage.logIn(username, password);
    }

    @Test
    public void testCompareIssueTypes() {
        glassDocumentationPage = new GlassDocumentationPage(driver);
        systemSettingsPage = new SystemSettingsPage(driver);
        List<String> issueTypesGlass = glassDocumentationPage.getIssueTypes();
        List<String> issueTypesSystemSettings = systemSettingsPage.getIssueTypesSystemSettings();
        assertTrue(matcher(issueTypesGlass, issueTypesSystemSettings));
    }

    public boolean matcher(List<String> compare, List<String> compared) {
        return compare.equals(compared);
    }

}
