package model.participant;

import java.util.Objects;

public record PlayerName(
        String name
) {

    public PlayerName {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new IllegalArgumentException("name must not be blank");
        }
    }

}
