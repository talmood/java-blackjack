package domain;

import domain.validator.BlackjackPlayerNameValidator;

import java.util.Objects;

public class BlackjackPlayerName {

    private final String name;

    public BlackjackPlayerName(String name) {
        BlackjackPlayerNameValidator.validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlackjackPlayerName that = (BlackjackPlayerName) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
