package com.karine.pages;

import com.karine.annotations.ElementTitle;
import com.karine.elements.Button;
import com.karine.elements.ValidatedEdit;
import com.karine.elements.ValidatedSelect;
import org.openqa.selenium.support.FindBy;

@PageTitle("Калькулятор ипотеки")
public class CalculatorPage extends Page {

    @ElementTitle("Тип программы")
    @FindBy(xpath = "//input[@name='program']")
    ValidatedSelect program;

    @ElementTitle("Стоимость объекта")
    @FindBy(id = "estateCost")
    ValidatedEdit estateCost;

    @ElementTitle("Первоначальный взнос")
    @FindBy(id = "initialFee")
    ValidatedEdit initialFee;

    @ElementTitle("Срок")
    @FindBy(id = "creditTerm")
    ValidatedEdit creditTerm;

    @ElementTitle("Создать график")
    @FindBy(xpath = "//button[.//span[text()='График платежей']]")
    Button createGraphic;

}
