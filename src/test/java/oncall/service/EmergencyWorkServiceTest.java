package oncall.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import oncall.domain.EmergencyWorkers;
import org.junit.jupiter.api.Test;

import org.assertj.core.api.Assertions.*;

public class EmergencyWorkServiceTest {
    @Test
    void 비상근무표_정상_생성() {
        int monthNumber = 5;
        String startWeekText = "월";
        List<String> weekdaysNames = new ArrayList<>(
                List.of("준팍", "도밥", "고니", "수아", "루루", "글로", "솔로스타", "우코", "슬링키", "참새", "도리"));

        List<String> weekendNames = new ArrayList<>(
                List.of("수아", "루루", "글로", "솔로스타", "우코", "슬링키", "참새", "도리", "준팍", "도밥", "고니"));

        EmergencyWorkService emergencyWorkService = new EmergencyWorkService();

        EmergencyWorkers emergencyWorkers = emergencyWorkService.save(monthNumber, startWeekText, weekdaysNames,
                weekendNames);

        assertThat(emergencyWorkers).isEqualTo();
    }
}
