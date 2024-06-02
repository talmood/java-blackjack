package view;

import model.card.Card;
import model.card.CardHand;
import model.participant.Dealer;

import java.util.List;

public record DealerDto(
        CardHand hand
) {

    public static DealerDto from(final Dealer dealer) {
        return new DealerDto(dealer.getHand());
    }

    public String formatCardHand() {
        final List<Card> cards = this.hand.getCards();
        return "딜러: %s".formatted(CardValueFormatter.format(cards.get(0)));
    }

}
