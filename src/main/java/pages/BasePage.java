package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }


    public void openPage(String url) {
        driver.get(url);
    }
}
