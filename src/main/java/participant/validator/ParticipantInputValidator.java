package participant.validator;

import utils.SplitUtils;

public class ParticipantInputValidator {

	public static void validate(final String participant, final String delimiter) {
		try {
			SplitUtils.split(participant, delimiter);
		} catch (Exception e) {
			throw new IllegalArgumentException("게임 참여할 사람의 이름을 입력할 때 문제가 발생했습니다.");
		}
	}
}
