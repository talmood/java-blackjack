package view.input.dto;

import domain.BlackjackPlayerName;
import util.CollectionUtils;
import util.PatternUtils;
import util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlayersInput {

    private static final String USER_INPUT_PATTERN = "^[a-zA-Z]+(\\s*,\\s*[a-zA-Z]+)*$";

    private final List<String> playerNames;

    private PlayersInput(List<String> playerNames) {
        this.validateIsEmpty(playerNames);
        this.playerNames = playerNames;
    }

    public static PlayersInput from(String input) {
        validateMatchesPattern(input);
        return new PlayersInput(Arrays.stream(StringUtils.removeWhiteSpace(input).split(",")).collect(Collectors.toList()));
    }

    private static void validateMatchesPattern(String input) {
        if (!PatternUtils.matches(USER_INPUT_PATTERN, input)) {
            throw new IllegalArgumentException("사용자 입력이 올바르지 않습니다.");
        }
    }

    public List<String> getPlayerNames() {
        return playerNames;
    }

    private void validateIsEmpty(List<String> playerNames) {
        if (CollectionUtils.isEmpty(playerNames)) {
            throw new IllegalArgumentException("최소 1명의 플레이어가 있어야 합니다.");
        }
    }

    public List<BlackjackPlayerName> toBlackjackPlayerNames() {
        return this.playerNames.stream()
                .map(BlackjackPlayerName::new)
                .collect(Collectors.toList());
    }
}
