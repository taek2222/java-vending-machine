package vendingmachine.constant;

public enum ErrorMessage {
    INVALID_NAME_BLANK("상품의 이름은 공백일 수 없습니다."),
    INVALID_PRICE_MINIMUM("상품의 가격은 50원 미만일 수 없습니다."),
    INVALID_INPUT("유효 하지 않은 입력 입니다.");

    private static final String PREFIX = "[ERROR] ";
    private static final String RETRY = "다시 입력해 주세요.";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String get() {
        return PREFIX + message + RETRY;
    }

    public String get(Object... value) {
        return PREFIX + String.format(message, value) + RETRY;
    }
}