package blackjack.domain.card;

import java.util.Arrays;

public enum Suit {
    SPADE("스페이드"),
    HEART("하트"),
    DIAMOND("다이아몬드"),
    COLVER("클로버");

    private final String name;

    Suit(final String name) {
        this.name = name;
    }

    public static Suit of(final String name) {
        return Arrays.stream(Suit.values())
                .filter(suit -> suit.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 카드 모양입니다."));
    }

    public String getName() {
        return name;
    }
}
