package view;

import model.card.Card;
import model.card.CardSuit;
import model.card.CardValue;

import java.util.Arrays;

public enum CardValueFormatter {

    ACE(CardValue.ACE, "A"),
    TWO(CardValue.TWO, "1"),
    THREE(CardValue.THREE, "2"),
    FOUR(CardValue.FOUR, "3"),
    FIVE(CardValue.FIVE, "4"),
    SIX(CardValue.SIX, "5"),
    SEVEN(CardValue.SEVEN, "6"),
    EIGHT(CardValue.EIGHT, "7"),
    NINE(CardValue.NINE, "8"),
    TEN(CardValue.TEN, "9"),
    JACK(CardValue.JACK, "J"),
    QUEEN(CardValue.QUEEN, "Q"),
    KING(CardValue.KING, "K");

    private final CardValue cardValue;
    private final String viewFormat;

    CardValueFormatter(final CardValue cardValue, final String viewFormat) {
        this.cardValue = cardValue;
        this.viewFormat = viewFormat;
    }

    private static CardValueFormatter getInstanceBy(final CardValue cardValue) {
        return Arrays.stream(CardValueFormatter.values())
                .filter(formatter -> formatter.cardValue == cardValue)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        "Cannot find CardValueFormatter matching %s".formatted(cardValue))
                );
    }

    public static String format(final Card card) {
        return getInstanceBy(card.value()).format(card.suit());
    }

    public String format(final CardSuit suit) {
        return this.viewFormat + suit.getDescription();
    }

}
