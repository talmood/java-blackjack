package participant.domain;

import participant.controller.ParticipantRequest;
import participant.model.Participant;

import java.util.Comparator;
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

		// 참여자 리스트 순서 정렬 - 딜러가 앞에 오도록 정렬
		return participants.stream()
			.sorted(Comparator.comparing(Participant::getName).reversed())
			.collect(Collectors.toList());
	}
}
