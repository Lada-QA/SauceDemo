package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    private static final By FIRST_NAME_INPUT = By.cssSelector("#first-name");
    private static final By LAST_NAME_INPUT = By.cssSelector("#last-name");
    private static final By ZIP_CODE_INPUT = By.cssSelector("#postal-code");
    private static final By BUTTON_CONTINUE = By.cssSelector("#continue");

    public void setFirstName(String username) {
        driver.findElement(FIRST_NAME_INPUT).sendKeys(username);
    }

    public void setLastName(String password) {
        driver.findElement(LAST_NAME_INPUT).sendKeys(password);
    }

    public void setZipCode(String password) {
        driver.findElement(ZIP_CODE_INPUT).sendKeys(password);
    }

    public void clickContinueButton() {
        driver.findElement(BUTTON_CONTINUE).click();
    }
}
