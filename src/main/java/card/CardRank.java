package card;

public enum CardRank {
	ACE(1, "A"),
	TWO(2, "2"),
	THREE(3, "3"),
	FOUR(4, "4"),
	FIVE(5, "5"),
	SIX(6, "6"),
	SEVEN(7, "7"),
	EIGHT(8, "8"),
	NINE(9, "9"),
	JACK(10, "J"),
	QUEEN(10, "Q"),
	KING(10, "K");

	private final int score;
	private final String rank;

	CardRank(final int score, final String rank) {
		this.score = score;
		this.rank = rank;
	}

	public int getScore() {
		return this.score;
	}

	public String getRank() {
		return this.rank;
	}

	public boolean isAce() {
		return this == ACE;
	}
}
