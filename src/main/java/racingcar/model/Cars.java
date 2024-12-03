package racingcar.model;

import racingcar.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final NumberGenerator numberGenerator;
    private final List<Car> cars = new ArrayList<>();

    public Cars(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void move() {
        cars.forEach(car -> {
                    int num = numberGenerator.generate();
                    if (num >= 4) {
                        car.move();
                    }
                });
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
