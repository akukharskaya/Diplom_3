package praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BaseTest{

    @DisplayName("Переход из личного кабинета в конструктор")
    @Test
    public void transitionToConstructor() {
        homePage.clickPersonalAccount();
        homePage.clickOnButtonConstructor();

        assertTrue(homePage.checkVisibleInscription());
    }

    @DisplayName("Переход во вкладку Начинки")
    @Test
    public void transitionToFilling() {
        homePage.clickOnSectionFilling();

        assertTrue(homePage.checkVisibleFilling());
    }

    @DisplayName("Переход во вкладку Соусы")
    @Test
    public void transitionToSauce() {
        homePage.clickOnSectionSauce();

        assertTrue(homePage.checkVisibleSauce());
    }

    @DisplayName("Переход во вкладку Булки")
    @Test
    public void transitionToBun() {
        homePage.scroll();
        homePage.clickOnSectionBun();

        assertTrue(homePage.checkVisibleBun());
    }
}
