package pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author  smirnov sergey
 * @since   23.02.2023
 */
public class LogoYandexImgComponent {
    private final WebDriver driver;

    private final By logoYandexImg = By.xpath("//img[@alt='Yandex']");

    /**
     * конструктор
     *
     * @param driver    веб-драйвер.
     */
    public LogoYandexImgComponent(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogoYandexImg() {
        driver.findElement(logoYandexImg).click();

        for(String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }
    }
}