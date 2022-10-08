package com.karine.elements;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class ValidatedEdit extends Element {

    public ValidatedEdit(WebElement element) {
        super(element);
    }

    private void clear() {
        new Actions(this.<RemoteWebDriver>getDriver())
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("a")
                .keyUp(Keys.LEFT_CONTROL)
                .build()
                .perform();
    }

    private void click() {
        new FluentWait<>(getDriver())
                .withTimeout(Duration.of(5, ChronoUnit.SECONDS))
                .pollingEvery(Duration.of(500, ChronoUnit.MILLIS))
                .ignoring(ElementClickInterceptedException.class)
                .until(driver -> {
                    getElement().click();
                    return true;
                });
    }

    public void setText(String text) {
        scrollTo();
        click();
        clear();
        getElement().sendKeys(text);
    }
}
