package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author  smirnov sergey
 * @since   23.02.2023
 */
public class OrderRentInfoPage {
    private final WebDriver driver;

    private final By orderHeader = By.xpath("//div[@class='Order_Header__BZXOb']");
    private final By whenRentInput = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private final By termRentDropdown = By.className("Dropdown-placeholder");
    private final By colorCheckBoxBlack = By.id("black");
    private final By colorCheckBoxGrey = By.id("grey");
    private final By commentInput = By.xpath("//input[@placeholder='Комментарий для курьера']");
    private final By makeOrderButton = By.xpath("//button[text()='Заказать' and ancestor::div[contains(@class, '1xGrp')]]");

    /**
     * конструктор
     *
     * @param driver    веб-драйвер.
     */
    public OrderRentInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    public OrderRentInfoPage fillWhenRentInput(String date) {
        WebElement selector = driver.findElement(whenRentInput);
        selector.click();
        selector.sendKeys(date);
        selector.sendKeys(Keys.ENTER);
        return this;
    }

    public OrderRentInfoPage fillTermRentDropDown(String term) {
        driver.findElement(termRentDropdown).click();
        driver.findElement(By.xpath("//div[@class='Dropdown-menu']/div[text()='" + term + "']")).click();
        return this;
    }

    public OrderRentInfoPage fillColorScooter(String color) {
        if(color.equals("black")) driver.findElement(colorCheckBoxBlack).click();
        if(color.equals("gray")) driver.findElement(colorCheckBoxGrey).click();
        return this;
    }

    public OrderRentInfoPage fillCommentInput(String comment) {
        driver.findElement(commentInput).sendKeys(comment);
        return this;
    }

    public OrderConfirmModalPage fillRentInfoFields(String[] rentInfoData) {
        fillWhenRentInput(rentInfoData[0]);
        fillTermRentDropDown(rentInfoData[1]);
        fillColorScooter(rentInfoData[2]);
        fillCommentInput(rentInfoData[3]);
        return clickMakeOrderButton();
    }

    public OrderConfirmModalPage clickMakeOrderButton() {
        driver.findElement(makeOrderButton).click();
        return new OrderConfirmModalPage(driver);
    }

    public boolean isOrderHeaderVisible() {
        return driver.findElement(orderHeader).getText().equals("Про аренду");
    }
}