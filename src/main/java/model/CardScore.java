package model;

public record CardScore(
        int value
) {

    public boolean exceeds(final int score) {
        return this.value > score;
    }

    public boolean isEqualOrLessThan(final CardScore other) {
        return this.value <= other.value;
    }

    public boolean exceeds(final CardScore other) {
        return this.value > other.value;
    }

}
