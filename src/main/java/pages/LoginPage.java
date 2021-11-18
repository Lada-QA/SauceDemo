package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static final By USERNAME_INPUT = By.xpath("//*[@id='user-name']");
    private static final By PASSWORD_INPUT = By.xpath("//*[@id='password']");
    private static final By LOGIN_BUTTON = By.xpath("//*[@id='login-button']");
    private static final By ERROR_MESSAGE = By.xpath(("//div[@class='error-message-container error']"));

   @Step("Login as '{username'} with, '{password}")
    public ProductsPage login(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new ProductsPage(driver);
    }

    @Step("login as '{username}'")
    public void setUsernameInput(String username) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
    }

    @Step("Login as '{password}'")
    public void setPasswordInput(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    @Step("Click button Login")
    public void clickLoginButton() {
        driver.findElement(LOGIN_BUTTON).click();
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    public LoginPage openPage() {
        openPage(BASE_URL);
        return this;
    }
}

