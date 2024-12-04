package racingcar.model;

public class GameCount {

    private final int count;

    public GameCount(int count) {
        validateCount(count);
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    private void validateCount(int count) {
        if (count < 0 || count > 100) {
            throw new IllegalArgumentException("시도 횟수는 최소 0, 최대 100의 값을 입력해야 합니다.");
        }
    }
}
