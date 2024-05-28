package blackjack.domain.card;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @DisplayName("덱을 생성한다.")
    @Test
    void create() {
        final Deck deck = Deck.create();
        System.out.println(deck);
        assertEquals(52, deck.getCards().size());
    }

    @DisplayName("초기 카드 2장을 뽑고, 덱에서 제거")
    @Test
    void drawInitialCards() {
        final Deck deck = Deck.create();
        assertEquals(2, deck.drawInitialCards().size());
    }

    @DisplayName("카드를 뽑고, 덱에서 제거")
    @Test
    void draw() {
        final Deck deck = Deck.create();
        final Card card = deck.draw();
        assertEquals(Suit.CLOVER, card.getSuit());
        assertEquals(Rank.KING, card.getRank());
        assertEquals(51, deck.getCards().size());
    }
}