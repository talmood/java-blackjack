package domain;

import java.util.Objects;

public class TrumpCardDeck {

    private final TrumpCards trumpCards;

    public TrumpCardDeck() {
        this.trumpCards = TrumpCards.createAll().shuffle();
    }

    public TrumpCardDeck(TrumpCards trumpCards) {
        this.validateNotNull(trumpCards);
        this.trumpCards = trumpCards;
    }

    public TrumpCardDeck(TrumpCardDeck trumpCardDeck) {
        this.validateNotNull(trumpCardDeck);
        this.trumpCards = trumpCardDeck.trumpCards;
    }

    public TrumpCard fetchTopOne() {
        return this.trumpCards.fetchTopOne();
    }

    public TrumpCardDeck takeOutTopOne() {
        return new TrumpCardDeck(
                this.trumpCards.takeOutTopOne()
        );
    }

    private void validateNotNull(TrumpCards trumpCards) {
        if (Objects.isNull(trumpCards)) {
            throw new IllegalArgumentException("트럼프 카드들은 null이면 안됩니다.");
        }
    }

    private void validateNotNull(TrumpCardDeck trumpCardDeck) {
        if (Objects.isNull(trumpCardDeck)) {
            throw new IllegalArgumentException("트럼프 덱은 null이면 안됩니다.");
        }
    }
}
