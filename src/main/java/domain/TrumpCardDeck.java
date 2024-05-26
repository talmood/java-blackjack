package domain;

public class TrumpCardDeck {

    private final TrumpCards trumpCards;

    public TrumpCardDeck() {
        this.trumpCards = TrumpCards.createAll().shuffle();
    }

    public TrumpCardDeck(TrumpCards trumpCards) {
        this.trumpCards = trumpCards;
    }

    public TrumpCard fetchTopOne() {
        return this.trumpCards.fetchTopOne();
    }

    public TrumpCardDeck takeOutTopOne() {
        return new TrumpCardDeck(
                this.trumpCards.takeOutTopOne()
        );
    }
}
