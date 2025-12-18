package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

abstract public class BaseSeleniumPage {

    protected static WebDriver driver;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    @Step("Открывается стартовая страница")
    public AuthPage goStartPage(String startPage){
        driver.get(startPage);
        return new AuthPage();
    }
}
