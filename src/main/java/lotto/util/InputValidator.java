package lotto.util;

public class InputValidator {

    public int parseInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
    }

    public void validateMoney(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 이상이어야 합니다.");
        }
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 나누어 떨어져야 합니다.");
        }
    }
}
