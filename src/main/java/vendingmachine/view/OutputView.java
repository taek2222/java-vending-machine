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

    private void printMenu(MenuResponse response) {
        System.out.printf("%d. %s - %s원",
                response.id(),
                response.name(),
                PRICE_FORMAT.format(response.price()));

        System.out.println();
    }
}
