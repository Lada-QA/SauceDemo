package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    @Description("Get an error message when filling in one field - '{password}'")
    public void errorMessagePasswordLoginTest() {
        loginPage.openPage()
                .setPasswordInput("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");
    }

    @Test
    @Description("Get an error message when filling in one field - '{username}'")
    public void errorMessageUserNameLoginTest() {
        loginPage.openPage()
                .setUsernameInput("standard_user");
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required");
    }
}