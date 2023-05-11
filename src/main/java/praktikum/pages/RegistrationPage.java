package praktikum.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import praktikum.requests.UserRequest;


public class RegistrationPage extends BasePage{
    private final By inputName = By.xpath(".//label[text()='Имя']/../input");
    private final By inputEmail = By.xpath(".//label[text()='Email']/../input");
    private final By inputPassword = By.xpath(".//label[text()='Пароль']/../input");
    private final By buttonRegistration = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By buttonSignIn = By.className("Auth_link__1fOlj");
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void register(UserRequest request){
        setInputName(request.getName());
        setInputEmail(request.getEmail());
        setInputPassword(request.getPassword());
    }

    private void setInputName(String name) {
        driver.findElement(inputName).sendKeys(name);
    }

    private void setInputEmail(String mail) {
        driver.findElement(inputEmail).sendKeys(mail);
    }

    private void setInputPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }

    //клик по кнопке "Зарегистрироваться"
    public void clickOnButtonRegistration() {
        driver.findElement(buttonRegistration).click();
    }

    public void clickOnButtonSignIn() {
        driver.findElement(buttonSignIn).click();
    }


}
