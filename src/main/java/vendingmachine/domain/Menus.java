package vendingmachine.domain;

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
}
