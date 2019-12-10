package com.codecool.harmadikhet.tests;

import com.codecool.harmadikhet.pages.HomePage;
import com.codecool.harmadikhet.pages.LogInPage;
import com.codecool.harmadikhet.pages.LogoutConfirmationPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogoutTest extends BaseTest {

    private LogInPage logIn;
    private HomePage homePage;
    private LogoutConfirmationPage logoutConfirmationPage;

    @BeforeEach
    public void setUp() {
        logIn = new LogInPage(driver);
        homePage = new HomePage(driver);
        logoutConfirmationPage = new LogoutConfirmationPage(driver);
        logIn.logIn(username, password);
    }

    @Test
    public void simpleLogout() {
        homePage.logout();
        assertTrue(logoutConfirmationPage.isLogoutConfirmed());
    }

    @Test
    public void testBrowseBackAfterLogout() {
        homePage.logout();
        logoutConfirmationPage.browseBackAfterLogout();
        assertTrue(logIn.isLoginFieldsVisibleAfterLogout());
    }

    @Test
    public void testLogoutOnMultipleTabs() {
        homePage.logoutOnMultipleTabs();
        //TODO: create assertions for both tabs
    }


}
