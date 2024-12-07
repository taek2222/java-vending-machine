package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private final List<Money> balance;
    private List<Money> inputBalance;
    private int totalSales;

    public VendingMachine(List<Money> balance) {
        this.balance = balance;
        this.inputBalance = new ArrayList<>();
        this.totalSales = 0;
    }

    public int getInputBalance() {
        if (inputBalance == null) {
            return 0;
        }

        return inputBalance.stream()
                .mapToInt(Money::getMoney)
                .sum();
    }

    public String getChanges(int amount) {
        return generateChanges(amount);
    }

    public String getUnableToPayChange() {
        List<String> change = inputBalance.stream()
                .map(Money::toMaxChange)
                .toList();

        return String.join(", ", change);
    }

    private String generateChanges(int amount) {
        List<String> change = new ArrayList<>();

        int remained = getChange(0, amount, change);
        remained = getChange(1, remained, change);
        remained = getChange(2, remained, change);
        remained = getChange(3, remained, change);

        if (remained != 0) {
            throw new IllegalArgumentException();
        }

        return String.join(", ", change);
    }

    private int getChange(int index, int amount, List<String> change) {
        if (balance.get(index).getMoney() > amount) {
            String e = balance.get(index).toMaxChange(amount);
            if (e != null) {
                change.add(e);
            }
            balance.get(index).decreaseQuantity(amount);
            return amount - balance.get(index).calculateMaxChange(amount);
        }

        return amount;
    }

    public void increasesTotalSales(int sellingPrice) {
        totalSales += sellingPrice;
    }

    public void increasesInputBalance(Money money) {
        inputBalance.add(money);
    }

    public int getTotalSales() {
        return totalSales;
    }

    public List<String> getBalance() {
        return balance.stream()
                .map(Money::getBalance)
                .toList();
    }
}
