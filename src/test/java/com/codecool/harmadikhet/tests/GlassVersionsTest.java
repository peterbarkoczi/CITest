package com.codecool.harmadikhet.tests;

import com.codecool.harmadikhet.pages.LogInPage;
import com.codecool.harmadikhet.pages.ProjectSettingsVersionsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GlassVersionsTest extends BaseTest {

    private LogInPage logInPage;
    private ProjectSettingsVersionsPage projectSettingsVersionsPage;

    @BeforeEach
    public void setUp() {
        logInPage = new LogInPage(driver);
        logInPage.logIn(username, password);
    }

    @ParameterizedTest
    @CsvSource({"4.1, test version"})
    public void testCreateNewVersion(String name, String description) {
        projectSettingsVersionsPage = new ProjectSettingsVersionsPage(driver);
        projectSettingsVersionsPage.createNewVersion(name, description);

    }
}
