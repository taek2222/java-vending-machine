package vendingmachine.view;

import java.text.DecimalFormat;
import java.util.Scanner;
import vendingmachine.validation.CommonValidator;

public class InputView {

    private static final DecimalFormat PRICE_FORMAT = new DecimalFormat("###,###");
    private static final Scanner SCANNER = new Scanner(System.in);

    public int readProductSelection() {
        System.out.println();
        System.out.println("상품을 골라주세요!");
        System.out.print("> ");

        String input = SCANNER.nextLine();
        CommonValidator.validateIsNumeric(input);
        return Integer.parseInt(input);
    }

    public int readPaymentMethod() {
        System.out.println();
        System.out.println("결제 수단을 선택하세요!");
        System.out.println("1. 카드 결제 2. 교통 카드 결제 3. 현금 결제");
        System.out.print("> ");

        String input = SCANNER.nextLine();
        CommonValidator.validateIsNumeric(input);
        return Integer.parseInt(input);
    }

    public String readInputBalance(int balance) {
        System.out.println();
        System.out.printf("현금을 투입해주세요. 현재 투입된 금액은 %s원입니다.",
                PRICE_FORMAT.format(balance)
        );
        System.out.println();
        System.out.print("> ");
        String input = SCANNER.nextLine();
        System.out.println("현금이 투입되었습니다.");

        return input;
    }

    public int readAdminChoice() {
        System.out.println("관리자 메뉴");
        System.out.println("1. 상품 추가 2. 통계 조회 3. 상품 삭제 4. 판매 시작");
        System.out.print("> ");

        String input = SCANNER.nextLine();
        CommonValidator.validateIsNumeric(input);
        return Integer.parseInt(input);
    }

    public String readAdminMenuInfo() {
        System.out.println("상품 정보를 입력하세요 (이름,가격,재고)");
        System.out.print("> ");
        return SCANNER.nextLine();
    }
}
