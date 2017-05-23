package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPage extends BasePage{

    private static final By LOGIN_LINK = By.xpath("//a[@href='http://fixber.com/login']/i");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickLoginLink() {
        driver.findElement(LOGIN_LINK).click();
        return new LoginPage(driver);
    }
}