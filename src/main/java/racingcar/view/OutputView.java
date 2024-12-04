package racingcar.view;

import racingcar.CarStatusDto;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String CAR_STATUS = "%s : %s";
    private static final String POSITION_EXPRESSION = "-";
    private static final String WINNERS = "최종 우승자 : %s";

    public void displayCarStatus(CarStatusDto carStatusDto) {
        Map<String, Integer> stringIntegerMap = carStatusDto.carStatus();
        stringIntegerMap.forEach((key, value) -> {
            int position = value;
            System.out.println(String.format(CAR_STATUS, key, POSITION_EXPRESSION.repeat(position)));
        });
        displayNewLine();
    }

    public void displayWinner(List<String> winnerNames) {
        System.out.println(String.format(WINNERS, String.join(",", winnerNames)));
    }

    private void displayNewLine() {
        System.out.println();
    }
}
