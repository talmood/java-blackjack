package domain.validator;

import util.StringUtils;

public abstract class BlackjackPlayerNameValidator {

    public static void validate(String name) {
        validateNotEmpty(name);
    }

    private static void validateNotEmpty(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("블랙잭 참여자의 이름은 null이거나 공백이면 안됩니다.");
        }
    }
}
