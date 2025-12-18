package core;

import Pages.BaseSeleniumPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.net.MalformedURLException;
import java.time.Duration;

import static io.opentelemetry.api.internal.ApiUsageLogger.log;

@Listeners({AllureTestNg.class})
abstract public class BaseSeleniumTest {

    public static WebDriver driver;
    public String baseURL = "https://www.saucedemo.com/";

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws MalformedURLException {
        log("Set up started");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        BaseSeleniumPage.setDriver(driver);
    }

    @AfterMethod(alwaysRun = true)
    @Step("Завершение теста")
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}

