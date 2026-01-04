package oncall.domain;

public enum LegalHoliday {
    NEW_YEAR(1, 1),
    INDEPENDENCE_MOVEMENT(3, 1),
    CHILDREN(5, 5),
    MEMORIAL(6, 6),
    NATIONAL_LIBERATION(8, 15),
    NATIONAL_FOUNDATION(10, 3),
    HANGUL_PROCLAMATION(10, 9),
    CHRISTMAS(12, 25);

    final int month;
    final int day;

    LegalHoliday(int month, int day) {
        this.month = month;
        this.day = day;
    }

    public static boolean isLegalHoliday(int month, int day) {
        for (LegalHoliday legalHoliday : values()) {
            if (month == legalHoliday.month && day == legalHoliday.day) {
                return true;
            }
        }

        return false;
    }
}
