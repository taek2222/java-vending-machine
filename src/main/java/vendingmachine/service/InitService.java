package vendingmachine.service;

import java.util.Arrays;
import java.util.List;
import vendingmachine.constant.InitMenu;
import vendingmachine.domain.Menu;
import vendingmachine.domain.Menus;

public class InitService {

    public Menus initMenuSettings() {
        List<Menu> menus = Arrays.stream(InitMenu.values())
                .map(InitMenu::createMenu)
                .toList();

        return new Menus(menus);
    }
}
