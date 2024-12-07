package vendingmachine.util;

import static vendingmachine.constant.ErrorMessage.INVALID_INPUT;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import vendingmachine.constant.MoneyType;
import vendingmachine.domain.Money;

public class BalanceParser {

    public static Money parseInputBalance(String input) {
        Pattern pattern = Pattern.compile("^(\\d+) (\\d+)$");

        Matcher matcher = pattern.matcher(input);

        if (!matcher.find()) {
            throw new IllegalArgumentException(INVALID_INPUT.get());
        }

        int money = Integer.parseInt(matcher.group(1));
        int quantity = Integer.parseInt(matcher.group(2));

        MoneyType moneyType = MoneyType.findMoneyType(money);

        return Money.of(moneyType, quantity);
    }
}
