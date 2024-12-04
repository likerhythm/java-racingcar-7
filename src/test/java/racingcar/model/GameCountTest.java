package racingcar.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GameCountTest {

    @ParameterizedTest
    @ValueSource(ints = {
            -1,
            101,
    })
    void invalidGameCountTest(int count) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new GameCount(count));
    }
}
