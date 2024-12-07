package vendingmachine.constant;

import static vendingmachine.constant.ErrorMessage.INVALID_FIND_MENU;
import static vendingmachine.constant.ErrorMessage.INVALID_INPUT;

import java.util.Arrays;

public enum MoneyType {
    ONE_THOUSAND_WON(1000),
    FIVE_ONE_HUNDRED_WON(500),
    ONE_HUNDRED_WON(100),
    FIVE_TEN_WON(50),
    ;

    private final int money;

    MoneyType(int money) {
        this.money = money;
    }

    public int calculateMoneyByQuantity(int quantity) {
        return money * quantity;
    }

    public int calculateSplitTheAmount(int amount) {
        return amount / money;
    }

    public static MoneyType findMoneyType(int money) {
        return Arrays.stream(values())
                .filter(moneyType -> moneyType.money == money)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_INPUT.get()));
    }

    @Override
    public String toString() {
        return String.valueOf(money);
    }
}
