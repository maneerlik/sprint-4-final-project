package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author  smirnov sergey
 * @since   22.02.2023
 */
public class OrderConfirmModalPage {
    private final WebDriver driver;

    private final By yesButton = By.xpath("//button[text()='Да']");

    /**
     * конструктор
     *
     * @param driver    веб-драйвер.
     */
    public OrderConfirmModalPage(WebDriver driver) {
        this.driver = driver;
    }

    public OrderStatusModalPage clickYesButton() {
        driver.findElement(yesButton).click();
        return new OrderStatusModalPage(driver);
    }
}