package card;

import java.util.ArrayList;
import java.util.List;

public class CardDeck {
	private static final List<CardEmblem> CARD_EMBLEMS = List.of(CardEmblem.CLOVER, CardEmblem.HEART, CardEmblem.SPADE, CardEmblem.DIAMOND);
	private static final List<CardNumber> CARD_NUMBER = List.of(CardNumber.ACE, CardNumber.TWO, CardNumber.THREE, CardNumber.FOUR, CardNumber.FIVE, CardNumber.SIX, CardNumber.SEVEN, CardNumber.EIGHT, CardNumber.NINE, CardNumber.JACK, CardNumber.QUEEN, CardNumber.KING);

	private final List<Card> cards = new ArrayList<>();

	public CardDeck() {
		for (CardEmblem emblem : CARD_EMBLEMS) {
			cards.addAll(CARD_NUMBER.stream()
				.map(cardNumber -> Card.of(emblem, cardNumber))
				.toList());
		}
	}

	public List<Card> getCards() {
		return List.copyOf(cards);
	}
}
