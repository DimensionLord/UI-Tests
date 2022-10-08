package com.karine.elements;

import com.karine.utils.DateUtils;
import org.openqa.selenium.WebElement;

public class DateField extends Label {
    public DateField(WebElement element) {
        super(element);
    }

    @Override
    public void assertValue(String value) {
        String actual = getElement().getText();
        String expected = DateUtils.fullYears(value);
        if (!actual.equals(expected)) {
            throw new AssertionError(String.format("Expected: '%s'\nActual: '%s'", expected, actual));
        }
    }
}
