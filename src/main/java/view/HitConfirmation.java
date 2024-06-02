package view;

import java.util.Objects;

public record HitConfirmation(
        boolean wantToHit
) {

    public static HitConfirmation from(final String rawInput) {
        if (Objects.isNull(rawInput)) {
            throw new IllegalArgumentException("rawInput must not be null");
        }

        if (rawInput.equalsIgnoreCase("y")) {
            return new HitConfirmation(true);
        }

        if (rawInput.equalsIgnoreCase("n")) {
            return new HitConfirmation(false);
        }

        throw new IllegalArgumentException("rawInput must be 'y' or 'n'");
    }
}
