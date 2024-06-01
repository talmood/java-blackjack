package card.model;

import java.util.*;

public class CardDeck {
	private static final List<CardSuit> CARD_EMBLEMS = List.of(CardSuit.CLOVER, CardSuit.HEART, CardSuit.SPADE, CardSuit.DIAMOND);
	private static final List<CardRank> CARD_NUMBER = List.of(CardRank.ACE, CardRank.TWO, CardRank.THREE, CardRank.FOUR, CardRank.FIVE, CardRank.SIX, CardRank.SEVEN, CardRank.EIGHT, CardRank.NINE, CardRank.JACK, CardRank.QUEEN, CardRank.KING);

	private final Deque<Card> cards;

	public CardDeck() {
		List<Card> cardList = new ArrayList<>();
		for (CardSuit emblem : CARD_EMBLEMS) {
			cardList.addAll(CARD_NUMBER.stream()
				.map(cardRank -> new Card(emblem, cardRank))
				.toList());
		}
		Collections.shuffle(cardList);
		this.cards = new ArrayDeque<>(cardList);
	}

	public Card pickCard() {
		return this.cards.pollFirst();
	}
}
