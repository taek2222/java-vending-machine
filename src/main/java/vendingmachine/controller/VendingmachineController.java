package vendingmachine.controller;

import vendingmachine.domain.Menus;
import vendingmachine.domain.dto.MenusResponse;
import vendingmachine.service.InitService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingmachineController {

    private final InputView inputView;
    private final OutputView outputView;
    private final InitService initService;

    public VendingmachineController(InputView inputView, OutputView outputView, InitService initService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.initService = initService;
    }

    public void run() {
        outputView.printSalesStart();

        Menus menus = initService.initMenuSettings();
        MenusResponse response = menus.createResponse();

        outputView.printMenus(response);
    }
}
