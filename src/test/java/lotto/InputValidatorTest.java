package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.util.InputValidator;

import static org.assertj.core.api.Assertions.*;

class InputValidatorTest {

    private final InputValidator validator = new InputValidator();

    @DisplayName("문자 입력 시 예외 발생")
    @Test
    void shouldThrowWhenInputIsNotNumber() {
        assertThatThrownBy(() -> validator.parseInteger("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원 미만 입력 시 예외 발생")
    @Test
    void shouldThrowWhenMoneyBelow1000() {
        assertThatThrownBy(() -> validator.validateMoney(500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원 단위가 아니면 예외 발생")
    @Test
    void shouldThrowWhenMoneyNotDivisibleBy1000() {
        assertThatThrownBy(() -> validator.validateMoney(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상 입력 시 예외 발생하지 않음")
    @Test
    void shouldPassForValidMoney() {
        assertThatCode(() -> validator.validateMoney(3000))
                .doesNotThrowAnyException();
    }
}
