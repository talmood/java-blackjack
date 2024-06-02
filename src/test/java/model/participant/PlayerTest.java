package model.participant;

import model.card.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    @DisplayName("버스트일 경우 플레이어는 카드를 더 이상 받을 수 없다.")
    @Test
    void receivable() {
        // given
        final List<Card> cards = List.of(
                new Card(CardSuit.CLUBS, CardValue.JACK),
                new Card(CardSuit.CLUBS, CardValue.TEN),
                new Card(CardSuit.HEARTS, CardValue.TEN)
        );

        final CardHand cardHand = new CardHand(cards);
        final CardRecipient sut = new Player(cardHand, new PlayerName("player"));

        // when
        final boolean actual = sut.receivable();

        // then
        assertThat(actual).isFalse();
    }

    @DisplayName("버스트 아닐 경우 플레이어는 카드를 더 받을 수 있다.")
    @Test
    void receivable_true() {
        // given
        final List<Card> cards = List.of(
                new Card(CardSuit.CLUBS, CardValue.JACK),
                new Card(CardSuit.CLUBS, CardValue.ACE),
                new Card(CardSuit.HEARTS, CardValue.TEN)
        );

        final CardHand cardHand = new CardHand(cards);
        final CardRecipient sut = new Player(cardHand, new PlayerName("player"));

        // when
        final boolean actual = sut.receivable();

        // then
        assertThat(actual).isTrue();
    }

}