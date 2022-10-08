package com.karine.elements;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class Button extends Element {
    public Button(WebElement element) {
        super(element);
    }

    public void click() {
        new FluentWait<>(getDriver())
                .withTimeout(Duration.of(5, ChronoUnit.SECONDS))
                .pollingEvery(Duration.of(500, ChronoUnit.MILLIS))
                .ignoring(ElementClickInterceptedException.class)
                .until(driver -> {
                    getElement().click();
                    return true;
                });
    }
}
