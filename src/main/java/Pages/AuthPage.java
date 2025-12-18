package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthPage extends BaseSeleniumPage{
    @FindBy(xpath = "//div[contains(text(),'Неверное имя пользователя или пароль')]")
    private WebElement failedAuth;

    public AuthPage() {
        PageFactory.initElements(driver, this);}
}
