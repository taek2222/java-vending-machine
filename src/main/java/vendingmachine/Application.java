package vendingmachine;

import vendingmachine.controller.VendingmachineController;
import vendingmachine.service.InitService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Application {
    public static void main(String[] args) {
        VendingmachineController vendingmachineController = new VendingmachineController(
                new InputView(),
                new OutputView(),
                new InitService()
        );

        vendingmachineController.run();
    }
}