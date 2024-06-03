package blackjack.domain.card;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardDeckTest {

    @DisplayName("덱을 생성한다.")
    @Test
    void create() {
        final CardDeck cardDeck = CardDeck.create();
        System.out.println(cardDeck);
        assertEquals(52, cardDeck.getCards().size());
    }

    @DisplayName("초기 카드 2장을 뽑고, 덱에서 제거")
    @Test
    void drawInitialCards() {
        final CardDeck cardDeck = CardDeck.create();
        assertEquals(2, cardDeck.drawInitialCards().size());
    }

    @DisplayName("카드를 뽑고, 덱에서 제거")
    @Test
    void draw() {
        final CardDeck cardDeck = CardDeck.create();
        final Card card = cardDeck.draw();
        assertEquals(Suit.CLOVER, card.getSuit());
        assertEquals(Rank.KING, card.getRank());
        assertEquals(51, cardDeck.getCards().size());
    }
}