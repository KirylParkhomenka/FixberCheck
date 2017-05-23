package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private static final By LOGIN_FIELD = By.xpath("//input[@name='login']");
    private static final By PASSWORD_FIELD = By.xpath("//input[@name='passw']");
    private static final By ENTER_BUTTON = By.xpath("//input[@name='btn']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MenuPage login() {
        driver.findElement(LOGIN_FIELD).sendKeys("kirjanbi4@yandex.ru");
        driver.findElement(PASSWORD_FIELD).sendKeys("zZ140985");
        driver.findElement(ENTER_BUTTON).click();
        return new MenuPage(driver);
    }
}
