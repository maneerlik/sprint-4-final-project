package pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author  smirnov sergey
 * @since   23.02.2023
 */
public class LogoScooterImgComponent {
    private final WebDriver driver;

    private final By logoScooterImg = By.xpath("//img[@alt='Scooter']");

    /**
     * конструктор
     *
     * @param driver    веб-драйвер.
     */
    public LogoScooterImgComponent(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogoScooterImg() {
        driver.findElement(logoScooterImg).click();
    }
}