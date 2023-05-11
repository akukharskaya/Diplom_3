package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.requests.UserRequest;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class LoginPage extends BasePage {
    private final By buttonRegistration = By.xpath(".//*[text()='Зарегистрироваться']");
    private final By inputEmail = By.xpath(".//label[text()='Email']/../input");
    private final By inputPassword = By.xpath(".//label[text()='Пароль']/../input");
    private final By buttonSignIn = By.xpath(".//*[text()='Войти']");
    private final By buttonForgotPassword = By.xpath(".//*[text()='Восстановить пароль']");
    private final By buttonLogout = By.xpath(".//button[text()='Выход']");

    UserRequest existingUser = new UserRequest("jimmy.berge@yahoo.com",
            "c531d4d72ab23484254ea24aea649c1a50e1bc6c",
            "jasper.rempel");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnRegistrationButton() {
        driver.findElement(buttonRegistration).click();
    }

    public void setInputEmail(String mail) {
        driver.findElement(inputEmail).sendKeys(mail);
    }

    public void setInputPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }

    public void clickOnButtonSignIn() {
        driver.findElement(buttonSignIn).click();
    }

    public void clickOnButtonForgotPass() {
        driver.findElement(buttonForgotPassword).click();
    }

    public void clickOnButtonLogout() {
        new WebDriverWait(driver, 3)
                .until(visibilityOfElementLocated(buttonLogout));
        driver.findElement(buttonLogout).click();
    }

    public void logIn() {
        setInputEmail(existingUser.getEmail());
        setInputPassword(existingUser.getPassword());
    }

    public void waitForSignInButton() {
        new WebDriverWait(driver, 3)
                .until(visibilityOfElementLocated(By.xpath(".//*[text()='Войти']")));
    }
}
