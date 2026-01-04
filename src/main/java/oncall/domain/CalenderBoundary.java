package oncall.domain;

public enum CalenderBoundary {
    JAN(1, 31),
    FEB(1, 28),
    MAR(1, 31),
    APR(1, 30),
    MAY(1, 31),
    JUN(1, 30),
    JUL(1, 31),
    AUG(1, 31),
    SEP(1, 30),
    OCT(1, 31),
    NOV(1, 30),
    DEC(1, 31);

    final int start;
    final int end;

    CalenderBoundary(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public boolean checkBoundary(int day) {
        return start<=day && end>=day;
    }
}