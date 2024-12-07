package vendingmachine.view;

import java.text.DecimalFormat;
import java.util.List;
import vendingmachine.domain.dto.MenuResponse;
import vendingmachine.domain.dto.MenusResponse;

public class OutputView {

    private static final DecimalFormat PRICE_FORMAT = new DecimalFormat("###,###");

    public void printSalesStart() {
        System.out.println("판매 시작!");
    }

    public void printMenus(MenusResponse response) {
        List<MenuResponse> menus = response.menus();

        System.out.println("상품 목록");
        menus.forEach(this::printMenu);
    }

    public void printFindMenu(MenuResponse response) {
        System.out.printf("%s 1개 - %s",
                response.name(),
                PRICE_FORMAT.format(response.price())
        );
    }

    public void printChange(String change) {
        System.out.println("거스름돈 : " + change);
    }

    public void printUnableToPayChange() {
        System.out.println();
        System.out.println("죄송합니다. 현재 거스름돈을 지급할 수 없습니다. 결제를 취소합니다.");
    }

    public void printPaymentCompleted() {
        System.out.println("결제 완료! 감사합니다!");
        System.out.println();
    }

    public void printAdminApproach() {
        System.out.println();
        System.out.println("관리자모드에 진입합니다.");
        System.out.println();
    }

    public void printAdminMenus(MenusResponse response) {
        List<MenuResponse> menus = response.menus();

        System.out.println("상품 별 판매 개수");
        menus.forEach(this::printAdminMenu);
    }

    public void printTotalSales(int totalSales) {
        System.out.println("총 매출");
        System.out.printf("%s원", PRICE_FORMAT.format(totalSales));
    }

    public void printAdminBalances(List<String> balances) {
        System.out.println("현금 잔고");
        balances.forEach(this::printAdminBalance);
    }

    private void printAdminBalance(String balance) {
        System.out.println(balance);
    }

    private void printAdminMenu(MenuResponse response) {
        System.out.printf("%d. %s : %d개",
                    response.id(),
                    response.name(),
                    response.quantity()
                );
    }

    private void printMenu(MenuResponse response) {
        System.out.printf("%d. %s - %s원",
                response.id(),
                response.name(),
                PRICE_FORMAT.format(response.price())
        );

        System.out.println();
    }
}
