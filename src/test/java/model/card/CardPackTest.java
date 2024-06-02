package model.card;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class CardPackTest {

    @DisplayName("카드팩의 카드는 문양별로 13장씩 총 52장이다.")
    @Test
    void defaultOf() {
        // when
        final CardPack actual = CardPack.defaultOf();

        // then
        assertThat(actual.getCards()).hasSize(52);

        final Map<CardSuit, Long> cardCountBySuit = actual.getCards().stream()
                .collect(Collectors.groupingBy(Card::suit, Collectors.counting()));

        assertThat(cardCountBySuit).hasSize(CardSuit.values().length)
                .allSatisfy((suit, count) -> assertThat(count).isEqualTo(13L));
    }

    @Test
    void drawOne() {
        // given
        final List<Card> cards = List.of(
                new Card(CardSuit.CLUBS, CardValue.JACK),
                new Card(CardSuit.CLUBS, CardValue.TEN),
                new Card(CardSuit.HEARTS, CardValue.TEN)
        );
        final CardPack sut = new CardPack(new ArrayDeque<>(cards));

        // when
        final Card card = sut.drawOne();

        // then
        assertAll(
                () -> assertThat(sut.getCards()).hasSize(2),
                () -> assertThat(card).isEqualTo(new Card(CardSuit.CLUBS, CardValue.JACK))
        );
    }

}