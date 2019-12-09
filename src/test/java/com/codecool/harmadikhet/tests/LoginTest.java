package com.codecool.harmadikhet.tests;

import com.codecool.harmadikhet.pages.HomePage;
import com.codecool.harmadikhet.pages.LogIn;
import com.codecool.harmadikhet.pages.UnsuccessfulLoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {
    private HomePage homePage;
    private LogIn logInPage;
    private UnsuccessfulLoginPage unsuccessfulLoginPage;

    @BeforeEach
    void initObjects() {
        homePage = new HomePage(driver);
        logInPage = new LogIn(driver);
        unsuccessfulLoginPage = new UnsuccessfulLoginPage(driver);
    }

    @ParameterizedTest
    @MethodSource("getCredentialsForSuccessfulLogin")
    public void testSuccessfulLogIn(String username, String password) {
        logInPage.logIn(username, password);
        homePage.clickUserIcon();
        assertTrue(homePage.isUserIconDisplayed());
        assertTrue(homePage.isLogoutOptionDisplayed());
    }

    @ParameterizedTest
    @MethodSource("getCredentialsForUnsuccessfulLogin")
    public void testUnsuccessfulLogIn(String username, String password) {
        logInPage.logIn(username, password);
        assertTrue(unsuccessfulLoginPage.isErrorMessageDisplayed());
    }

    private Stream<Arguments> getCredentialsForUnsuccessfulLogin() {
        return Stream.of(
                Arguments.of(username.toUpperCase(), password),
                Arguments.of(username, password.toUpperCase()),
                Arguments.of(username, "password"),
                Arguments.of("Username", password),
                Arguments.of("", "")
        );
    }

    private Stream<Arguments> getCredentialsForSuccessfulLogin() {
        return Stream.of(
                Arguments.of(this.username, this.password)
        );
    }
}






