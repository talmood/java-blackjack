package model;

public record CardScore(
        int value
) {

    public boolean exceeds(final int score) {
        return this.value > score;
    }
}
