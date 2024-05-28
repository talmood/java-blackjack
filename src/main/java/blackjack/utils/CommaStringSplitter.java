package blackjack.utils;

import java.util.Arrays;
import java.util.List;

public class CommaStringSplitter {
    private static final String DELIMITER = ",";

    private CommaStringSplitter() {
    }

    public static List<String> split(final String str) {
        if (StringUtil.isBlank(str)) {
            throw new IllegalArgumentException("split string must not be blank");
        }

        return Arrays.stream(str.split(DELIMITER))
                .map(String::trim)
                .toList();
    }
}
