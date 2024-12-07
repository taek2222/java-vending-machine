package vendingmachine.controller;

import vendingmachine.domain.Menu;
import vendingmachine.domain.Menus;
import vendingmachine.domain.VendingMachine;
import vendingmachine.domain.dto.MenuResponse;
import vendingmachine.domain.dto.MenusResponse;
import vendingmachine.service.InitService;
import vendingmachine.service.PaymentService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingmachineController {

    private final InputView inputView;
    private final OutputView outputView;
    private final InitService initService;
    private final PaymentService paymentService;

    public VendingmachineController(InputView inputView, OutputView outputView, InitService initService,
                                    PaymentService paymentService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.initService = initService;
        this.paymentService = paymentService;
    }

    public void run() {
        while (true) {
            outputView.printSalesStart();

            Menus menus = initService.initMenuSettings();
            MenusResponse response = menus.createResponse();

            outputView.printMenus(response);

            int menuId = inputView.readProductSelection();
            Menu menu = menus.findMenuById(menuId);
            MenuResponse response1 = menu.createResponse();

            outputView.printFindMenu(response1);

            VendingMachine vendingMachine = initService.initVendingMachineSettings();

            int choice = inputView.readPaymentMethod();
            if (choice == 12345)


                paymentService.processPayment(choice, menu, vendingMachine);


        }
    }
}
