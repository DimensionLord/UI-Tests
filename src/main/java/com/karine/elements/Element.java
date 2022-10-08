package com.karine.elements;

import com.karine.driver.IHaveDriver;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public abstract class Element implements IHaveDriver {
    @Getter
    private final WebElement element;

    public Element(WebElement element) {
        this.element = element;
    }

    protected void scrollTo() {
        this.<RemoteWebDriver>getDriver()
                .executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
