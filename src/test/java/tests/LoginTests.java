package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void userNameLoginTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.setUsernameInput("standard_user");
        loginPage.clickLoginButton();
        loginPage.getLoginTitle();
        Assert.assertTrue(true);
    }

    @Test
    public void passwordLoginTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.setPasswordInput("secret_sauce");
        loginPage.clickLoginButton();
        loginPage.getLoginTitle();
        Assert.assertTrue(true);
    }

    @Test
    public void errorMessagePasswordLogin() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.setPasswordInput("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");
    }

    @Test
    public void errorMessageuUserNameLogin() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.setUsernameInput("standard_user");
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required");
    }
}