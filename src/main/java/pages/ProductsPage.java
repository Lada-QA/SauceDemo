package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private static final String ADD_PRODUCT_TO_CART_BUTTON = "//*[text()='%s']/ancestor::*[@class='inventory_item']//button";
    private static final String CHECK_PRODUCT_TO_CART_IS_DISPLAYED = "//div[@class='inventory_item_name']";

    public void addProductToCart(String productName) {
        driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).click();
    }

    public boolean productToCartIsDisplayed() {
        return driver.findElement(By.xpath(CHECK_PRODUCT_TO_CART_IS_DISPLAYED)).isDisplayed();
    }
}
