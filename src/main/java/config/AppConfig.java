package config;

/**
 * @author  smirnov sergey
 * @since   22.02.2023
 */
public class AppConfig {
    // url-ы для Scooter
    public static final String HOME_SCOOTER_URL = "https://qa-scooter.praktikum-services.ru/";
    public static final String ORDER_CUSTOMER_INFO_URL = "https://qa-scooter.praktikum-services.ru/order";

    /**
     * приватный конструктор служебного класса
     */
    private AppConfig() {
        throw new IllegalStateException("Utility class");
    }
}