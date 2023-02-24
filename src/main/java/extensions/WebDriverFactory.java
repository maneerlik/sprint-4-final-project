package extensions;

import config.WebDriverConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * @author  smirnov sergey
 * @since   22.02.2023
 */
public class WebDriverFactory {

    /**
     * приватный конструктор служебного класса
     */
    private WebDriverFactory() {
        throw new IllegalStateException("Utility class");
    }

    public static WebDriver getDriver(String url) {
        String browserName = System.getenv().get("browser");

        WebDriver driver;
        switch(browserName) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default: throw new RuntimeException("Browser " + browserName + " not exist");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(WebDriverConfig.WAIT_TEN_SECONDS_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WebDriverConfig.WAIT_TWO_SECONDS_TIMEOUT));
        driver.get(url);

        return driver;
    }
}