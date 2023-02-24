package order;

import config.AppConfig;
import extensions.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.ScooterHomePage;

import static org.junit.Assert.assertTrue;

/**
 * @author  smirnov sergey
 * @since   24.02.2023
 */
public class CheckErrorNotFoundTrackTest {
    private WebDriver driver;
    private final String incorrectOrderNumber = "256";

    @Before
    public void setup() {
        driver = WebDriverFactory.getDriver(AppConfig.HOME_SCOOTER_URL);
    }

    @Test
    public void clickLogo() {
        assertTrue(new ScooterHomePage(driver)
                .clickCookieButton()
                .checkOrder(incorrectOrderNumber)
                .isTrackNotFoundImgVisible()
        );
    }

    @After
    public void teardown() {
        driver.quit();
    }
}