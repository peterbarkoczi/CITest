package com.codecool.harmadikhet.tests;

import com.codecool.harmadikhet.pages.HomePage;
import com.codecool.harmadikhet.pages.LogoutConfirmationPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LogoutTest extends BaseTest {

    private HomePage homePage;
    private LogoutConfirmationPage logoutConfirmationPage;

    @BeforeEach
    void setUp() {
        homePage = new HomePage(driver);
        logoutConfirmationPage = new LogoutConfirmationPage(driver);
        logInPage.logIn(username, password);
    }

    @Test
    void simpleLogout() {
        homePage.logout();
        assertTrue(logoutConfirmationPage.isLogoutConfirmed());
    }

    @Test
    void testBrowseBackAfterLogout() {
        homePage.logout();
        logoutConfirmationPage.browseBackAfterLogout();
        assertTrue(logInPage.isLoginFieldsVisibleAfterLogout());
    }

    @Test
    void testLogoutOnMultipleTabs() {
        homePage.logoutOnMultipleTabs();
        assertFalse(homePage.isLoggedInFirstTab());
        assertFalse(homePage.isLoggedInSecondTab());
    }
}
