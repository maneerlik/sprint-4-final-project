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
 * @since   23.02.2023
 */
public class ClickYandexLogoTest {
    private WebDriver driver;

    @Before
    public void setup() {
        driver = WebDriverFactory.getDriver(AppConfig.HOME_SCOOTER_URL);
    }

    @Test
    public void clickLogo() {
        new ScooterHomePage(driver)
                .clickCookieButton()
                .clickLogoYandexImg();

        assertThat("страница не та", "Дзен", is(driver.getTitle()));
    }

    @After
    public void teardown() {
        driver.quit();
    }
}