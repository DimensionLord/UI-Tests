package com.karine.driver;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public final class DriverManager {

    private WebDriver driver;

    private DriverManager() {

    }

    private final static DriverManager instance = new DriverManager();

    public static DriverManager getInstance() {
        return instance;
    }

    @Step("Открываю браузер")
    private WebDriver createDriver() {
        File file = new File("driver/chromedriver.exe");
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(file)
                .build();
        ChromeOptions options = new ChromeOptions();
        return new ChromeDriver(service, options);
    }

    public WebDriver getDriver() {
        if (driver == null) {
            driver = createDriver();
        }
        return driver;
    }

    @Step("Закрываю браузер")
    public void killDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
