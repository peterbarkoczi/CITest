package com.codecool.harmadikhet.tests;

import com.codecool.harmadikhet.pages.GlassDocumentationPage;
import com.codecool.harmadikhet.pages.SystemSettingsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GlassIssueTypesTest extends BaseTest {

    @BeforeEach
    void setUp() {
        logInPage.logIn(username, password);
    }

    @Test
    void testCompareIssueTypes() {
        GlassDocumentationPage glassDocumentationPage = new GlassDocumentationPage(driver);
        SystemSettingsPage systemSettingsPage = new SystemSettingsPage(driver);
        List<String> issueTypesGlass = glassDocumentationPage.getIssueTypes();
        List<String> issueTypesSystemSettings = systemSettingsPage.getIssueTypesSystemSettings();
        assertTrue(matcher(issueTypesGlass, issueTypesSystemSettings));
    }

    boolean matcher(List<String> compare, List<String> compared) {
        return compare.equals(compared);
    }

}
