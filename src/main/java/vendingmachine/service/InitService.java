package vendingmachine.service;

import static vendingmachine.util.RandomUtil.generateRandomNumber;

import java.util.Arrays;
import java.util.List;
import vendingmachine.constant.InitMenu;
import vendingmachine.constant.MoneyType;
import vendingmachine.domain.Menu;
import vendingmachine.domain.Menus;
import vendingmachine.domain.Money;
import vendingmachine.domain.VendingMachine;

public class InitService {

    private static final int MINIMUM_MONEY_QUANTITY = 1;
    private static final int MAXIMUM_MONEY_QUANTITY = 500;

    public Menus initMenuSettings() {
        List<Menu> menus = Arrays.stream(InitMenu.values())
                .map(InitMenu::createMenu)
                .toList();

        return new Menus(menus);
    }

    public VendingMachine initVendingMachineSettings() {
        return new VendingMachine(createInitMoney());
    }

    private List<Money> createInitMoney() {
        return Arrays.stream(MoneyType.values())
                .map(moneyType -> {
                    int randomNumber = generateRandomNumber(MINIMUM_MONEY_QUANTITY, MAXIMUM_MONEY_QUANTITY);
                    return Money.of(moneyType, randomNumber);
                })
                .toList();
    }
}
