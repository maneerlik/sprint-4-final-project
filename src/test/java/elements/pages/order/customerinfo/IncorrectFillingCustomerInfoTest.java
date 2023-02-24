package elements.pages.order.customerinfo;

import config.AppConfig;
import extensions.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pages.OrderCustomerInfoPage;

import static org.junit.Assert.assertFalse;

/**
 * @author  smirnov sergey
 * @since   24.02.2023
 */
@RunWith(Parameterized.class)
public class IncorrectFillingCustomerInfoTest {
    private WebDriver driver;

    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phone;

    /**
     * конструктор
     *
     * @param name      имя клиента.
     * @param surname   фамилия клиента.
     * @param address   адрес клиента.
     * @param metro     станция метро.
     * @param phone     телефон клиента.
     */
    public IncorrectFillingCustomerInfoTest(String name, String surname, String address, String metro, String phone) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
    }

    @Parameterized.Parameters(name = "{index}: Name: {0};  Snm: {1};  Adr: {2};  M: {3};  Phone: {4}")
    public static Object[][] getQuestionsElements() {
        return new Object[][]{
                // проверка валидации имени 0-3
                {"", "Санчез", "Ракетный б-р, 129, Москва", "Лубянка", "89215120000"},
                {"12345", "Санчез", "Ракетный б-р, 129, Москва", "Речной вокзал", "89215120000"},
                {"@+=~/*", "Санчез", "Ракетный б-р, 129, Москва", "Митино", "89215120000"},
                {"Rik", "Санчез", "Ракетный б-р, 129, Москва", "Фили", "89215120000"},

                // проверка валидации фамилии 4-7
                {"Рик", "", "Ракетный б-р, 129, Москва", "Улица 1905 года", "89215120000"},
                {"Рик", "12345", "Ракетный б-р, 129, Москва", "Марксистская", "89215120000"},
                {"Рик", "@+=~/*", "Ракетный б-р, 129, Москва", "Тульская", "89215120000"},
                {"Рик", "Sanchez", "Ракетный б-р, 129, Москва", "Трубная", "89215120000"},

                // проверка валидации адреса 8-11
                {"Рик", "Санчез", "", "Измайлово", "89215120000"},
                {"Рик", "Санчез", "12345", "Зорге", "89215120000"},
                {"Рик", "Санчез", "@+=~/*", "Лихоборы", "89215120000"},
                {"Рик", "Санчез", "ul.Tsvetochnaya d.5 kv.57", "Чкаловская", "89215120000"},

                // проверка валидации метро 12
                {"Рик", "Санчез", "Ракетный б-р, 129, Москва", "", "89215120000"},

                // проверка валидации телефона 13-16 (по маске, очевидно проверять бессмысленно)
                {"Рик", "Санчез", "Ракетный б-р, 129, Москва", "Румянцево", ""},
                {"Рик", "Санчез", "Ракетный б-р, 129, Москва", "Медведково", "ABBBCCCDDFF"},
                {"Рик", "Санчез", "Ракетный б-р, 129, Москва", "Планерная", "@+=~/*"},
                {"Рик", "Санчез", "Ракетный б-р, 129, Москва", "Шоссе Энтузиастов", "8911256000"}
        };
    }

    @Before
    public void setup() {
        driver = WebDriverFactory.getDriver(AppConfig.ORDER_CUSTOMER_INFO_URL);
    }

    @Test
    public void incorrectFillingCustomerInfo() throws InterruptedException {
        assertFalse("валидатор неисправен", new OrderCustomerInfoPage(driver)
                .clickCookieAgreementMsg()
                .fillOrderFields(new String[]{name, surname, address, metro, phone})
                .isOrderHeaderVisible()
        );
    }

    @After
    public void teardown() {
        driver.quit();
    }
}