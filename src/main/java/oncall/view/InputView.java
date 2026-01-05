package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import oncall.util.ErrorMessage;
import oncall.util.InputUtil;
import oncall.util.Parser;
import oncall.util.Validator;

public final class InputView {
    public List<String> readMonthAndWeek() {
        return InputUtil.retry(() -> Parser.splitAndTrim(Console.readLine(), ","));

    }

    public List<String> readEmergencyWorkers() {
        return InputUtil.retry(() -> Parser.splitAndTrim(Console.readLine(), ","));
    }
}