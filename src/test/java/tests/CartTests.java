package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {

    @Test(dataProvider = "User data", dataProviderClass = DataProviderTest.class, retryAnalyzer = Retry.class)
    @Description("Add product to cart")
    public void addProductToCartTest(String userName, String password, String productName, String expectedPrice) {
        loginPage.openPage()
                .login(userName, password)
                .addProductToCart(productName);
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

    @Test
    @Description("Remove product from cart")
    public void removeProductFromCartTest() {
        loginPage.openPage()
                .login("standard_user", "secret_sauce")
                .addProductToCart("Sauce Labs Bolt T-Shirt")
                .openPage();
        cartPage.clickButtonRemove();
        Assert.assertTrue(cartPage.removeProductFromCart() < 1);
    }
}
