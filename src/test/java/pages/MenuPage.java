package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage extends BasePage{

    private static final By NEW_PROJECT_ITEM = By.xpath("//div[@class='h-menu-in']/div/font");

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public boolean isNewProjectPresents() {
        return driver.findElement(NEW_PROJECT_ITEM).isDisplayed();
    }
}