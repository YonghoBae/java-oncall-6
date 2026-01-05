package oncall.util;

import java.util.HashSet;
import java.util.List;

public final class Validator {
    private Validator() { }

    public static void notBlank(String s, String message) {
        if (s == null || s.trim().isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void range(int value, int min, int max, String message) {
        if (value < min || value > max) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void noDuplicate(List<String> list, String message) {
        if (new HashSet<>(list).size() != list.size()) {
            throw new IllegalArgumentException(message);
        }
    }
}