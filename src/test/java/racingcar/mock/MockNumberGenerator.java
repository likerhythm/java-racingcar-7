package racingcar.mock;

import racingcar.util.NumberGenerator;

public class MockNumberGenerator implements NumberGenerator {

    @Override
    public int generate() {
        return 7;
    }
}
