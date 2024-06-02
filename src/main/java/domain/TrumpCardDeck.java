package domain;

import domain.validator.ObjectsValidator;

public class TrumpCardDeck {

    private final TrumpCards trumpCards;

    public TrumpCardDeck() {
        this.trumpCards = TrumpCards.createAll().shuffle();
    }

    public TrumpCardDeck(TrumpCards trumpCards) {
        ObjectsValidator.validateNotNull(trumpCards);
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

    public int size() {
        return this.trumpCards.size();
    }
}
