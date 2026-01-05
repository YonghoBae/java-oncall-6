package oncall.domain;

public class EmergencyWorker {
    private String name;
    private int month;
    private int day;
    private Week week;
    private boolean isHoliday;

    public EmergencyWorker(String name, int month, int day, Week week, boolean isHoliday) {
        this.name = name;
        this.month = month;
        this.day = day;
        this.week = week;
        this.isHoliday = isHoliday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setWeek(Week week) {
        this.week = week;
    }

    public void setHoliday(boolean holiday) {
        isHoliday = holiday;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public Week getWeek() {
        return week;
    }

    public boolean isHoliday() {
        return isHoliday;
    }
}
