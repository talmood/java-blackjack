package blackjack.domain.participant;

import java.util.Objects;

public class Name {
    private final String name;

    private Name(final String name) {
        validate(name);
        this.name = name;
    }

    public static Name of(final String name) {
        return new Name(name);
    }

    private static void validate(final String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("이름은 null 이거나 빈 문자열일 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Name name1)) return false;
        return Objects.equals(getName(), name1.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
