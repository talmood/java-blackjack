package domain;

import util.StringUtils;

import java.util.Objects;

public class BlackjackPlayerName {

    private final String name;

    public BlackjackPlayerName(String name) {
        this.validateNotEmpty(name);
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

    private void validateNotEmpty(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("블랙잭 참여자의 이름은 null이거나 공백이면 안됩니다.");
        }
    }
}
