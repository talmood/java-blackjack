package domain.validator;

import util.CollectionUtils;

import java.util.Collection;

public abstract class CollectionValidator {

    private static final String NOT_EMPTY_MESSAGE = "%s collection은 null이거나 empty이면 안됩니다.";

    public static void validateNotEmpty(Collection<?> collection) {
        String className = collection.getClass().getName();

        if (CollectionUtils.isEmpty(collection)) {
            throw new IllegalArgumentException(String.format(NOT_EMPTY_MESSAGE, className));
        }
    }
}
