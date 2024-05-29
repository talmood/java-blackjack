package participant.validator;

public class ParticipantInputValidator {
	private static final String SPLIT_DELIMETER = ",";

	public static void validate(final String participant) {
		try {
			participant.split(SPLIT_DELIMETER);
		} catch (Exception e) {
			throw new IllegalArgumentException("게임 참여할 사람의 이름을 입력할 때 문제가 발생했습니다.");
		}
	}
}
