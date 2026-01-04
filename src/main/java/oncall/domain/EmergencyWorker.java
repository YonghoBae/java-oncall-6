package oncall.domain;

public class EmergencyWorker {
    String name;
    int month;
    int day;
    Week week;
    boolean isHoliday;

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
