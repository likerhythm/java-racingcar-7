package racingcar;

import racingcar.model.Cars;
import racingcar.model.GameCount;
import racingcar.model.Winners;
import racingcar.util.NumberGenerator;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.IntStream;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        List<String> carNames = inputView.getCarNames();
        int intGameCount = inputView.getGameCount();

        playGame(intGameCount, carNames);
    }

    private void playGame(int intGameCount, List<String> carNames) {
        GameCount gameCount = new GameCount(intGameCount);
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        Cars cars = Cars.of(numberGenerator, carNames);
        displayCarStatus(gameCount, cars);

        Winners winners = cars.getWinners();
        outputView.displayWinner(winners.winnerNames());
    }

    private void displayCarStatus(GameCount gameCount, Cars cars) {
        IntStream.range(0, gameCount.getCount())
                .forEach(i -> {
                    cars.move();
                    CarStatusDto carStatusDto = cars.getCarStatus();
                    outputView.displayCarStatus(carStatusDto);
                });
    }
}
