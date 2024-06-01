package participant.controller;

import participant.validator.ParticipantInputValidator;
import utils.SplitUtils;

import java.util.Arrays;
import java.util.List;

public class ParticipantRequest {
	private static final String SPLIT_DELIMITER = ",";

	private final List<String> participantNames;

	private ParticipantRequest(final List<String> participantNames) {
		this.participantNames = participantNames;
	}

	public static ParticipantRequest from(final String participantInput) {
		String trimmedInput = participantInput.replaceAll(" ", "");
		ParticipantInputValidator.validate(trimmedInput, SPLIT_DELIMITER);
		final String[] splitInput = SplitUtils.split(trimmedInput, SPLIT_DELIMITER);
		return new ParticipantRequest(Arrays.asList(splitInput));
	}

	public List<String> getParticipantNames() {
		return List.copyOf(participantNames);
	}
}
