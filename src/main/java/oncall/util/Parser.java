package oncall.util;

import java.util.ArrayList;
import java.util.List;

public final class Parser {
    private Parser() { }

    public static int parseIntStrict(String input) {
        Validator.notBlank(input, ErrorMessage.BLANK);
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INT);
        }
    }

    public static List<String> splitAndTrim(String input, String delimiterRegex) {
        Validator.notBlank(input, ErrorMessage.BLANK);

        String[] parts = input.split(delimiterRegex);
        List<String> result = new ArrayList<>();

        for (String p : parts) {
            String token = p.trim();
            Validator.notBlank(token, ErrorMessage.INVALID_FORMAT);
            result.add(token);
        }
        return result;
    }
}