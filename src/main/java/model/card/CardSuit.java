package model.card;

public enum CardSuit {

    CLUBS("클로버"),
    HEARTS("하트"),
    DIAMONDS("다이아몬드"),
    SPADES("스페이드");

    private final String description;

    CardSuit(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
