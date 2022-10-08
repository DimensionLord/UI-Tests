package com.karine.driver;

import org.openqa.selenium.WebDriver;

public interface IHaveDriver {
    /**
     * Упрощает получение доступа к драйверу
     *
     * @param <T>
     * @return драйвер
     */
    default <T extends WebDriver> T getDriver() {
        return (T) DriverManager.getInstance().getDriver();
    }
}
