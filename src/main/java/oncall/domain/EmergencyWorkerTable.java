package oncall.domain;

import java.util.List;

public class EmergencyWorkerTable {
    List<EmergencyWorker> weekdaysTurn;
    List<EmergencyWorker> weekendTurn;

    public EmergencyWorkerTable(List<EmergencyWorker> weekdaysTurn, List<EmergencyWorker> weekendTurn) {
        this.weekdaysTurn = weekdaysTurn;
        this.weekendTurn = weekendTurn;
    }

    public void validate(List<EmergencyWorker> weekdaysTurn, List<EmergencyWorker> weekendTurn) {
        // 2일 연속으로 근무하는 경우
        // 평일->휴일, 휴일->평일
    }
}
