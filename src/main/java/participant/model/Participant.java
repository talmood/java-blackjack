package participant.model;

import card.model.Card;

import java.util.ArrayList;
import java.util.List;

public class Participant {
	private static final int ACE_BOTTOM_SCORE = 1;
	private static final int ACE_TOP_SCORE = 11;
	private static final int BLACK_JACK_WINNING_MAX = 21;
	private static final String DEALER = "딜러";


	private final String name;
	private final List<Card> cards = new ArrayList<>();

	public Participant(final String name) {
		this.name = name;
	}

	public void addCard(final Card card) {
		this.cards.add(card);
	}

	public int calculateCurrentScore() {
		// 우선 A 카드 제외하고 점수 합산
		int currentScore = cards.stream()
			.filter(card -> !card.rank().isAce())
			.mapToInt(card -> card.rank().getScore())
			.sum();

		// A 카드 점수 합산
		for (Card card : cards.stream().filter(card -> card.rank().isAce()).toList()) {
			currentScore += fetchContainAceCardScore(currentScore);
		}

		return currentScore;
	}

	private int fetchContainAceCardScore(final int currentScore) {
		if (currentScore + ACE_TOP_SCORE > BLACK_JACK_WINNING_MAX) {
			return ACE_BOTTOM_SCORE;
		}
		return ACE_TOP_SCORE;
	}

	public boolean isOverWinningMaxScore() {
		return calculateCurrentScore() > BLACK_JACK_WINNING_MAX;
	}

	public String getName() {
		return this.name;
	}

	public List<Card> getCards() {
		return List.copyOf(cards);
	}

	public boolean isDealer() {
		return DEALER.equals(this.name);
	}

}
