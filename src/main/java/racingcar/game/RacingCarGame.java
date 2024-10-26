package racingcar.game;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.car.Car;
import racingcar.car.CarManager;
import racingcar.view.input.InputValue;

import java.util.List;


public class RacingCarGame {

    private final int attemptCount;
    private final CarManager carManager = new CarManager();
    private final CarPositionLogRepository carPositionLogRepository = new CarPositionLogRepository();

    public RacingCarGame(InputValue inputValue) {
        List<String> carNames = inputValue.getCarNames();
        int attemptCount = inputValue.getAttemptCount();

        carManager.createCars(carNames);
        this.attemptCount = attemptCount;
    }

    public GameResult getGameResult() {
        return new GameResult(attemptCount, carPositionLogRepository.getCarPositionLog());
    }

    public void play() {
        moveCars();
    }

    private void moveCars() {
        for (int i = 0; i < attemptCount; i++) {
            List<Car> cars = carManager.getCars();
            cars.forEach(car -> {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                if (randomNumber >= 4) {
                    car.move();
                }
                carPositionLogRepository.saveCarPositionLog(car);
            });
        }
    }
}