package racingcar.view;

import java.util.List;

public class InputParser {

    public List<String> parseCarNames(String carNames) {
        return List.of(carNames.split(","));
    }
}
