package model.card;

import java.util.*;
import java.util.stream.Collectors;

public class CardPack {

    private final Deque<Card> cards;

    CardPack(Deque<Card> cards) {
        if (Objects.isNull(cards)) {
            throw new IllegalArgumentException("cards must not be null");
        }
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

        return new CardPack(new ArrayDeque<>(cards));
    }

    public Card drawOne() {
        if (this.cards.isEmpty()) {
            throw new IllegalStateException("No card exist to draw");
        }
        return this.cards.pollFirst();
    }

    public List<Card> getCards() {
        return List.copyOf(this.cards);
    }

}
