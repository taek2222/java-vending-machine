package vendingmachine.domain.dto;

import java.util.List;

public record MenusResponse(
        List<MenuResponse> menus
) {
}
