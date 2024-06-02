package blackjack.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class InputViewTest {

    private final InputView inputView = new InputView();
    private InputStream originalIn;

    @BeforeEach
    void setUp() {
        // 현재 입력 스트림을 originalIn에 보관한다.
        originalIn = System.in;
    }

    @AfterEach
    void tearDown() {
        // 테스트가 끝나면 System.in을 원래의 originalIn으로 복구한다.
        System.setIn(originalIn);
    }

    @DisplayName("게임에 참여할 사람의 이름을 입력받는다.")
    @Test
    void inputPlayerNames() {
        // Given
        String input = "은정, 금정";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // When
        List<String> names = inputView.inputPlayerNames();

        // Then
        assertEquals(2, names.size());
        assertEquals("은정", names.get(0));
        assertEquals("금정", names.get(1));
    }

    @Test
    void inputMoreCard_yes() {
        // Given
        String input = "y";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // When
        boolean result = inputView.printOrDrawOrStop("은정");

        // Then
        assertTrue(result);
    }

    @Test
    void inputMoreCard_no() {

        // Given
        String input = "n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // When
        boolean result = inputView.printOrDrawOrStop("은정");

        // Then
        assertFalse(result);
    }

    @Test
    void inputMoreCard_invalidInput() {
        String input = "invalid";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            inputView.printOrDrawOrStop("은정");
        });

        assertEquals("y 또는 n 중 하나를 입력해주세요.", exception.getMessage());
    }
}
