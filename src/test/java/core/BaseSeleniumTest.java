package core;

import Pages.BaseSeleniumPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;


import java.net.MalformedURLException;
import java.time.Duration;

import static io.opentelemetry.api.internal.ApiUsageLogger.log;

@Listeners({AllureTestNg.class})
abstract public class BaseSeleniumTest {

    public static RemoteWebDriver driver;
    public String rootURL;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws MalformedURLException {
        log("Set up started");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        BaseSeleniumPage.setDriver(driver);
    }

    @AfterMethod(alwaysRun = true)
    @Step("Завершение теста")
    public void tearDown(org.testng.ITestResult testResult) {
        driver.close();
        driver.quit();
    }

//        if (SuiteTest.rootURL != null) {
//            for (int i = 0; i < 3; i++) {
//                Response response = RestAssured.given().config(config).post(SuiteTest.TEST_ENV_SERVICE_URL + "/api/envs/" + SuiteTest.env.getId() + "/db/revert");
//                if (response.getStatusCode() == 200) {
//                    log("Test database reverted for env: " + SuiteTest.env);
//                    break;
//                }
//                else {
//                    log("Error while database reverting: " + response.getStatusLine() + ". Trying again");
//                    delay(500);
//                }
//            }
//        }
//
//        if (testResult.isSuccess() && (sessionId != null)) {
//            for (int i = 0; i < 3; i++) {
//                Response response = RestAssured.given().config(config).delete("http://ipm-fz-srv353:4444/video/" + sessionId + ".mp4");
//                if (response.getStatusCode() == 200) {
//                    log("Video 'http://ipm-fz-srv353:4444/video/" + sessionId + ".mp4' deleted");
//                    break;
//                }
//                else {
//                    log("Error while deleting video file at 'http://ipm-fz-srv353:4444/video/" + sessionId + ".mp4': " + response.getStatusLine() + ". Trying again");
//                    delay(500);
//                }
//            }
//        }
//        else
//            log("Test video url: 'http://ipm-fz-srv353:4444/video/" + sessionId + ".mp4'");
//    }
//
//    private void log(String message) {
//        System.out.println("" + java.time.LocalTime.now() + ": " + message);
//    }
//
//    private void delay(int millis) {
//        try {
//            Thread.sleep(Duration.ofMillis(millis));
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
}

