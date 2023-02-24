package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author  smirnov sergey
 * @since   22.02.2023
 */
public class OrderStatusModalPage {
    private final WebDriver driver;

    private final By seeStatusOrderButton = By.xpath("//button[text()='Посмотреть статус']");
    private final By orderStatusSuccessMessage = By.xpath("//div[contains(@class, '3FDaJ') and text()='Заказ оформлен']");

    /**
     * конструктор
     *
     * @param driver    веб-драйвер.
     */
    public OrderStatusModalPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSeeStatusOrderButton() {
        driver.findElement(seeStatusOrderButton).click();
    }

    public boolean isSuccessfulMessageVisible() {
        return driver.findElement(orderStatusSuccessMessage).isDisplayed();
    }
}