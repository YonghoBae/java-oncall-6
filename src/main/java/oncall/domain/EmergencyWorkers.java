package oncall.domain;

import java.util.List;

public class EmergencyWorkers {
    List<EmergencyWorker> table;

    public EmergencyWorkers(List<EmergencyWorker> table) {
        this.table = table;
    }

    public void validate(List<EmergencyWorker> weekdaysTurn, List<EmergencyWorker> weekendTurn) {
        // 2일 연속으로 근무하는 경우
        // 평일->휴일, 휴일->평일
    }
}
