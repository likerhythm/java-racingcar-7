package racingcar.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.util.NumberGenerator;
import racingcar.mock.MockNumberGenerator;

import java.util.List;

public class CarsTest {

    @Test
    void moveCarTest() {
        NumberGenerator mockNumberGenerator = new MockNumberGenerator();
        Cars cars = Cars.of(mockNumberGenerator, List.of("car1", "car2", "car3", "car4"));
        cars.move();
        Winners winners = cars.getWinners();
        Assertions.assertEquals(List.of("car1", "car2", "car3", "car4"), winners.winnerNames());
    }
}
