package util;

import java.util.Objects;

public abstract class StringUtils {

    private static final String EMPTY_STRING = "";

    public static boolean isEmpty(String str) {
        return Objects.isNull(str) || str.isEmpty();
    }

    public static String removeWhiteSpace(String str) {
        if (Objects.isNull(str)) {
            return EMPTY_STRING;
        }

        return str.replace(" ", "");
    }
}
