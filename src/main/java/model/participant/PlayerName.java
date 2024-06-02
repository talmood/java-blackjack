package model.participant;

import java.util.Objects;

public record PlayerName(
        String value
) {

    public PlayerName {
        if (Objects.isNull(value) || value.isBlank()) {
            throw new IllegalArgumentException("value must not be blank");
        }
    }

}
