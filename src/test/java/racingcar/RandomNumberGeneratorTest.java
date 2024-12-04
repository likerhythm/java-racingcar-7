package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import racingcar.util.RandomNumberGenerator;

public class RandomNumberGeneratorTest {

    @RepeatedTest(100)
    void generateTest() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        Assertions.assertTrue(0 <= randomNumberGenerator.generate() && randomNumberGenerator.generate() <= 9);
    }
}
