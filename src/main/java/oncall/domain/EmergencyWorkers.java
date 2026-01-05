package oncall.domain;

import java.util.List;

public class EmergencyWorkers {
    List<EmergencyWorker> table;

    public EmergencyWorkers(List<EmergencyWorker> table) {
        validate(table);

        this.table = table;
    }

    public void validate(List<EmergencyWorker> table) {
        int n = table.size();

        for (int i = 0; i < n - 1; i++) {
            if (!table.get(i).getName().equals(table.get(i + 1).getName())) {
                continue;
            }

            // i와 i+1이 연속 같은 사람이면, i+2 이후에서 같은 휴일타입 칸을 찾아 name만 swap
            int swapIdx = -1;
            boolean targetHoliday = table.get(i + 1).isHoliday();
            String duplicatedName = table.get(i).getName();

            for (int j = i + 2; j < n; j++) {
                if (table.get(j).isHoliday() != targetHoliday) {
                    continue;
                }
                if (table.get(j).getName().equals(duplicatedName)) {
                    continue;
                }

                // (선택) 스왑 후에도 연속이 생기지 않도록 최소한의 체크
                String candidate = table.get(j).getName();

                // i+1 자리에 candidate가 와도 i와 연속 중복이면 안 됨 (이미 candidate != duplicatedName이라 OK)
                // j 자리에 duplicatedName이 가도 j-1 / j+1과 연속 중복이면 안 됨
                if (j - 1 >= 0 && table.get(j - 1).getName().equals(duplicatedName)) {
                    continue;
                }
                if (j + 1 < n && table.get(j + 1).getName().equals(duplicatedName)) {
                    continue;
                }

                swapIdx = j;
                break;
            }

            if (swapIdx == -1) {
                throw new IllegalStateException("연속 근무를 피할 스왑 대상을 찾지 못했습니다. i=" + i);
            }

            // name swap
            String tmp = table.get(i + 1).getName();
            table.get(i + 1).setName(table.get(swapIdx).getName());
            table.get(swapIdx).setName(tmp);
        }
    }

    public List<EmergencyWorker> getTable() {
        return table;
    }

    public int getSize() {
        return table.size();
    }
}
