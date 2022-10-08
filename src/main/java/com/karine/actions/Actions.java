package com.karine.actions;

import com.karine.context.PageManager;
import com.karine.driver.IHaveDriver;
import com.karine.elements.*;
import com.karine.pages.Page;
import io.qameta.allure.Step;
import lombok.SneakyThrows;

public class Actions implements IHaveDriver {

    Actions() {

    }

    private Page currentPage;

    private Page getCurrentPage() {
        if (currentPage == null) {
            throw new RuntimeException("Страница не была инициализирована");
        }
        return currentPage;
    }

    @Step("Открываю ссылку '{url}'")
    public Actions openBrowser(String url) {
        getDriver().get(url);
        return this;
    }


    @Step("Открываю страницу '{pageTitle}'")
    public Actions mountPage(String pageTitle) {
        try {
            currentPage = PageManager.getPage(pageTitle);
        } catch (Throwable t) {
            throw new RuntimeException(String.format("Не удалось создать страницу '%s'", pageTitle), t);
        }
        return this;
    }

    @Step("Заполняю поле '{fieldName}' значением '{text}'")
    public Actions fillValidatedField(String fieldName, String text) {
        getCurrentPage().<ValidatedEdit>getElement(fieldName).setText(text);
        return this;
    }

    @Step("Выбираю значение '{text}' в '{combo}'")
    public Actions selectValidated(String combo, String text) {
        getCurrentPage().<ValidatedSelect>getElement(combo)
                .selectByValue(text);
        return this;
    }

    @Step("Нажимаю на кнопку '{button}'")
    public Actions clickButton(String button) {
        getCurrentPage().<Button>getElement(button).click();
        return this;
    }

    @Step("Проверяю, что дата '{fieldName}' равна '{expected}'")
    public Actions checkDate(String fieldName, String expected) {
        getCurrentPage().<DateField>getElement(fieldName).assertValue(expected);
        return this;
    }

    @Step("Проверяю, что сумма '{fieldName}' равна '{expected}'")
    public Actions checkSum(String fieldName, String expected) {
        getCurrentPage().<CurrencyField>getElement(fieldName).assertValue(expected);
        return this;
    }

    @Step("Проверяю, что значение '{fieldName}' равно '{expected}'")
    public Actions checkLabel(String fieldName, String expected) {
        getCurrentPage().<Label>getElement(fieldName).assertValue(expected);
        return this;
    }
}
