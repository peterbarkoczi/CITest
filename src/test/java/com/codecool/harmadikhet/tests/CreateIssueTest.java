package com.codecool.harmadikhet.tests;

import com.codecool.harmadikhet.pages.CreateIssuePage;
import com.codecool.harmadikhet.pages.LogInPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreateIssueTest extends BaseTest {
    private LogInPage logInPage;
    private CreateIssuePage createIssuePage;

    @BeforeEach
    public void setupTest() {
        createIssuePage = new CreateIssuePage(driver);
        logInPage = new LogInPage(driver);
        logInPage.logIn(username, password);
    }

    @Test
    public void testCreateIssue() {
        createIssuePage.createIssue();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
