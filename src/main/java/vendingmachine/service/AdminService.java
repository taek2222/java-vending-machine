package vendingmachine.service;

import java.util.List;
import vendingmachine.domain.Menu;
import vendingmachine.domain.Menus;
import vendingmachine.domain.VendingMachine;
import vendingmachine.domain.dto.MenusResponse;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class AdminService {

    private final OutputView outputView;
    private final InputView inputView;

    public AdminService(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void processAdmin(VendingMachine vendingMachine, Menus menus) {
        outputView.printAdminApproach();
        int choice = inputView.readAdminChoice();

        while (true) {
            if (choice == 1) {
                String[] split = inputView.readAdminMenuInfo().split(",");

                String name = split[0];
                int price = Integer.parseInt(split[1]);
                int quantity = Integer.parseInt(split[2]);

                Menu menu = Menu.of(11, name, price, quantity);
                menus.addMenu(menu);
            }

            if (choice == 2) {
                displayStatistics(vendingMachine, menus);
            }

            if (choice == 3) {

            }

            if (choice == 4) {
                break;
            }
        }


    }

    private void displayStatistics(VendingMachine vendingMachine, Menus menus) {
        MenusResponse response = menus.createResponse();
        outputView.printAdminMenus(response);

        int totalSales = vendingMachine.getTotalSales();
        outputView.printTotalSales(totalSales);

        List<String> balance = vendingMachine.getBalance();
        outputView.printAdminBalances(balance);
    }
}
