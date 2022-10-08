package com.karine.pages;

import com.karine.annotations.ElementTitle;
import com.karine.elements.CurrencyField;
import com.karine.elements.DateField;
import org.openqa.selenium.support.FindBy;

@PageTitle("График платежей")
public class GraphicsPage extends Page {

    @ElementTitle("Сумма кредита")
    @FindBy(xpath = "//div[@alfa-portal-container]//div[./*[text()='Сумма кредита']]/p[@data-test-id='payment-plan-creditSum']")
    CurrencyField currencyField;

    @ElementTitle("Срок")
    @FindBy(xpath = "//div[@alfa-portal-container]//div[./*[text()='Срок']]/p[@data-test-id='payment-plan-creditTerm']")
    DateField dateField;

}
