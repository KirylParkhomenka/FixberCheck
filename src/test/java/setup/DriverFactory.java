package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private static WebDriver driver;

    private static final String IE_DRIVER_PATH = "src/test/resources/IEDriverServer.exe";
    private static final String CHROME_DRIVER_PATH = "src/test/resources/chromedriver.exe";

    private static final int IMPLICIT_WAIT = 20;
    private static final int PAGE_LOAD_TIMEOUT = 20;

    public static WebDriver getWebDriverInstance(WebDriverTypes type) throws Exception {
        switch (type) {
            case FIREFOX: {
                driver = getFirefoxInstance();
                break;
            }
            case CHROME: {
                driver = getChromeInstance();
                break;
            }
            case IE: {
                driver = getIEInstance();
                break;
            }
            default:
                throw new RuntimeException("Unknown web driver specified: " + type);
        }
        prepareTimeouts();
        return driver;
    }

    public static WebDriver getFirefoxInstance() {
        driver = new FirefoxDriver();
        prepareTimeouts();
        return driver;
    }

    public static WebDriver getChromeInstance() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        prepareTimeouts();
        return driver;
    }

    public static WebDriver getIEInstance() {
        System.setProperty("webdriver.ie.driver", IE_DRIVER_PATH);
        driver = new InternetExplorerDriver();
        prepareTimeouts();
        return driver;
    }

    private static void prepareTimeouts() {
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
}