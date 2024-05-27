package blackjack.utils;

import java.util.Objects;

public abstract class StringUtil {

    private StringUtil() {
    }

    public static boolean isBlank(final String str) {
        return Objects.isNull(str) || str.trim().isEmpty();
    }
}
