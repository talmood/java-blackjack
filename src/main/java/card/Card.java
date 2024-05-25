package card;

public class Card {
	private final CardEmblem emblem;
	private final CardNumber number;

	private Card(final CardEmblem emblem, final CardNumber number) {
		this.emblem = emblem;
		this.number = number;
	}

	public static Card of(final CardEmblem emblem, final CardNumber number) {
		return new Card(emblem, number);
	}
}
