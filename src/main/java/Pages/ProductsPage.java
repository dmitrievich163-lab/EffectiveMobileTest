package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductsPage extends BaseSeleniumPage {
    @FindBy(xpath = "//span[contains(text(),'Products')]")
    private WebElement products;

    @FindBy(xpath = "//*[@class=\"error-message-container error\"]//*[contains(text(),'Epic sadface: Username and password do not match any user in this service')]")
    private WebElement errorFalsePassword;

    @FindBy(xpath = "//*[@class=\"error-message-container error\"]//*[contains(text(),'Epic sadface: Sorry, this user has been locked out.')]")
    private WebElement errorLockedUser;

    @FindBy(xpath = "//*[@class=\"error-message-container error\"]//*[contains(text(),'Epic sadface: Username is required')]")
    private WebElement errorFieldsIsEmpty;

    public ProductsPage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Проеряю что открыта страница Products")
    public ProductsPage assertProductsPageIsOpen() {
        Assert.assertTrue(products.isDisplayed(), "Открыта другая страница");
        return this;
    }

    @Step("Проеряю отображение ошибки неверной авторизации")
    public ProductsPage assertErrorFalsePasswordIsDispayed() {
        Assert.assertTrue(errorFalsePassword.isDisplayed(), "Ошибка не отображается");
        return this;
    }

    @Step("Проеряю отображение ошибки заблокированного пользователя")
    public ProductsPage assertErrorLockedUserIsDispayed() {
        Assert.assertTrue(errorLockedUser.isDisplayed(), "Ошибка не отображается");
        return this;
    }

    @Step("Проеряю отображение ошибки незаполненных полей")
    public ProductsPage assertErrorFieldsIsEmptyIsDispayed() {
        Assert.assertTrue(errorFieldsIsEmpty.isDisplayed(), "Ошибка не отображается");
        return this;
    }
}
