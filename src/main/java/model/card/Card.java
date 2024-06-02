package model.card;

public record Card(
        CardSuit suit,
        CardValue value
) {

    public int getScore() {
        return this.value.getScore();
    }

    public boolean isAce() {
        return this.value.isAce();
    }

}
