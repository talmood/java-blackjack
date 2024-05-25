package card;

public enum CardEmblem {
	CLOVER("클로버"),
	HEART("하트"),
	SPADE("스페이드"),
	DIAMOND("다이아몬드");

	private final String name;

	CardEmblem(final String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}
