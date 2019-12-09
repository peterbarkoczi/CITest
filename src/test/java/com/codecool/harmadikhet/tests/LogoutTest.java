package com.codecool.harmadikhet.tests;

import com.codecool.harmadikhet.pages.HomePage;
import com.codecool.harmadikhet.pages.LogIn;
import com.codecool.harmadikhet.pages.LogoutConfirmationPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogoutTest extends BaseTest {

    private LogIn logIn;
    private HomePage homePage;
    private LogoutConfirmationPage logoutConfirmationPage;

    @BeforeEach
    public void initObjects() {
        logIn = new LogIn(driver);
        homePage = new HomePage(driver);
        logoutConfirmationPage = new LogoutConfirmationPage(driver);
        logIn.logIn(username, password);
    }

    @Test
    public void testSimpleLoogut() {
        homePage.logout();
        assertTrue(logoutConfirmationPage.isLogoutConfirmed());
    }
}
