import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {
    public List<String> validatePlayerNames(String playerNamesString) {

        if (playerNamesString.isBlank()) {
            throw new IllegalArgumentException("게임에 참여할 사람의 이름을 입력해주세요");
        }

        if (playerNamesString.contains(",")) {
            return Arrays.stream(playerNamesString.split(","))
                    .collect(Collectors.toList());
        }
        return List.of(playerNamesString);
    }

    public boolean validateAnswerForOneMoreCard(String acceptInput) {
        if (acceptInput.equals("y")) {
            return true;
        }
        if (acceptInput.equals("n")) {
            return false;
        }
        throw new IllegalArgumentException("y나 n으로 입력하세요");
    }
}
