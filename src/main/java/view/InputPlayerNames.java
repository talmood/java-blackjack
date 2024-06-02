package view;

import model.participant.PlayerName;

import java.util.Arrays;
import java.util.List;

public class InputPlayerNames {

    private final List<String> names;

    private InputPlayerNames(List<String> names) {
        this.names = names;
    }

    public static InputPlayerNames from(String rawInput) {
        final List<String> nameSeparated = Arrays.stream(rawInput.split(",")).toList();
        return new InputPlayerNames(nameSeparated);
    }

    public List<PlayerName> toPlayerNames() {
        return this.names.stream()
                .map(PlayerName::new)
                .toList();
    }

}
