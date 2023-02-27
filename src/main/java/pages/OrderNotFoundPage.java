package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author  smirnov sergey
 * @since   24.02.2023
 */
public class OrderNotFoundPage {
    private final WebDriver driver;

    private final By trackNotFoundImg = By.className("Track_NotFound__6oaoY");

    /**
     * конструктор
     *
     * @param driver    веб-драйвер.
     */
    public OrderNotFoundPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isTrackNotFoundImgVisible() {
        return driver.findElement(trackNotFoundImg).isDisplayed();
    }
}
