package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseTest {

    @Test
    public void checkoutStepOneTest() {
        loginPage.openPage()
                .login("standard_user", "secret_sauce")
                .addProductToCart("Sauce Labs Bolt T-Shirt")
                .openPage()
                .clickButtonCheckout()
                .setFirstName("Lulu")
                .setLastName("Dikkens")
                .setZipCode("12345");
        checkoutPage.clickContinueButton();
        Assert.assertTrue(productsPage.isProductDisplayedInCart
                ("Sauce Labs Bolt T-Shirt"), "Sauce Labs Bolt T-Shirt");
    }
}

