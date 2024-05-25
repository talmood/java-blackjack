package util;

import java.util.Collection;
import java.util.Objects;

public abstract class CollectionUtils {

    public static boolean isEmpty(Collection<?> collection) {
        return Objects.isNull(collection) || collection.isEmpty();
    }
}
