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

    @Test
    public void successAuth() {
        new AuthPage().goStartPage(baseURL)
                .setLogin(login)
                .setPassword(password)
                .clickLoginButton()
                .assertProductsPageIsOpen();
    }

    @Test
    public void failedAuthFailedPassword() {
        new AuthPage().goStartPage(baseURL)
                .setLogin(login)
                .setPassword(failedPassword)
                .clickLoginButton()
                .assertErrorFalsePasswordIsDispayed();
    }

    @Test
    public void failedAuthLockedUser() {
        new AuthPage().goStartPage(baseURL)
                .setLogin(loginLockedUser)
                .setPassword(password)
                .clickLoginButton()
                .assertErrorLockedUserIsDispayed();
    }

    @Test
    public void failedAuthFieldsIsEmpty() {
        new AuthPage().goStartPage(baseURL)
                .setLogin("")
                .setPassword("")
                .clickLoginButton()
                .assertErrorFieldsIsEmptyIsDispayed();
    }

    @Test
    public void successAuthWithGlitchUser() {
        new AuthPage().goStartPage(baseURL)
                .setLogin(loginGlitchUser)
                .setPassword(password)
                .clickLoginButton()
                .assertProductsPageIsOpen();
    }
}
