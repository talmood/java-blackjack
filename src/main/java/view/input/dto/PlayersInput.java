package view.input.dto;

import domain.BlackjackPlayerName;
import util.CollectionUtils;
import util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlayersInput {

    private final List<String> playerNames;

    private PlayersInput(List<String> playerNames) {
        this.validateIsEmpty(playerNames);
        this.playerNames = playerNames;
    }

    public static PlayersInput from(String input) {
        return new PlayersInput(Arrays.stream(StringUtils.trim(input).split(",")).collect(Collectors.toList()));
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
