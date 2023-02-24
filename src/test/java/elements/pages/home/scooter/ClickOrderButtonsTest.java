package elements.pages.home.scooter;

import config.AppConfig;
import extensions.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.ScooterHomePage;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author  smirnov sergey
 * @since   24.02.2023
 */
public class ClickOrderButtonsTest {
    private WebDriver driver;

    @Before
    public void setup() {
        driver = WebDriverFactory.getDriver(AppConfig.HOME_SCOOTER_URL);
    }

    @Test
    public void orderButtonFromHeader() {
        new ScooterHomePage(driver)
                .clickCookieButton()
                .clickOrderButtonOnHeader();

        assertThat("url не совпадает", AppConfig.ORDER_CUSTOMER_INFO_URL, is(driver.getCurrentUrl()));
    }

    @Test
    public void orderButtonUnderRoadMap() {
        new ScooterHomePage(driver)
                .clickCookieButton()
                .clickOrderButtonUnderRoadMap();

        assertThat("url не совпадает", AppConfig.ORDER_CUSTOMER_INFO_URL, is(driver.getCurrentUrl()));
    }

    @After
    public void teardown() {
        driver.quit();
    }
}