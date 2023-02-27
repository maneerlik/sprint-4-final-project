package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.components.CookieAgreementMsgComponent;
import pages.components.LogoScooterImgComponent;

import java.time.Duration;

/**
 * @author  smirnov sergey
 * @since   22.02.2023
 */
public class OrderCustomerInfoPage {
    private final WebDriver driver;

    private final LogoScooterImgComponent logoScooterImg;
    private final CookieAgreementMsgComponent cookieAgreementMsg;

    private final By nameInput = By.xpath("//input[@placeholder='* Имя']");
    private final By surnameInput = By.xpath("//input[@placeholder='* Фамилия']");
    private final By addressInput = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metroInput = By.xpath("//input[@placeholder='* Станция метро']");
    private final By phoneInput = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By nextButton = By.xpath("//button[text()='Далее']");

    /**
     * конструктор
     *
     * @param driver    веб-драйвер.
     */
    public OrderCustomerInfoPage(WebDriver driver) {
        this.driver = driver;
        this.logoScooterImg = new LogoScooterImgComponent(driver);
        this.cookieAgreementMsg = new CookieAgreementMsgComponent(driver);
    }

    public OrderCustomerInfoPage fillNameInput(String name) {
        driver.findElement(nameInput).sendKeys(name);
        return this;
    }

    public OrderCustomerInfoPage fillSurnameInput(String surname) {
        driver.findElement(surnameInput).sendKeys(surname);
        return this;
    }

    public OrderCustomerInfoPage fillAddressInput(String address) {
        driver.findElement(addressInput).sendKeys(address);
        return this;
    }

    public OrderCustomerInfoPage fillMetroInput(String metro) {
        driver.findElement(metroInput).click();

        // пробует искать метро, если не найдено оставляем поле пустым
        try {
            driver.findElement(By.xpath(String.format(
                    "//ul[contains(@class, 'select-search')]//div[contains(text(), '%s')]//ancestor::button", metro))).click();
        } catch(NoSuchElementException e) {
            driver.findElement(metroInput).sendKeys("");
        }

        return this;
    }

    public OrderCustomerInfoPage fillPhoneInput(String phone) {
        driver.findElement(phoneInput).sendKeys(phone);
        return this;
    }

    public OrderRentInfoPage fillOrderFields(String[] orderData) {
        fillNameInput(orderData[0]);
        fillSurnameInput(orderData[1]);
        fillAddressInput(orderData[2]);
        fillMetroInput(orderData[3]);
        fillPhoneInput(orderData[4]);
        return clickNextButton();
    }

    public OrderRentInfoPage clickNextButton() {
        driver.findElement(nextButton).click();
        return new OrderRentInfoPage(driver);
    }

    public ScooterHomePage clickLogoScooterImg() {
        logoScooterImg.clickLogoScooterImg();
        return new ScooterHomePage(driver);
    }

    public OrderCustomerInfoPage clickCookieAgreementMsg() {
        cookieAgreementMsg.clickCookieButton();
        return this;
    }
}