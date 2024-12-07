package vendingmachine.domain;

import java.util.List;

public class VendingMachine {

    private final List<Money> balance;

    public VendingMachine(List<Money> balance) {
        this.balance = balance;
    }
}
