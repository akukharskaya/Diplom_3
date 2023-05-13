package praktikum;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import praktikum.pages.HomePage;
import praktikum.pages.LoginPage;
import praktikum.pages.RegistrationPage;
import praktikum.services.UserService;

import java.util.concurrent.TimeUnit;

import static praktikum.config.AppConfig.URL;
import static praktikum.config.WebDriverConfig.WAIT_SECOND_TIMEOUT;

public class BaseTest {
    protected static final String YANDEX_BROWSER = "yandex";
    protected static final String YANDEX_DRIVER_PATH = "/opt/seldrivers/yandexdriver";
    protected static final String YANDEX_BROWSER_PATH = "/opt/yandex/browser/yandex-browser";

    protected WebDriver driver;
    Faker faker = new Faker();

    HomePage homePage;
    LoginPage loginPage;
    RegistrationPage registrationPage;
    UserService userService;

    @Before
    public void setup() {
        String browser = System.getProperty("BROWSER");
        driver = newDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(WAIT_SECOND_TIMEOUT, TimeUnit.SECONDS);
        driver.navigate().to(URL);

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        userService = new UserService();

        RestAssured.baseURI = URL;
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    @After
    public void teardown() {
        if (driver != null)
            driver.quit();
    }

    private static WebDriver newDriver(String browserName) {
        ChromeOptions options = new ChromeOptions();

        if (YANDEX_BROWSER.equals(browserName)) {
            System.setProperty("webdriver.chrome.driver", YANDEX_DRIVER_PATH);
            options.setBinary(YANDEX_BROWSER_PATH);

            return new ChromeDriver(options);
        }

//        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");

        return new ChromeDriver(options);
    }
}
