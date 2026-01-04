package oncall.domain;

public enum Month {
    JAN(1, 31),
    FEB(2, 28),
    MAR(3, 31),
    APR(4, 30),
    MAY(5, 31),
    JUN(6, 30),
    JUL(7, 31),
    AUG(8, 31),
    SEP(9, 30),
    OCT(10, 31),
    NOV(11, 30),
    DEC(12, 31);

    final int number;
    final int last;

    Month(int number, int last) {
        this.number = number;
        this.last = last;
    }

    public int getNumber() {
        return number;
    }

    public int getLast() {
        return last;
    }

    public boolean checkBoundary(int day) {
        return number <= day && last >= day;
    }

    public static Month MonthOf(int monthNumber) {
        for (Month cb : values()) {
            if (cb.number == monthNumber) {
                return cb;
            }
        }
        throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력값입니다. 다시 입력해주세요.");
    }
}