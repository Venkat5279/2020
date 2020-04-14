package com.test.examples;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class BnsfTest {

    private static final NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
    private Map<Float, Integer> bank = new HashMap<>();

    public BnsfTest() {
        bank.put(5f, 5);
        bank.put(1f, 5);
        bank.put(.25f, 5);
    }

    public Map<String, Integer> calculateReturnAmount(final float itemPrice, final float inputMoney) {
        Map<String, Integer> returnCurrency = new HashMap<>();
        float balance = inputMoney - itemPrice;
        addFunds(inputMoney);

        for (Map.Entry<Float, Integer> entry : bank.entrySet()) {
            float currency = entry.getKey();
            if (balance >= currency) {
                int noteCount = (int) (balance / currency);
                bank.put(currency, entry.getValue() - noteCount);
                balance = balance - noteCount * currency;
                returnCurrency.put(currencyFormat.format(currency), noteCount);
            }
        }
        return returnCurrency;
    }

    public void addFunds(float money) {
        if (bank.containsKey(money)) {
            bank.put(money, bank.get(money) + 1);
        } else {
            bank.put(money, 1);
        }
    }

    public static void main(String[] args) {
        BnsfTest bnsfTest = new BnsfTest();
        Map<String, Integer> returnCurrency = bnsfTest.calculateReturnAmount(1.25f, 5f);
        returnCurrency.forEach((k, v) -> System.out.println(k + "  " + v));
    }

}
