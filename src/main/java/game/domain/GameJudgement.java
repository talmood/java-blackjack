package game.domain;

import participant.model.Participant;

import java.util.ArrayList;
import java.util.List;

public class GameJudgement {
	private static final String WIN_PARTICIPANT_MESSAGE = "%s: 승";
	private static final String LOSE_PARTICIPANT_MESSAGE = "%s: 패";

	private final Participant dealer;
	private final List<Participant> participantWithoutDealers = new ArrayList<>();

	public GameJudgement(final List<Participant> participants) {
		this.dealer = participants.stream()
			.filter(Participant::isDealer)
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException("게임에 딜러가 존재하지 않습니다."));
		this.participantWithoutDealers.addAll(participants.stream()
			.filter(participant -> !participant.isDealer())
			.toList()
		);
	}

	public String fetchDealerJudge() {
		final int dealerScore = this.dealer.calculateCurrentScore();
		final String dealerJudgeMessage = "딜러: %d승 %d패";
		int winCount = 0;
		int loseCount = 0;

		// 21점이 넘어가면 무조건 패배 - 참여자 수만큼 패배한 수로 세팅
		if (this.dealer.isOverWinningMaxScore()) {
			loseCount = participantWithoutDealers.size();
			return dealerJudgeMessage.formatted(winCount, loseCount);
		}

		winCount = fetchDealerWinningCount(dealerScore);
		loseCount = fetchDealerLoseCount(dealerScore);

		return dealerJudgeMessage.formatted(winCount, loseCount);
	}

	private int fetchDealerWinningCount(final int dealerScore) {
		int winCount;
		winCount = participantWithoutDealers.stream()
			.map(Participant::calculateCurrentScore)
			.filter(participantScore -> dealerScore > participantScore)
			.toList()
			.size();
		return winCount;
	}

	private int fetchDealerLoseCount(final int dealerScore) {
		return participantWithoutDealers.stream()
			.map(Participant::calculateCurrentScore)
			.filter(participantScore -> dealerScore < participantScore)
			.toList()
			.size();
	}

	public List<String> fetchParticipantJudge() {
		return participantWithoutDealers.stream()
			.map(participant -> {
				String loseMessage = LOSE_PARTICIPANT_MESSAGE.formatted(participant.getName());
				if (participant.isOverWinningMaxScore()) {
					return loseMessage;
				}

				int participantScore = participant.calculateCurrentScore();
				if (participantWithoutDealers.stream()
					.filter(p -> !(p.getName().equals(participant.getName()) ||
						p.isOverWinningMaxScore()))
					.allMatch(innerParticipant -> participantScore > innerParticipant.calculateCurrentScore())) {
					return WIN_PARTICIPANT_MESSAGE.formatted(participant.getName());
				}

				return loseMessage;
			})
			.toList();
	}
}
