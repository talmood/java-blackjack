package model.card;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

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

}