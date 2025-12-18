package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthPage extends BaseSeleniumPage{
    @FindBy(xpath = "//*[@id=\"user-name\"]")
    private WebElement userName;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"login-button\"]")
    private WebElement loginButton;

    public AuthPage() {
        PageFactory.initElements(driver, this);}

    @Step("Заполняю поле логин значением {0}")
    public AuthPage setLogin(String value){
        userName.sendKeys(value);
        return this;
    }

    @Step("Заполняю поле пароль значением {0}")
    public AuthPage setPassword(String value){
        password.sendKeys(value);
        return this;
    }

    @Step("Нажимаю кнопку login")
    public ProductsPage clickLoginButton(){
        loginButton.click();
        return new ProductsPage();
    }
}
