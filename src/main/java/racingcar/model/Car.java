package racingcar.model;

public class Car {

    private final String name;
    private int position;

    public Car(String name, int position) {
        validateName(name);
        this.name = name;
        this.position = position;
    }

    public void move() {
        position += 1;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validateName(String name) {
        validateNameLength(name);
        validateNameStartOrEndWithBlank(name);
        validateNameBlank(name);
    }

    private static void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하의 문자열만 허용됩니다.");
        }
    }

    private static void validateNameStartOrEndWithBlank(String name) {
        if (name.startsWith(" ") || name.endsWith(" ")) {
            throw new IllegalArgumentException("자동차 이름은 공백으로 시작하거나 끝날 수 없습니다.");
        }
    }

    private static void validateNameBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 빈 문자열일 수 없습니다.");
        }
    }
}
