package vendingmachine.constant;

import vendingmachine.domain.Menu;

public enum InitMenu {
    COLA("콜라", 1350),
    ICED_AMERICANO("아이스 아메리카노", 2850),
    ORANGE_JUICE("오렌지 주스", 2500),
    BOTTLED_WATER("생수", 950),
    POTATO_CHIPS("포테이토칩", 1800),
    CHOCO_PIE("초코파이", 1200),
    CANDY_MIX("사탕믹스", 1050),
    WORLDCON("월드콘", 2150),
    MERONA("메로나", 1200),
    SANDWICH("샌드위치", 4150),
    ;

    private static final int STARTING_ID = 10;
    private final String name;
    private final int price;

    InitMenu(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Menu createMenu() {
        return Menu.of(
                STARTING_ID + ordinal(),
                this.name,
                this.price
        );
    }
}

