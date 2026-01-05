package oncall;

import oncall.controller.EmergencyWorkerController;
import oncall.service.EmergencyWorkService;
import oncall.view.InputView;
import oncall.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        EmergencyWorkService emergencyWorkService = new EmergencyWorkService();

        EmergencyWorkerController emergencyWorkerController = new EmergencyWorkerController(inputView, outputView,
                emergencyWorkService);

        emergencyWorkerController.start();
    }
}
