package com.karine.tests;

import com.karine.actions.IUseActions;
import com.karine.pages.CalculatorPage;
import com.karine.pages.GraphicsPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.concurrent.ThreadLocalRandom;

public class MortgageTest extends UITest implements IUseActions {

    @Test
    @Parameters({"url", "programType", "minCost", "maxCost", "minInitialPercent", "maxInitialPercent", "minTerm", "maxTerm"})
    void test(String url, String programType, int minCost, int maxCost, int minInitialPercent,
              int maxInitialPercent, int minTerm, int maxTerm) {
        BigDecimal cost = new BigDecimal(ThreadLocalRandom.current().nextInt(minCost, maxCost + 1));
        int initialPercent = ThreadLocalRandom.current().nextInt(minInitialPercent, maxInitialPercent + 1);
        int initial = cost.divide(new BigDecimal(100), RoundingMode.DOWN)
                .multiply(new BigDecimal(initialPercent))
                .intValue();
        int term = ThreadLocalRandom.current().nextInt(minTerm, maxTerm + 1);
        actions().openBrowser(url)
                .mountPage("Калькулятор ипотеки")
                .selectValidated("Тип программы", programType)
                .fillValidatedField("Стоимость объекта", cost.toPlainString())
                .fillValidatedField("Первоначальный взнос", Integer.toString(initial))
                .fillValidatedField("Срок", Integer.toString(term))
                .clickButton("Создать график")
                .mountPage("График платежей")
                .checkSum("Сумма кредита", cost.subtract(new BigDecimal(initial)).toPlainString())
                .checkDate("Срок", Integer.toString(term));
    }


}
