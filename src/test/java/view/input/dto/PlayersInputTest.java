package view.input.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class PlayersInputTest {

    static Stream<Arguments> userInputParameter() {
        return Stream.of(
                Arguments.arguments("pobi//jason"),
                Arguments.arguments("pobi-jason"),
                Arguments.arguments("pobi;jason")
        );
    }

    @ParameterizedTest
    @MethodSource("userInputParameter")
    @DisplayName("사용자 입력이 pobi,jason같은 형태가 아니면 IllegalArgumentException이 발생한다.")
    void test_validate_user_input_pattern(String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> PlayersInput.from(input));
    }
}