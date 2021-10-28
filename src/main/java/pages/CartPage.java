package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private static final String PRODUCT_PRICE = "//*[text()='%s']/ancestor::*[@class='cart_item']//*[@class='inventory_item_price']";
    private static final String BUTTON_CHECKOUT = "#checkout";
    private static final String BUTTON_REMOVE = "#remove-sauce-labs-bolt-t-shirt";

    public String getProductPrice(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();

    }

    public boolean clickButtonCheckout() {
        driver.findElement(By.cssSelector(BUTTON_CHECKOUT)).click();
        return true;
    }

    public boolean clickButtonRemove() {
        driver.findElement(By.cssSelector(BUTTON_REMOVE)).click();
        return true;
    }
}
