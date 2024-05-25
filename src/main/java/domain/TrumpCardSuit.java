package domain;

public enum TrumpCardSuit {

    HEARTS("하트"),
    DIAMONDS("다이아몬드"),
    CLUBS("클로버"),
    SPADES("스페이드");

    private final String koreanName;

    TrumpCardSuit(String koreanName) {
        this.koreanName = koreanName;
    }
}
