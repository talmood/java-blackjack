package blackjack.domain.card;

import java.util.Objects;

public class Card {
    private final Suit suit;
    private final Rank rank;

    private Card(final Suit suit, final Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public static Card of(final String suit, final String rank) {
        return new Card(Suit.of(suit), Rank.of(rank));
    }

    public static Card of(final Suit suit, final Rank rank) {
        return new Card(suit, rank);
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card card)) return false;
        return suit == card.suit && rank == card.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, rank);
    }
}
