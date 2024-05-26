package domain.validator;

import domain.BlackjackParticipant;
import util.CollectionUtils;

import java.util.List;

public class BlackjackParticipantsValidator {

    public static void validate(List<BlackjackParticipant> blackjackParticipants) {
        validateNotEmpty(blackjackParticipants);
    }

    private static void validateNotEmpty(List<BlackjackParticipant> blackjackParticipants) {
        if (CollectionUtils.isEmpty(blackjackParticipants)) {
            throw new IllegalArgumentException("블랙잭 참가자는 null이거나 empty이면 안됩니다.");
        }
    }
}
