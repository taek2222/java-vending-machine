package vendingmachine.constant;

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
}
