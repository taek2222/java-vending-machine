package vendingmachine.domain;

import vendingmachine.constant.MoneyType;

public class Money {

    private final MoneyType moneyType;
    private int quantity;
    private int recentDecrease;

    public Money(MoneyType moneyType, int quantity) {
        this.moneyType = moneyType;
        this.quantity = quantity;
        this.recentDecrease = 0;
    }

    public static Money of(MoneyType moneyType, int quantity) {
        return new Money(
                moneyType,
                quantity
        );
    }

    public String toMaxChange(int amount) {
        if (calculateMaxChange(amount) == 0) {
            return null;
        }
        return moneyType.toString() + " " + moneyType.calculateSplitTheAmount(amount);
    }

    public String toMaxChange() {
        quantity += recentDecrease;
        return moneyType.toString() + " " + quantity;
    }

    public int calculateMaxChange(int amount) {
        int quantity = moneyType.calculateSplitTheAmount(amount);
        return moneyType.calculateMoneyByQuantity(quantity);
    }

    public int getMoney() {
        return moneyType.calculateMoneyByQuantity(quantity);
    }

    public void decreaseQuantity(int amount) {
        int quantity = moneyType.calculateSplitTheAmount(amount);
        this.recentDecrease = quantity;
        this.quantity -= quantity;
    }

    public String getBalance() {
        return moneyType.toString() + " - " + quantity;
    }
}
