package oncall.domain;

import java.util.Objects;

public enum Week {
    MON("월", 0),
    TUE("화", 1),
    WED("수", 2),
    THU("목", 3),
    FRI("금", 4),
    SAT("토", 5),
    SUN("일", 6);

    private final String weekText;
    private final int number;

    Week(String weekText, int number) {
        this.weekText = weekText;
        this.number = number;
    }

    public String getWeekText() {
        return weekText;
    }

    public int getNumber() {
        return number;
    }

    public static Week weekOf(String weekText) {
        for (Week week : values()) {
            if (Objects.equals(week.weekText, weekText)) {
                return week;
            }
        }

        throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력값입니다. 다시 입력해주세요.");
    }

    public static Week weekOf(int weekNumber) {
        for (Week week : values()) {
            if (week.number == weekNumber) {
                return week;
            }
        }

        throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력값입니다. 다시 입력해주세요.");
    }


}
