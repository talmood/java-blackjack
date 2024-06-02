package domain.validator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import util.ObjectUtils;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ObjectsValidatorTest {

    static Stream<Arguments> nullValuesParameter() {
        return Stream.of(
                Arguments.of(new Object[]{null}, true),
                Arguments.of(new Object[]{1, 2, 3, null}, true),
                Arguments.of(new Object[]{1, 2, 3}, false),
                Arguments.of(new Object[]{}, false),
                Arguments.of(null, true)
        );
    }

    @ParameterizedTest
    @MethodSource("nullValuesParameter")
    void hasNull(Object[] input, boolean expected) {
        boolean result = ObjectUtils.hasNull(input);
        if (expected) {
            assertTrue(result);
        } else {
            assertFalse(result);
        }
    }
}