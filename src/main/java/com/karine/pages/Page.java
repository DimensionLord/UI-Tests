package com.karine.pages;

import com.karine.annotations.ElementTitle;
import com.karine.driver.IHaveDriver;
import com.karine.elements.Element;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.lang.reflect.Field;

public abstract class Page implements IHaveDriver {

    public Page() {
    }

    @SneakyThrows
    private <T extends Element> @NotNull T decorate(WebElement element, @NotNull Class<T> targetClass) {
        return targetClass.getConstructor(WebElement.class).newInstance(element);
    }

    public <T extends Element> T getElement(String elementName) {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(ElementTitle.class)) {
                if (field.getAnnotation(ElementTitle.class).value().equals(elementName)) {
                    FindBy by = field.getAnnotation(FindBy.class);
                    WebElement element = new FindBy.FindByBuilder().buildIt(by, null).findElement(getDriver());
                    return decorate(element, (Class<T>) field.getType());
                }
            }
        }
        throw new IllegalArgumentException(String.format("Не смог создать элемент '%s'", elementName));
    }
}
