package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {

    @Test
    public void addProductToCartTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        productsPage.openPage("https://www.saucedemo.com/cart.html");
        Assert.assertEquals(cartPage.getProductPrice("Sauce Labs Bolt T-Shirt"), "$15.99");
    }

    @Test
    public void checkOutProductToCartTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        productsPage.openPage("https://www.saucedemo.com/cart.html");
        cartPage.clickButtonCheckout();
        checkoutPage.setFirstName("Lulu");
        checkoutPage.setLastName("Dikkens");
        checkoutPage.setZipCode("12345");
        checkoutPage.clickContinueButton();
        Assert.assertEquals(checkoutPage.getUrlProduct("https://www.saucedemo.com/checkout-step-two.html"),
                "https://www.saucedemo.com/checkout-step-two.html");
    }

    @Test
    public void removeProductToCartTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        productsPage.openPage("https://www.saucedemo.com/cart.html");
        cartPage.clickButtonRemove();
        Assert.assertTrue(cartPage.removeProductToCart() < 1);
    }
}
