package praktikum.pages;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import praktikum.requests.UserRequest;


public class RegistrationPage extends BasePage{
    private final By inputName = By.xpath(".//label[text()='Имя']/../input");
    private final By inputEmail = By.xpath(".//label[text()='Email']/../input");
    private final By inputPassword = By.xpath(".//label[text()='Пароль']/../input");
    private final By buttonRegistration = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By failRegistration = By.xpath(".//*[@class='input__error text_type_main-default']");
    private final By buttonSignIn = By.className("Auth_link__1fOlj");
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Регистрация уникального юзера")
    public void register(UserRequest request){
        setInputName(request.getName());
        setInputEmail(request.getEmail());
        setInputPassword(request.getPassword());
    }

    @Step("Ввод Имени")
    private void setInputName(String name) {
        driver.findElement(inputName).sendKeys(name);
    }

    @Step("Ввод Email")
    private void setInputEmail(String mail) {
        driver.findElement(inputEmail).sendKeys(mail);
    }

    @Step("Ввод пароля")
    private void setInputPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }

    @Step("Клик по кнопке \"Зарегистрироваться\"")
    public void clickOnButtonRegistration() {
        driver.findElement(buttonRegistration).click();
    }

    @Step("Вышла ошибка о неправильном пароле")
    public String findError() {
        return driver.findElement(failRegistration).getText();
    }

    @Step("Клик по кнопке \"Вход\"")
    public void clickOnButtonSignIn() {
        driver.findElement(buttonSignIn).click();
    }


}
