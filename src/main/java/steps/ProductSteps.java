package steps;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProductsPage;

public class ProductSteps {
    private ProductsPage productsPage;
    private LoginPage loginPage;

    public ProductSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    public ProductSteps loginAndAddProductToCart(String userName, String password, String productName) {
        loginPage.openPage()
                .login(userName, password)
                .addProductToCart(productName);
        return this;
    }
}
