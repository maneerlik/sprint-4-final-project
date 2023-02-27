package pages;

import org.openqa.selenium.WebDriver;

/**
 * @author  smirnov sergey
 * @since   23.02.2023
 */
public class DzenHomePage {
    private final WebDriver driver;

    /**
     * конструктор
     *
     * @param driver    веб-драйвер.
     */
    public DzenHomePage(WebDriver driver) {
        this.driver = driver;
    }
}