package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void errorMessagePasswordLoginTest() {
        loginPage.openPage()
                .setPasswordInput("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");
    }

    @Test
    public void errorMessageUserNameLoginTest() {
        loginPage.openPage()
                .setUsernameInput("standard_user");
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required");
    }
}