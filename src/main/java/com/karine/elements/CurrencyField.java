package com.karine.elements;

import org.openqa.selenium.WebElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CurrencyField extends Label {

    public CurrencyField(WebElement element) {
        super(element);
    }

    @Override
    public void assertValue(String expected) {
        String actual = getElement().getText();
        Matcher matcher = Pattern.compile("\\d(\\d|\\s)*\\d").matcher(actual);
        if (!matcher.find()) {
            throw new AssertionError("Поле не содержит суммы");
        }
        actual = String.join("", matcher.group()
                .split(" "));
        if (!actual.equals(expected)) {
            throw new AssertionError(String.format("Expected: '%s'\nActual: '%s'", expected, actual));
        }
    }
}
