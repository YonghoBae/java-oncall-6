package oncall.service;

import java.util.ArrayList;
import java.util.List;
import oncall.domain.EmergencyWorker;
import oncall.domain.LegalHoliday;
import oncall.domain.Month;
import oncall.domain.EmergencyWorkers;
import oncall.domain.Week;

public class EmergencyWorkService {
    public EmergencyWorkers save(int monthNumber, String startWeekText, List<String> weekdaysNames,
                                 List<String> weekendNames) {
        //1.monthNumber로 이번달 끝 날짜 받아오기
        Month month = Month.MonthOf(monthNumber);
        //2.weekText를 Week로 변환
        Week startWeek = Week.weekOf(startWeekText);
        //3.EmergencyWorker List 만들기(평일, 휴일)
        List<EmergencyWorker> emergencyWorkerList = getEmergencyWorkerList(weekdaysNames, weekendNames,
                startWeek, month);

        //비상근무표 반환
        return new EmergencyWorkers(emergencyWorkerList);
    }

    private List<EmergencyWorker> getEmergencyWorkerList(List<String> weekdaysNames, List<String> weekendNames,
                                                         Week startWeek, Month month) {
        List<EmergencyWorker> emergencyWorkerList = new ArrayList<>();
        //이름크기만큼 반복
        //시작 요일에 맞춰서 0~6 반복
        int namesSize = validateNamesSize(weekdaysNames, weekendNames);

        int weekdaysNamesIndex = 0, weekendNamesIndex = 0;
        for (int day = 1, currentWeek = startWeek.getNumber(); day <= month.getLast(); ++day, currentWeek %= 7) {
            //월은 그대로
            boolean isHoliday = isHoliday(month, currentWeek, day);
            //비상근무자 이름
            String emergencyWorkerName = "";
            if (isHoliday) {
                emergencyWorkerName = weekendNames.get(weekendNamesIndex);
                weekendNamesIndex = (weekendNamesIndex + 1) % namesSize;
            }

            if (!isHoliday) {
                emergencyWorkerName = weekdaysNames.get(weekdaysNamesIndex);
                weekdaysNamesIndex = (weekdaysNamesIndex + 1) % namesSize;
            }

            emergencyWorkerList.add(
                    new EmergencyWorker(emergencyWorkerName, month.getNumber(), day, Week.weekOf(currentWeek),
                            isHoliday));

        }
        return emergencyWorkerList;
    }

    private int validateNamesSize(List<String> weekdaysNames, List<String> weekendNames) {
        if (weekdaysNames.size() != weekendNames.size()) {
            throw new IllegalArgumentException("[ERROR] 입력양식 잘못");
        }

        return weekdaysNames.size();
    }

    private boolean isHoliday(Month month, int currentWeek, int day) {
        //5 or 6일 경우 휴일
        boolean isHoliday = currentWeek == 5 || currentWeek == 6;
        //legal holiday일 경우 휴일
        if (LegalHoliday.isLegalHoliday(month.getNumber(), day)) {
            isHoliday = true;
        }
        //그 외에는 평일
        return isHoliday;
    }

    public void assign(EmergencyWorkers emergencyWorkerTable) {
        //1.
    }
}
