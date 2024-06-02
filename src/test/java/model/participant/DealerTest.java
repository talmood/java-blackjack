package model.participant;

import model.GameResult;
import model.card.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

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

    @DisplayName("""
            버스트가 아닐 경우 점수가 플레이어 보다 높을 경우 승리이고, 
            점수가 낮을 경우는 패배, 
            점수 같을 경우 무승부""")
    @Test
    void calculateResult() {
        // given
        final List<Card> player1Cards = List.of(
                new Card(CardSuit.CLUBS, CardValue.TEN),
                new Card(CardSuit.HEARTS, CardValue.SIX)
        );
        final Player player1 = new Player(new CardHand(player1Cards), new PlayerName("player1"));

        final List<Card> player2Cards = List.of(
                new Card(CardSuit.CLUBS, CardValue.TEN),
                new Card(CardSuit.HEARTS, CardValue.FOUR)
        );
        final Player player2 = new Player(new CardHand(player2Cards), new PlayerName("player2"));

        final List<Card> player3Cards = List.of(
                new Card(CardSuit.CLUBS, CardValue.TEN),
                new Card(CardSuit.HEARTS, CardValue.FIVE)
        );
        final Player player3 = new Player(new CardHand(player3Cards), new PlayerName("player3"));

        final List<Card> dealerCards = List.of(
                new Card(CardSuit.CLUBS, CardValue.TEN),
                new Card(CardSuit.HEARTS, CardValue.FIVE)
        );
        final Dealer sut = new Dealer(new CardHand(dealerCards), CardDispenser.defaultOf());

        // when
        final GameResult actual = sut.calculateResult(List.of(player1, player2, player3));

        // then
        assertAll(
                () -> assertThat(actual.wonCount()).isEqualTo(1),
                () -> assertThat(actual.tieCount()).isEqualTo(1),
                () -> assertThat(actual.loseCount()).isEqualTo(1)
        );
    }

}