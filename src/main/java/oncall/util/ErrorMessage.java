package oncall.util;

public final class ErrorMessage {
    private ErrorMessage() { }

    public static final String PREFIX = "[ERROR] ";

    public static final String BLANK = "입력은 빈 값일 수 없습니다.";
    public static final String NOT_INT = "정수를 입력해야 합니다.";
    public static final String OUT_OF_RANGE = "입력 범위를 확인하세요.";
    public static final String INVALID_FORMAT = "입력 형식이 올바르지 않습니다.";
}
