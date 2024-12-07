package vendingmachine;

import vendingmachine.controller.VendingmachineController;
import vendingmachine.service.InitService;
import vendingmachine.service.PaymentService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        VendingmachineController vendingmachineController = new VendingmachineController(
                inputView,
                outputView,
                new InitService(),
                new PaymentService(
                        outputView,
                        inputView
                )
        );

        vendingmachineController.run();
    }
}