package model.participant;

import model.card.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DealerTest {

    @DisplayName("딜러는 총점이 17점이 이상일 경우 카드를 더 이상 받을 수 없다.")
    @Test
    void receivable() {
        // given
        final List<Card> cards = List.of(
                new Card(CardSuit.CLUBS, CardValue.TEN),
                new Card(CardSuit.HEARTS, CardValue.SEVEN)
        );

        final CardHand cardHand = new CardHand(cards);
        final CardRecipient sut = new Dealer(cardHand, CardDispenser.defaultOf());

        // when
        final boolean actual = sut.receivable();

        // then
        assertThat(actual).isFalse();
    }

    @DisplayName("딜러는 총점이 17점 미만일 경우 카드를 더 받을 수 있다.")
    @Test
    void receivable_true() {
        // given
        final List<Card> cards = List.of(
                new Card(CardSuit.CLUBS, CardValue.ACE),
                new Card(CardSuit.HEARTS, CardValue.FIVE)
        );

        final CardHand cardHand = new CardHand(cards);
        final CardRecipient sut = new Dealer(cardHand, CardDispenser.defaultOf());

        // when
        final boolean actual = sut.receivable();

        // then
        assertThat(actual).isTrue();
    }

}