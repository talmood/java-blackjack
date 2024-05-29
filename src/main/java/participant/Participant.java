package participant;

import card.Card;

import java.util.ArrayList;
import java.util.List;

public class Participant {
	private static final int ACE_BOTTOM_SCORE = 1;
	private static final int ACE_TOP_SCORE = 11;
	private static final int BLACK_JACK_WINNING_MAX = 21;

	private final String name;
	private final List<Card> cards = new ArrayList<>();

	public Participant(final String name) {
		this.name = name;
	}

	public void addCard(final Card card) {
		this.cards.add(card);
	}

	public int calculateCurrentScore() {
		int currentScore = 0;

		for (Card card : cards) {
			currentScore += fetchCardScore(currentScore, card);
		}

		return currentScore;
	}

	private int fetchCardScore(final int currentScore, final Card card) {
		if (card.rank().isAce()) {
			return fetchAceScore(currentScore);
		}
		return card.rank().getScore();
	}

	private int fetchAceScore(final int currentScore) {
		if (currentScore + ACE_TOP_SCORE > BLACK_JACK_WINNING_MAX) {
			return ACE_BOTTOM_SCORE;
		}
		return ACE_TOP_SCORE;
	}

}
