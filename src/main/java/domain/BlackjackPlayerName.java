package domain;

import domain.validator.BlackjackPlayerNameValidator;

public class BlackjackPlayerName {

    private final String name;

    public BlackjackPlayerName(String name) {
        BlackjackPlayerNameValidator.validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
