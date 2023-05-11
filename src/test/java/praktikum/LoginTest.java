package praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @DisplayName("Вход по кнопке \"Войти в аккаунт\" на гл странице")
    @Test
    public void loginFromHomePage() {
        homePage.clickOnButtonSignIn();
        loginPage.logIn();
        loginPage.clickOnButtonSignIn();

        assertTrue(homePage.checkVisibleButton());
    }

    @DisplayName("Вход через кнопку \"Личный кабинет\"")
    @Test
    public void loginFromPersonalAccount() {
        homePage.clickPersonalAccount();
        loginPage.logIn();
        loginPage.clickOnButtonSignIn();

        assertTrue(homePage.checkVisibleButton());
    }

    @DisplayName("Вход через кнопку в форме регистрации")
    @Test
    public void loginFromRegistration() {
        homePage.clickPersonalAccount();
        loginPage.clickOnRegistrationButton();
        registrationPage.clickOnButtonSignIn();
        loginPage.logIn();
        loginPage.clickOnButtonSignIn();

        assertTrue(homePage.checkVisibleButton());
    }

    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Test
    public void loginFromForgotPass() {
        homePage.clickPersonalAccount();
        loginPage.clickOnButtonForgotPass();
        loginPage.clickOnButtonSignIn();
        loginPage.logIn();
        loginPage.clickOnButtonSignIn();

        assertTrue(homePage.checkVisibleButton());
    }
}
