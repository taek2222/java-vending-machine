package vendingmachine.domain;

import vendingmachine.constant.MoneyType;

public class Money {

    private final MoneyType moneyType;
    private final int quantity;

    public Money(MoneyType moneyType, int quantity) {
        this.moneyType = moneyType;
        this.quantity = quantity;
    }

    public static Money of(MoneyType moneyType, int quantity) {
        return new Money(
                moneyType,
                quantity
        );
    }
}
