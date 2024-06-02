package model.card;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CardPack {

    private static final int CARD_SIZE = 52;

    private final List<Card> cards;

    private CardPack(List<Card> cards) {
        if (Objects.isNull(cards)) {
            throw new IllegalArgumentException("cards must not be null");
        }
        verifyCardSize(cards);
        this.cards = cards;
    }

    public static CardPack defaultOf() {
        final List<Card> cards = Arrays.stream(CardSuit.values())
                .map(suit -> Arrays.stream(CardValue.values())
                        .map(value -> new Card(suit, value))
                        .toList())
                .flatMap(List::stream)
                .collect(Collectors.toList());

        Collections.shuffle(cards);

        return new CardPack(cards);
    }

    private void verifyCardSize(final List<Card> cards) {
        if (cards.size() != CARD_SIZE) {
            throw new IllegalArgumentException("Card size of CardPack must be %d".formatted(CARD_SIZE));
        }
    }

    public List<Card> getCards() {
        return List.copyOf(this.cards);
    }

}
