package com.codecool.harmadikhet.tests;

import com.codecool.harmadikhet.pages.GlassDocumentationPage;
import com.codecool.harmadikhet.pages.LogInPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GlassIssueTypesTest extends BaseTest {

    private LogInPage logInPage;
    private GlassDocumentationPage glassDocumentationPage;

    @BeforeEach
    public void setUp() {
        logInPage = new LogInPage(driver);
        logInPage.logIn(username, password);
    }

    @Test
    public void letsSee() {
        glassDocumentationPage = new GlassDocumentationPage(driver);
        List<String> elements = glassDocumentationPage.getIssueTypes();
        for (String element : elements) {
            System.out.println(element);
        }

    }

}
