package oncall.view;

import oncall.domain.EmergencyWorker;
import oncall.domain.EmergencyWorkers;

public class OutputView {
    public void printEmergencyWorkersTable(EmergencyWorkers emergencyWorkers) {
        for (EmergencyWorker emergencyWorker : emergencyWorkers.getTable()) {
            System.out.println(
                    emergencyWorker.getMonth() + "월 " + emergencyWorker.getDay() + "일 " + emergencyWorker.getWeek().getWeekText()
                            + " " + emergencyWorker.getName());
        }
    }
}
