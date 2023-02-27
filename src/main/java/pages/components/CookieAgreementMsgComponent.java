package pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author  smirnov sergey
 * @since   24.02.2023
 */
public class CookieAgreementMsgComponent {
    private final WebDriver driver;

    private final By cookieButton = By.xpath("//button[contains(@class, 'CookieButton') and text()='да все привыкли']");

    /**
     * конструктор
     *
     * @param driver    веб-драйвер.
     */
    public CookieAgreementMsgComponent(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCookieButton() {
        driver.findElement(cookieButton).click();
    }
}