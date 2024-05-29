package participant.domain;

import participant.controller.ParticipantRequest;
import participant.model.Participant;

import java.util.List;
import java.util.stream.Collectors;

public class ParticipantRegister {
	private static final String DEALER = "딜러";

	private final ParticipantRequest participantRequest;

	public ParticipantRegister(final ParticipantRequest participantRequest) {
		this.participantRequest = participantRequest;
	}

	public List<Participant> registerParticipants() {
		List<Participant> participants = participantRequest.getParticipantNames().stream()
			.map(Participant::new)
			.collect(Collectors.toList());

		participants.add(new Participant(DEALER));
		return participants;
	}
}
