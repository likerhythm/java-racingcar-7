package racingcar.view;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class InputParserTest {

    InputParser inputParser = new InputParser();

    @Test
    void parseCarNameTest() {
        String carNames = "name1,name2,name3";
        Assertions.assertEquals(List.of("name1", "name2", "name3"), inputParser.parseCarNames(carNames));
    }
}
