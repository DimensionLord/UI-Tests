package com.karine.tests;

import com.karine.actions.IUseActions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.ThreadLocalRandom;

public class DebitCardCashBackTest extends UITest implements IUseActions {

    @Test
    @Parameters({"url", "minSum", "maxSum","rate"})
    void test(String url, int minSum, int maxSum, int rate) {

        int monthlyExpenses = ThreadLocalRandom.current().nextInt(minSum, maxSum + 1);
        BigDecimal bigDecimal=new BigDecimal(monthlyExpenses);
        int expectedReward=bigDecimal.divide(new BigDecimal(100), RoundingMode.HALF_UP)
                .multiply(new BigDecimal(rate))
                .intValue();

        actions().openBrowser(url)
                .mountPage("Главная")
                .clickButton("Альфа-карта")
                .clickButton("Заказать")
                .mountPage("Дебетовые карты")
                .fillValidatedField("Ежемесячные расходы", Integer.toString(monthlyExpenses))
                .checkSum("Кэшбэк в месяц", String.valueOf(expectedReward))
                .checkLabel("Ставка", String.format("%d%%", rate));

    }
}

