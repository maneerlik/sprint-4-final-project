package order;

import config.AppConfig;
import extensions.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pages.ScooterHomePage;

import static org.junit.Assert.assertTrue;

/**
 * @author  smirnov sergey
 * @since   22.02.2023
 */
@RunWith(Parameterized.class)
public class PlaceAnOrderPositiveTest {
    private WebDriver driver;

    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phone;

    private final String when;
    private final String termRent;
    private final String color;
    private final String comment;

    /**
     * конструктор
     *
     * @param name      имя клиента.
     * @param surname   фамилия клиента.
     * @param address   адрес клиента.
     * @param metro     станция метро.
     * @param phone     телефон клиента.
     * @param when      когда привезти самокат.
     * @param termRent  срок аренды.
     * @param color     цвет самоката.
     * @param comment   комментарий курьеру.
     */
    public PlaceAnOrderPositiveTest(String name, String surname, String address, String metro, String phone,
                                    String when, String termRent, String color, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.when = when;
        this.termRent = termRent;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getQuestionsElements() {
        return new Object[][]{
                {"Рик", "Санчез", "Шипиловский, 41 корпус 1, 236, Москва, 115551", "Орехово", "89215120000",
                        "23.02.2024", "сутки", "black", "вход со двора"},
                {"Морти", "Смит", "Ракетный б-р, 1, Москва, 129366", "ВДНХ", "89112560000",
                        "23.02.2024", "семеро суток", "grey", ""}
        };
    }

    @Before
    public void setup() {
        driver = WebDriverFactory.getDriver(AppConfig.HOME_SCOOTER_URL);
    }

    @Test
    public void placeAnOrder() {
        assertTrue("заказ не сформирован", new ScooterHomePage(driver)
                .clickCookieButton()
                .clickOrderButtonOnHeader()
                .fillOrderFields(new String[]{name, surname, address, metro, phone})
                .fillRentInfoFields(new String[]{when, termRent, color, comment})
                .clickYesButton()
                .isSuccessfulMessageVisible()
        );
    }

    @After
    public void teardown() {
        driver.quit();
    }
}