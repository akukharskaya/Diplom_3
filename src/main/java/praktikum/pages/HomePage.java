package praktikum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

    //Кнопка "Личный кабинет" в хедере
    private final By buttonPersonalAccount = By.xpath("//*[text()='Личный Кабинет']/..");
    private final By buttonSignIn = By.xpath("//button[text()='Войти в аккаунт']");
    private final By buttonOrder = By.xpath("//button[text()='Оформить заказ']");
    private final By buttonConstructor = By.xpath("//*[text()='Конструктор']/.");
    private final By inscriptionIsVisible = By.xpath("//*[text()='Соберите бургер']");
    private final By sectionFilling = By.xpath("//*[text()='Начинки']/.");
    private final By fillingIsVisible = By.xpath("//*[text()='Филе Люминесцентного тетраодонтимформа']");
    private final By sectionSauce = By.xpath("//*[text()='Соусы']/.");
    private final By sauceIsVisible = By.xpath("//*[text()='Соус традиционный галактический']");
    private final By sectionBun = By.xpath("//*[text()='Булки']/.");
    private final By bunIsVisible = By.xpath("//*[text()='Флюоресцентная булка R2-D3']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Клик на \"Персональный аккаунт\"")
    public void clickPersonalAccount() {
        driver.findElement(buttonPersonalAccount).click();
    }

    @Step("Клик на \"Войти в аккаунт\"")
    public void clickOnButtonSignIn() {
        driver.findElement(buttonSignIn).click();
    }

    @Step("Проверка видимости кнопки \"Оформить заказ\"")
    public Boolean checkVisibleButton() {
        return driver.findElement(buttonOrder).isDisplayed();
    }

    @Step("Проверка видимости поля \"Соберите бургер\"")
    public Boolean checkVisibleInscription() {
        return driver.findElement(inscriptionIsVisible).isDisplayed();
    }

    @Step("Клик по кнопке \"Конструктор\"")
    public void clickOnButtonConstructor() {
        driver.findElement(buttonConstructor).click();
    }

    @Step("Клик по секции \"Начинки\"")
    public void clickOnSectionFilling() {
        driver.findElement(sectionFilling).click();
    }

    @Step("Проверка видимости элемента в разделе \"Начинки\"")
    public Boolean checkVisibleFilling() {
        return driver.findElement(fillingIsVisible).isDisplayed();
    }

    @Step("Клик по секции \"Соусы\"")
    public void clickOnSectionSauce() {
        driver.findElement(sectionSauce).click();
    }

    @Step("Проверка видимости элемента в разделе \"Соусы\"")
    public Boolean checkVisibleSauce() {
        return driver.findElement(sauceIsVisible).isDisplayed();
    }

    @Step("Клик по секции \"Булки\"")
    public void clickOnSectionBun() {
        driver.findElement(sectionBun).click();
    }

    @Step("Проверка видимости элемента раздела \"Булки\"")
    public Boolean checkVisibleBun() {
        return driver.findElement(bunIsVisible).isDisplayed();
    }

    @Step("Скролл до элемента раздела \"Начинки\"")
    public void scroll() {
        WebElement element = driver.findElement(fillingIsVisible);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
}
