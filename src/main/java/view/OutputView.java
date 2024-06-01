package view;

import card.model.Card;
import game.domain.GameJudgement;
import participant.model.Participant;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
	private static final String JOINING_DELIMITER = ", ";

	public void firstDistributeCard(final List<Participant> participants) {
		final String joiningParticipant = participants.stream()
			.filter(participant -> !participant.isDealer())
			.map(Participant::getName)
			.collect(Collectors.joining(JOINING_DELIMITER));

		System.out.println("딜러와 %s에게 2장을 나누었습니다.".formatted(joiningParticipant));
	}

	public void printParticipantsCard(final List<Participant> participants) {
		for (Participant participant : participants) {
			printParticipantCard(participant);
		}
	}

	public void printParticipantCard(final Participant participant) {
		final String joiningCard = participant.getCards().stream()
				.map(Card::toString)
				.collect(Collectors.joining(JOINING_DELIMITER));
		System.out.println("%s카드: %s".formatted(participant.getName(), joiningCard));
	}

	public void printDealerDrawCard() {
		System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
	}

	public void printFinalResult(final List<Participant> participants) {
		for (Participant participant : participants) {
			String joiningCard = participant.getCards().stream()
				.map(Card::toString)
				.collect(Collectors.joining(JOINING_DELIMITER));
			int score = participant.calculateCurrentScore();

			System.out.println("%s 카드: %s - 결과: %d".formatted(participant.getName(), joiningCard, score));
		}
	}

	public void printGameJudgement(final GameJudgement gameJudgement) {
		System.out.println("## 최종 승패");
		System.out.println(gameJudgement.fetchDealerJudge());
		gameJudgement.fetchParticipantJudge().forEach(System.out::println);
	}

}
