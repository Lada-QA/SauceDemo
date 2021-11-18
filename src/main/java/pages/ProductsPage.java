package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private static final String PRODUCTS_PAGE = BASE_URL + "/cart.html";
    private static final String PRODUCT_NAME = "//div[@class='inventory_item_name']";
    private static final String ADD_PRODUCT_TO_CART_BUTTON = "//*[text()='%s']/ancestor::*[@class='inventory_item']//button";

   @Step("Click button {add to cart}")
    public ProductsPage addProductToCart(String productName) {
        waitForElementLocated(driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))), 10);
        WebElement addProductToCartButton = driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName)));
        addProductToCartButton.click();
        return this;
    }

    public boolean isProductDisplayedInCart(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_NAME, productName))).isDisplayed();

    }

    public CartPage openPage() {
        openPage(PRODUCTS_PAGE);
        return new CartPage(driver);
    }
}
