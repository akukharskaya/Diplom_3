package praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.By;
import praktikum.requests.UserRequest;
import static org.junit.Assert.assertEquals;

public class RegistrationTest extends BaseTest {

    @DisplayName("Успешная регистрация")
    @Test
    public void registrationSuccess() {
        String expected = "Вход";

        UserRequest registrationRequest = UserRequest.builder()
                .email(faker.internet().emailAddress())
                .password(faker.crypto().sha1())
                .name(faker.name().firstName())
                .build();

        homePage.clickPersonalAccount();
        loginPage.clickOnRegistrationButton();
        registrationPage.register(registrationRequest);
        registrationPage.clickOnButtonRegistration();

        assertEquals(expected,driver.findElement(By.xpath(".//*[text()='Вход']")).getText());

        userService.delete(registrationRequest);
    }

    @DisplayName("Неуспешная регистрация с паролем 4 буквы")
    @Test
    public void registrationFailed() {
        String expected = "Некорректный пароль";

        UserRequest registrationRequest = UserRequest.builder()
                .email(faker.internet().emailAddress())
                .password("qwer")
                .name(faker.name().firstName())
                .build();
        homePage.clickPersonalAccount();
        loginPage.clickOnRegistrationButton();
        registrationPage.register(registrationRequest);
        registrationPage.clickOnButtonRegistration();

        assertEquals(expected,driver.findElement(By.xpath(".//*[@class='input__error text_type_main-default']")).getText());
    }
}
