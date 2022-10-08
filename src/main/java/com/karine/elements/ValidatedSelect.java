package com.karine.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class ValidatedSelect extends Element {
    public ValidatedSelect(WebElement element) {
        super(element);
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


    void open() {
        scrollTo();
        click();
    }

    public void selectByValue(String value) {
        open();
        WebElement element = getDriver().findElement(By.xpath("//li[text()='" + value + "']"));
        Button button = new Button(element);
        button.click();
    }
}
