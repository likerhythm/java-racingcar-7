package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Car;

import java.util.stream.IntStream;

public class CarTest {

    @Test
    void positionTest() {
        Car car = new Car("", 0);
        IntStream.range(0, 4).forEach(i -> car.move());
        Assertions.assertEquals(4, car.getPosition());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "이름",
            "이름이름이",
            "12345",
            "1",
            "이 름",
    })
    void validNameTest(String name) {
        Assertions.assertDoesNotThrow(() -> new Car(name, 0));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            " 이름",
            "이름 ",
            "123456",
            " ",
            ""
    })
    void invalidNameTest(String name) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Car(name, 0));
    }
}
