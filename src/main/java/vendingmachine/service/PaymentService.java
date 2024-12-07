package vendingmachine.service;

import static vendingmachine.constant.ErrorMessage.INVALID_INPUT;

import vendingmachine.domain.Menu;
import vendingmachine.domain.Money;
import vendingmachine.domain.VendingMachine;
import vendingmachine.util.BalanceParser;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class PaymentService {

    private final OutputView outputView;
    private final InputView inputView;

    public PaymentService(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void processPayment(int choice, Menu menu, VendingMachine vendingMachine) {
        if (choice == 1 || choice == 2) {
            menu.decreaseQuantity(1);
            vendingMachine.increasesTotalSales(menu.getPrice());

            outputView.printPaymentCompleted();
            return;
        }

        if (choice == 3) {
            while (true) {
                String input = inputView.readInputBalance(vendingMachine.getInputBalance());

                Money money = BalanceParser.parseInputBalance(input);
                vendingMachine.increasesInputBalance(money);

                if (vendingMachine.getInputBalance() >= menu.getPrice()) {

                    // 거스름돈
                    if (vendingMachine.getInputBalance() > menu.getPrice()) {
                        try {
                            int remained = vendingMachine.getInputBalance() - menu.getPrice();
                            String changes = vendingMachine.getChanges(remained);
                            outputView.printPaymentCompleted();
                            outputView.printChange(changes);

                        } catch (IllegalArgumentException e) {
                            outputView.printUnableToPayChange();
                            outputView.printChange(vendingMachine.getUnableToPayChange());
                        }
                    }
                    outputView.printPaymentCompleted();
                    return;
                }
            }
        }

        throw new IllegalArgumentException(INVALID_INPUT.get());
    }
}
