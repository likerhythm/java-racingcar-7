package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {

    public int getGameCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputGameCount = readLine();
        try {
            return Integer.parseInt(inputGameCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 정수로 입력해주세요.");
        }
    }

    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = readLine();
        return List.of(carNames.split(","));
    }

    private String readLine() {
        return Console.readLine();
    }
}
