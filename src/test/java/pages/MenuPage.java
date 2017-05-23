package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage extends BasePage{

    private static final By NEW_PROJECT_ITEM = By.xpath("//a[@title='Betty Robbin v1.1']");

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public boolean isNewProjectPresents() {
        return driver.findElement(NEW_PROJECT_ITEM).isDisplayed();
    }
}