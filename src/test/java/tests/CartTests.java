package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {

    @Test(dataProvider = "User data", dataProviderClass = DataProviderTest.class, retryAnalyzer = Retry.class)
    public void addProductToCartTest(String userName, String password, String productName, String expectedPrice) {
        loginPage.openPage()
                .login(userName, password)
                .addProductToCart(productName);
        cartPage.openPage();
        Assert.assertEquals(cartPage.getProductPrice(productName), expectedPrice);
    }

    @Test
    public void addProductToCartWithPageFactoryTest() {
        loginPageFactory.openPage();
        loginPageFactory.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        cartPage.openPage();
        Assert.assertEquals(cartPage.getProductPrice("Sauce Labs Bolt T-Shirt"), "$15.99");
    }

    @Test
    public void checkOutProductToCartTest () {
        loginPage.openPage()
                .login(System.getProperty("username"), System.getProperty("password"))
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
