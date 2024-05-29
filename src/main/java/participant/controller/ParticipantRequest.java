package participant.controller;

import participant.validator.ParticipantInputValidator;

public class ParticipantRequest {
	private final String participant;

	private ParticipantRequest(final String participant) {
		this.participant = participant;
	}

	public static ParticipantRequest from(final String participant) {
		ParticipantInputValidator.validate(participant);
		return new ParticipantRequest(participant);
	}
}
