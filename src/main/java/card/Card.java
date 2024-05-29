package card;

public record Card (
	CardSuit suit,
	CardRank rank
) {
	@Override
	public String toString() {
		return "%s%s".formatted(rank.getRank(), suit.getName());
	}
}
