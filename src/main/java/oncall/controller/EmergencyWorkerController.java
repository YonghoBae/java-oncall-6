package oncall.controller;

import java.util.List;
import oncall.domain.EmergencyWorkers;
import oncall.service.EmergencyWorkService;
import oncall.view.InputView;
import oncall.view.OutputView;

public class EmergencyWorkerController {
    private final InputView inputView;
    private final OutputView outputView;
    private final EmergencyWorkService emergencyWorkService;

    public EmergencyWorkerController(InputView inputView, OutputView outputView,
                                     EmergencyWorkService emergencyWorkService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.emergencyWorkService = emergencyWorkService;
    }

    public void start() {
        List<String> monthAndWeek = inputView.readMonthAndWeek();
        List<String> weekdaysWorkerList = inputView.readEmergencyWorkers();
        List<String> weekendWorkerList = inputView.readEmergencyWorkers();

        EmergencyWorkers emergencyWorkers = emergencyWorkService.save(Integer.parseInt(monthAndWeek.getFirst()),
                monthAndWeek.getLast(), weekdaysWorkerList,
                weekendWorkerList);

        outputView.printEmergencyWorkersTable(emergencyWorkers);
    }
}
