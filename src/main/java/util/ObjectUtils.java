package util;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class ObjectUtils {

    public static boolean hasNull(Object... args) {
        return Objects.isNull(args) ||
                (!CollectionUtils.isEmpty(toList(args)) && toList(args).stream().anyMatch(Objects::isNull));
    }

    private static List<Object> toList(Object... args) {
        return Arrays.stream(args).toList();
    }
}
