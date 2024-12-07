package vendingmachine.view;

import java.util.Scanner;
import vendingmachine.validation.CommonValidator;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public int readProductSelection() {
        System.out.println();
        System.out.println("상품을 골라주세요!");
        String input = SCANNER.nextLine();

        CommonValidator.validateIsNumeric(input);
        return Integer.parseInt(input);
    }
}
