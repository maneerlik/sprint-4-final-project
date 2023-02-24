package elements.pages.home.scooter;

import config.AppConfig;
import extensions.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pages.ScooterHomePage;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author  smirnov sergey
 * @since   22.02.2023
 */
@RunWith(Parameterized.class)
public class FrequentlyAskedQuestionsTest {
    private WebDriver driver;

    private final String questionButtonText;
    private final String expectedTextAnswerLabel;

    /**
     * конструктор
     *
     * @param questionButtonText            текст нажимаемой кнопки вопроса FAQ.
     * @param expectedTextAnswerLabel       ожидаемый текст ответа FAQ.
     */
    public FrequentlyAskedQuestionsTest(String questionButtonText, String expectedTextAnswerLabel) {
        this.questionButtonText = questionButtonText;
        this.expectedTextAnswerLabel = expectedTextAnswerLabel;
    }

    @Parameterized.Parameters
    public static Object[][] getQuestionsElements() {
        return new Object[][] {
                {"Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если" +
                        " хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {"Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8" +
                        " мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ" +
                        " курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {"Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем" +
                        " расторопнее."},
                {"Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное —" +
                        " всегда можно позвонить в поддержку по красивому номеру 1010."},
                {"Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого" +
                        " хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не" +
                        " понадобится."},
                {"Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки" +
                        " тоже не попросим. Все же свои."},
                {"Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
        };
    }

    @Before
    public void setup() {
        driver = WebDriverFactory.getDriver(AppConfig.HOME_SCOOTER_URL);
    }

    @Test
    public void frequentlyAskedQuestions() {
        assertThat("текст ответа отличается", expectedTextAnswerLabel, is(new ScooterHomePage(driver)
                .clickCookieButton()
                .clickQuestionFAQButton(questionButtonText)
                .getTextOpenedAnswerFAQLabel()
        ));
    }

    @After
    public void teardown() {
        driver.quit();
    }
}