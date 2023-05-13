package praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LogoutTest extends BaseTest{

    @DisplayName("Переход в личный кабинет и выход")
    @Test
    public void logout() throws InterruptedException {
        homePage.clickPersonalAccount();
        loginPage.logIn();
        loginPage.clickOnButtonSignIn();

        homePage.clickPersonalAccount();
        loginPage.clickOnButtonLogout();

        loginPage.waitForSignInButton();

        assertThat(driver.getCurrentUrl()).endsWith("/login");
    }
}
