package vendingmachine.domain.dto;

public record MenuResponse(
        int id,
        String name,
        int price,
        int quantity
) {
}
