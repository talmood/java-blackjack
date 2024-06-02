package view.dto;

import model.card.Card;
import model.card.CardHand;
import model.participant.Dealer;
import view.CardValueFormatter;

import java.util.List;
import java.util.stream.Collectors;

public record DealerDto(
        CardHand hand
) {

    public static DealerDto from(final Dealer dealer) {
        return new DealerDto(dealer.getHand());
    }

    public String formatCardHand() {
        final List<Card> cards = this.hand.getCards();
        return "딜러 카드: %s".formatted(CardValueFormatter.format(cards.get(0)));
    }

    public String formatScore() {
        final String cardValues = this.hand.getCards()
                .stream()
                .map(CardValueFormatter::format)
                .collect(Collectors.joining(", "));

        return "딜러 카드: %s - 결과: %d".formatted(cardValues, hand.calculateScore().value());
    }

}
