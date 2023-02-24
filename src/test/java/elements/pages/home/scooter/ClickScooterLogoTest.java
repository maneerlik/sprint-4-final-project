package elements.pages.home.scooter;

import config.AppConfig;
import extensions.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.OrderCustomerInfoPage;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author  smirnov sergey
 * @since   23.02.2023
 */
public class ClickScooterLogoTest {
    private WebDriver driver;

    @Before
    public void setup() {
        driver = WebDriverFactory.getDriver(AppConfig.HOME_SCOOTER_URL);
    }

    @Test
    public void clickLogo() {
        new OrderCustomerInfoPage(driver)
                .clickCookieAgreementMsg()
                .clickLogoScooterImg();

        assertThat("страница не та", AppConfig.HOME_SCOOTER_URL, is(driver.getCurrentUrl()));
    }

    @After
    public void teardown() {
        driver.quit();
    }
}