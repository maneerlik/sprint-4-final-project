package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.components.CookieAgreementMsgComponent;
import pages.components.LogoYandexImgComponent;

import java.time.Duration;

/**
 * @author  smirnov sergey
 * @since   22.02.2023
 */
public class ScooterHomePage {
    private final WebDriver driver;

    private final LogoYandexImgComponent logoYandexImg;
    private final CookieAgreementMsgComponent cookieAgreementMsg;

    private final By orderButtonOnHeader = By.xpath("//button[@class='Button_Button__ra12g']");
    private final By orderButtonUnderRoadMap = By.xpath("//div[contains(@class, 'FinishButton')]/button[text()='Заказать']");
    private final By orderStatusButton = By.xpath("//button[text()='Статус заказа']");
    private final By searchOrderNumberButton = By.xpath("//button[text()='Go!']");
    private final By orderNumberInput = By.xpath("//input[@type='text']");
    private final By openedAnswerFAQLabel = By.xpath("//div[@class='accordion__item']//div[not(@hidden)]/p");

    /**
     * конструктор
     *
     * @param driver    веб-драйвер.
     */
    public ScooterHomePage(WebDriver driver) {
        this.driver = driver;
        this.logoYandexImg = new LogoYandexImgComponent(driver);
        this.cookieAgreementMsg = new CookieAgreementMsgComponent(driver);
    }

    // метод для клика по кнопке "Заказать" в заголовке
    public OrderCustomerInfoPage clickOrderButtonOnHeader() {
        driver.findElement(orderButtonOnHeader).click();
        return new OrderCustomerInfoPage(driver);
    }

    // метод для клика по кнопке "Заказать" в родмап
    public OrderCustomerInfoPage clickOrderButtonUnderRoadMap() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",
                driver.findElement(orderButtonUnderRoadMap));

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(orderButtonUnderRoadMap)).click();

        return new OrderCustomerInfoPage(driver);
    }

    // метод для клика по кнопке "Cookie"
    public ScooterHomePage clickCookieButton() {
        cookieAgreementMsg.clickCookieButton();
        return this;
    }

    // метод для клика по любому вопросу FAQ
    public ScooterHomePage clickQuestionFAQButton(String textButton) {
        // определяет по какой кнопке произвести клик
        By button = By.xpath("//div[contains(text(),'" + textButton + "')]");
        // прокрутка до необходимой кнопки
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(button));
        // клик по кнопке после того как она станет видна и доступна
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(button)).click();
        return this;
    }

    // метод для клика по лого "Самокат"
    public DzenHomePage clickLogoYandexImg() {
        logoYandexImg.clickLogoYandexImg();
        return new DzenHomePage(driver);
    }

    // метод для клика по кнопке "Статус заказа"
    public ScooterHomePage clickOrderStatusButton() {
        driver.findElement(orderStatusButton).click();
        return this;
    }

    // метод для клика по кнопке "Go!"
    public OrderNotFoundPage clickSearchOrderButton() {
        driver.findElement(searchOrderNumberButton).click();
        return new OrderNotFoundPage(driver);
    }

    // метод для ввода номера заказа
    public ScooterHomePage fillOrderNumberInput(String number) {
        driver.findElement(orderNumberInput).sendKeys(number);
        return this;
    }

    // метод для получения текста активного ответа FAQ
    public String getTextOpenedAnswerFAQLabel() {
        // ждет пока отобразится ответ
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(openedAnswerFAQLabel));
        return driver.findElement(openedAnswerFAQLabel).getText();
    }

    public OrderNotFoundPage checkOrder(String number) {
        clickOrderStatusButton();
        fillOrderNumberInput(number);
        clickSearchOrderButton();
        return new OrderNotFoundPage(driver);
    }
}