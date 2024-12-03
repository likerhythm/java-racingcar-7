package racingcar.model;

import java.util.List;

public class Winners {

    private final List<String> winners;

    public Winners(List<String> winners) {
        this.winners = winners;
    }

    public int count() {
        return winners.size();
    }
}
