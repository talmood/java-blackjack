package card.validator;

public class DrawCardInputValidator {
	public static void validate(final String drawCardInput) {
		if (drawCardInput == null || drawCardInput.isBlank()) {
			throw new IllegalArgumentException("카드를 더 뽑을지 y 또는 n을 입력해주세요.");
		}
	}
}
