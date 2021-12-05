package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class CartTests extends BaseTest {

    @Test(dataProvider = "User data", dataProviderClass = DataProviderTest.class, retryAnalyzer = Retry.class)
    @Description("Add product to cart")
    public void addProductToCartTest(String userName, String password, String productName, String expectedPrice) {
        productSteps.loginAndAddProductToCart(userName, password, productName);
        cartPage.openPage();
        Assert.assertEquals(cartPage.getProductPrice(productName), expectedPrice);
    }

    @Test
    @Description("Add product to cart with page Factory")
    public void addProductToCartWithPageFactoryTest() {
        loginPageFactory.openPage();
        loginPageFactory.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        cartPage.openPage();
        Assert.assertEquals(cartPage.getProductPrice("Sauce Labs Bolt T-Shirt"), "$15.99");
    }

   
    public void checkOutProductToCartTest () {
        loginPage.openPage()
                .login(System.getProperty("username", PropertyReader.getProperty("username")),
                        System.getProperty("password", PropertyReader.getProperty("password")))
                .addProductToCart("Sauce Labs Bolt T-Shirt")
                .openPage()
                .clickButtonCheckout()
                .setFirstName("Lulu")
                .setLastName("Dikkens")
                .setZipCode("12345");
        checkoutPage.clickContinueButton();
        Assert.assertEquals("https://www.saucedemo.com/checkout-step-two.html", ("https://www.saucedemo.com/checkout-step-two.html"),
                checkoutPage.getUrl());
    }

    @Test
    public void removeProductToCartTest() {
        loginPage.openPage()
                .login("standard_user", "secret_sauce")
                .addProductToCart("Sauce Labs Bolt T-Shirt")
                .openPage();
        cartPage.clickButtonRemove();
        Assert.assertTrue(cartPage.removeProductFromCart() < 1);
    }
}
