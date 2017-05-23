package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.MenuPage;
import setup.Browser;
import util.EmailSender;

public class CheckNewProjects {

    private static final String BASE_URL = "http://fixber.com/";

    private WebDriver driver;
    private LoginPage loginPage;
    private MainPage mainPage;
    private MenuPage menuPage;
    private EmailSender emailSender;

    @BeforeClass()
    public void setUpBefore() {
        driver = Browser.getBrowser("firefox");
        driver.get(BASE_URL);
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        menuPage = new MenuPage(driver);
        emailSender = new EmailSender();
    }

    @Test(description = "Login to Mail.ru mailbox")
    public void loginAndCheckNewProjects() {
        new MainPage(driver).clickLoginLink().login();
        if (new MenuPage(driver).isNewProjectPresents()) {
            new EmailSender().sendMail();
        }
    }

    @AfterClass()
    public void tearDown() {
        driver.quit();
    }
}