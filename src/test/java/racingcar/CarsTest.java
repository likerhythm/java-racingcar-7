package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Winners;

public class CarsTest {

    @Test
    void moveCarTest() {
        NumberGenerator mockNumberGenerator = new RandomNumberGeneratorTest.MockNumberGenerator();
        Cars cars = new Cars(mockNumberGenerator);
        cars.addCar(new Car("car1", 0));
        cars.addCar(new Car("car2", 0));
        cars.addCar(new Car("car3", 0));
        cars.addCar(new Car("car4", 0));
        cars.move();
        Winners winners = cars.getWinners();
        Assertions.assertEquals(4, winners.count());
    }
}
