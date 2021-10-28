package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseTest {

    @Test
    public void checkoutStepOneTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        productsPage.openPage("https://www.saucedemo.com/cart.html");
        cartPage.clickButtonCheckout();
        checkoutPage.setFirstName("Lulu");
        checkoutPage.setLastName("Dikkens");
        checkoutPage.setZipCode("12345");
        Assert.assertTrue(checkoutPage.clickContinueButton());
    }
}
