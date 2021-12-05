package pages;

import io.qameta.allure.Step;
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

    @Step("Set '{firstName}' in FirstName input")
    public CheckoutPage setFirstName(String username) {
        driver.findElement(FIRST_NAME).sendKeys(username);
        return this;
    }

    @Step("Set '{lastName}' in lastName input")
    public CheckoutPage setLastName(String password) {
        driver.findElement(LAST_NAME).sendKeys(password);
        return this;
    }

    @Step("Ser '{ZIPCode}' in ZIPCode input")
    public CheckoutPage setZipCode(String password) {
        driver.findElement(ZIP_CODE).sendKeys(password);
        return this;
    }

    @Step("Click button 'continue'")
    public CheckoutPage clickContinueButton() {
        driver.findElement(BUTTON_CONTINUE).click();
        return this;
    }
}
