package domain;

import java.util.List;

public enum TrumpCardRank {
    ACE(List.of(1, 11), "A"),
    TWO(List.of(2), "2"),
    THREE(List.of(3), "3"),
    FOUR(List.of(4), "4"),
    FIVE(List.of(5), "5"),
    SIX(List.of(6), "6"),
    SEVEN(List.of(7), "7"),
    EIGHT(List.of(8), "8"),
    NINE(List.of(9), "9"),
    TEN(List.of(10), "10"),
    KING(List.of(10), "K"),
    QUEEN(List.of(10), "Q"),
    JACK(List.of(10), "J");


    private final List<Integer> values;
    private final String expression;

    TrumpCardRank(List<Integer> values, String expression) {
        this.values = values;
        this.expression = expression;
    }

    public int fetchMaxValue() {
        return this.values.stream()
                .mapToInt(x -> x)
                .max()
                .orElse(0);
    }

    public int fetchMinValue() {
        return this.values.stream()
                .mapToInt(x -> x)
                .min()
                .orElse(0);
    }

    public String getExpression() {
        return expression;
    }
}
