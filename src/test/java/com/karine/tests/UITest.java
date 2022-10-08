package com.karine.tests;

import com.karine.driver.DriverManager;
import lombok.SneakyThrows;
import org.testng.annotations.AfterTest;

public class UITest {
    @SneakyThrows
    @AfterTest
    public void after() {
        DriverManager.getInstance().killDriver();
    }
}
