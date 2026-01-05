package oncall.util;

import java.util.function.Supplier;

public final class InputUtil {
    private InputUtil() { }

    public static <T> T retry(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.PREFIX + e.getMessage());
            }
        }
    }
}