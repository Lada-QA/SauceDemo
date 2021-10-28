package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    private static final By FIRST_NAME = By.cssSelector("#first-name");
    private static final By LAST_NAME = By.cssSelector("#last-name");
    private static final By ZIP_CODE = By.cssSelector("#postal-code");
    private static final By BUTTON_CONTINUE = By.cssSelector("#continue");

    public void setFirstName(String username) {
        driver.findElement(FIRST_NAME).sendKeys(username);
    }

    public void setLastName(String password) {
        driver.findElement(LAST_NAME).sendKeys(password);
    }

    public void setZipCode(String password) {
        driver.findElement(ZIP_CODE).sendKeys(password);
    }

    public boolean clickContinueButton() {
        driver.findElement(BUTTON_CONTINUE).click();
        return true;
    }
}
