package card;

import java.util.ArrayList;
import java.util.List;

public class CardDeck {
	private static final List<CardSuit> CARD_EMBLEMS = List.of(CardSuit.CLOVER, CardSuit.HEART, CardSuit.SPADE, CardSuit.DIAMOND);
	private static final List<CardRank> CARD_NUMBER = List.of(CardRank.ACE, CardRank.TWO, CardRank.THREE, CardRank.FOUR, CardRank.FIVE, CardRank.SIX, CardRank.SEVEN, CardRank.EIGHT, CardRank.NINE, CardRank.JACK, CardRank.QUEEN, CardRank.KING);

	private final List<Card> cards = new ArrayList<>();

	public CardDeck() {
		for (CardSuit emblem : CARD_EMBLEMS) {
			cards.addAll(CARD_NUMBER.stream()
				.map(cardRank -> new Card(emblem, cardRank))
				.toList());
		}
	}

	public List<Card> getCards() {
		return List.copyOf(cards);
	}
}
