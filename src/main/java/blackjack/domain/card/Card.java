package blackjack.domain.card;

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
}
