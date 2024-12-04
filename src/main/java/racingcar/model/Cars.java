package racingcar.model;

import racingcar.CarStatusDto;
import racingcar.util.NumberGenerator;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cars {

    private final NumberGenerator numberGenerator;
    private final List<Car> cars;

    private Cars(NumberGenerator numberGenerator, List<Car> cars) {
        this.numberGenerator = numberGenerator;
        this.cars = cars;
    }

    public static Cars of(NumberGenerator numberGenerator, List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(name -> new Car(name, 0))
                .toList();
        return new Cars(numberGenerator, cars);
    }

    public void move() {
        cars.forEach(car -> {
                    int num = numberGenerator.generate();
                    if (num >= 4) {
                        car.move();
                    }
                });
    }

    public CarStatusDto getCarStatus() {
        Map<String, Integer> carStatus = cars.stream()
                .collect(Collectors.toMap(
                        Car::getName,
                        Car::getPosition,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));
        return new CarStatusDto(carStatus);
    }

    public Winners getWinners() {
        int maxPosition = calculateMaxPosition();
        List<String> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
        return new Winners(winners);
    }

    private int calculateMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(IllegalAccessError::new);
    }
}
