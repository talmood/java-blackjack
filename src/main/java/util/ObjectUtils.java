package util;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public abstract class ObjectUtils {

    public static boolean hasNull(Object... args) {
        List<Object> argsList = Stream.of(args).toList();

        return !CollectionUtils.isEmpty(argsList) && argsList.stream().anyMatch(Objects::isNull);
    }
}
