package card.controller;

import card.validator.DrawCardInputValidator;

import java.util.List;

public class DrawCardRequest {
	private static final List<String> DRAW_YES = List.of("y", "Y");
	public final DrawCard drawCard;

	private DrawCardRequest(final DrawCard drawCard) {
		this.drawCard = drawCard;
	}

	public static DrawCardRequest from(final String input) {
		DrawCardInputValidator.validate(input);
		return new DrawCardRequest(formattedDrawCardInput(input));
	}

	private static DrawCard formattedDrawCardInput(final String input) {
		if (DRAW_YES.contains(input)) {
			return DrawCard.y;
		}

		return DrawCard.n;
	}

	public boolean isNotDrawCard() {
		return !this.drawCard.isY();
	}
}
