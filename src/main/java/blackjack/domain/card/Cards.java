package blackjack.domain.card;

import java.util.ArrayList;
import java.util.List;

public class Cards {
    private static final int INITIAL_CARDS_SIZE = 2;
    private final List<Card> cards;

    public Cards() {
        this.cards = new ArrayList<>();
    }
    
    public void receiveInitialCards(final List<Card> cards) {
        validateInitialCards(cards);
        this.cards.addAll(cards);
    }

    private void validateInitialCards(final List<Card> cards) {
        if (cards.size() != INITIAL_CARDS_SIZE) {
            throw new IllegalArgumentException("초기 카드는 %d장 이어야 합니다.".formatted(INITIAL_CARDS_SIZE));
        }
    }
}
