package SwagLabs;

import Pages.AuthPage;
import core.BaseSeleniumTest;
import org.testng.annotations.Test;

public class AuthorizationTest extends BaseSeleniumTest {
    String login = "standard_user";
    String loginLockedUser = "locked_out_user";
    String loginGlitchUser = "performance_glitch_user";
    String password = "secret_sauce";
    String failedPassword = "secret_sauce1";

    @Test(description = "Успешный логин")
    public void successAuth() {
        new AuthPage().goStartPage(baseURL)
                .setLogin(login)
                .setPassword(password)
                .clickLoginButton()
                .assertProductsPageIsOpen();
    }

    @Test(description = "Логин с неверным паролем")
    public void failedAuthFailedPassword() {
        new AuthPage().goStartPage(baseURL)
                .setLogin(login)
                .setPassword(failedPassword)
                .clickLoginButton()
                .assertErrorFalsePasswordIsDispayed();
    }

    @Test(description = "Логин заблокированного пользователя")
    public void failedAuthLockedUser() {
        new AuthPage().goStartPage(baseURL)
                .setLogin(loginLockedUser)
                .setPassword(password)
                .clickLoginButton()
                .assertErrorLockedUserIsDispayed();
    }

    @Test(description = "Логин с пустыми полями")
    public void failedAuthFieldsIsEmpty() {
        new AuthPage().goStartPage(baseURL)
                .setLogin("")
                .setPassword("")
                .clickLoginButton()
                .assertErrorFieldsIsEmptyIsDispayed();
    }

    @Test(description = "Логин пользователем performance_glitch_user")
    public void successAuthWithGlitchUser() {
        new AuthPage().goStartPage(baseURL)
                .setLogin(loginGlitchUser)
                .setPassword(password)
                .clickLoginButton()
                .assertProductsPageIsOpen();
    }
}
