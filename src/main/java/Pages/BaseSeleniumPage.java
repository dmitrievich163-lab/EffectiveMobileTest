package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

abstract public class BaseSeleniumPage {

    protected static RemoteWebDriver driver;
    protected static WebDriverWait wait;

    public static void setDriver(RemoteWebDriver remoteWebDriver) {
        driver = remoteWebDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5), Duration.ofMillis(100));
    }

    @Step("Открывается стартовая страница")
    public AuthPage goStartPage(String startPage){
        driver.get(startPage);
        return new AuthPage();
    }

//    protected void timeStamp(String name) {
//        System.out.println("" + java.time.LocalTime.now() + ": " + name);
//    }
}
