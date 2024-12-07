package vendingmachine.domain;

import static vendingmachine.constant.ErrorMessage.INVALID_NAME_BLANK;
import static vendingmachine.constant.ErrorMessage.INVALID_PRICE_MINIMUM;

import vendingmachine.domain.dto.MenuResponse;
import vendingmachine.util.RandomUtil;

public class Menu {

    private static final int MINIMUM_PRICE = 50;

    private final int id;
    private final String name;
    private final int price;
    private final int quantity;

    public Menu(int id, String name, int price, int quantity) {
        validateName(name);
        validatePrice(price);
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public static Menu of(int id, String name, int price, int quantity) {
        return new Menu(
                id,
                name,
                price,
                quantity);
    }

    public static Menu of(int id, String name, int price) {
        return of(id, name, price, RandomUtil.generateRandomNumber(10, 30));
    }

    public MenuResponse createResponse() {
        if (quantity == 0) {
            return null;
        }

        return new MenuResponse(
                id,
                name,
                price,
                quantity
        );
    }

    private void validateName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(INVALID_NAME_BLANK.get());
        }
    }

    private void validatePrice(int price) {
        if (price < MINIMUM_PRICE) {
            throw new IllegalArgumentException(INVALID_PRICE_MINIMUM.get());
        }
    }
}
