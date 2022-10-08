package com.karine.elements;

import org.openqa.selenium.WebElement;

public class Label extends Element {
    public Label(WebElement element) {
        super(element);
    }

    public void assertValue(String expected) {
        String actual = getElement().getText();
        if (!actual.equals(expected)) {
            throw new AssertionError(String.format("Expected: '%s'\nActual: '%s'", expected, actual));
        }
    }
}
