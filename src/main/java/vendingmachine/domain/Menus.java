package vendingmachine.domain;

import static vendingmachine.constant.ErrorMessage.INVALID_FIND_MENU;

import java.util.List;
import java.util.Objects;
import vendingmachine.domain.dto.MenuResponse;
import vendingmachine.domain.dto.MenusResponse;

public class Menus {

    private final List<Menu> menus;

    public Menus(List<Menu> menus) {
        this.menus = menus;
    }

    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    public MenusResponse createResponse() {
        List<MenuResponse> menuResponses = menus.stream()
                .map(Menu::createResponse)
                .filter(Objects::nonNull)
                .toList();

        return new MenusResponse(menuResponses);
    }

    public Menu findMenuById(int id) {
        return menus.stream()
                .filter(menu -> menu.isSameId(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_FIND_MENU.get()));
    }
}
