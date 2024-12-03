package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

public class RandomNumberGeneratorTest {

    @RepeatedTest(100)
    void generateTest() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        Assertions.assertTrue(0 <= randomNumberGenerator.generate() && randomNumberGenerator.generate() <= 9);
    }

    public static class MockNumberGenerator implements NumberGenerator {

        @Override
        public int generate() {
            return 7;
        }
    }
}
