package com.karine.pages;

import com.karine.annotations.ElementTitle;
import com.karine.elements.CurrencyField;
import com.karine.elements.Label;
import com.karine.elements.ValidatedEdit;
import org.openqa.selenium.support.FindBy;

@PageTitle("Дебетовые карты")
public class DebitCardPage extends Page {

    @ElementTitle("Ежемесячные расходы")
    @FindBy(xpath = "//div[@data-test-id='amountSlider']//input[@inputmode]")
    ValidatedEdit monthlyExpenses;

    @ElementTitle("Кэшбэк в месяц")
    @FindBy(xpath = "//div[@data-test-id='result-cashback']")
    CurrencyField resultCash;

    @ElementTitle("Ставка")
    @FindBy(xpath = "//div[@data-test-id='cashback-percent']")
    Label cashbackPercent;


}
