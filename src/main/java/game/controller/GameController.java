package game.controller;

import card.CardDeck;
import card.controller.DrawCardRequest;
import game.domain.GameJudgement;
import participant.controller.ParticipantRequest;
import participant.domain.ParticipantRegister;
import participant.model.Participant;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.stream.IntStream;

public class GameController {
	private static final int FIRST_CARD_COUNT = 2;
	private static final int DEALER_DRAW_CARD_SCORE = 16;

	private final InputView inputView;
	private final OutputView outputView;

	private final CardDeck cardDeck = new CardDeck();

	public GameController(final InputView inputView, final OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public void run() {
		List<Participant> participants = fetchParticipants();
		firstDrawCards(participants);
		drawCardsWithoutDealer(participants);
		drawCardDealer(participants.stream()
			.filter(Participant::isDealer)
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException("게임에 딜러가 존재하지 않습니다."))
		);

		this.outputView.printFinalResult(participants);
		this.outputView.printGameJudgement(new GameJudgement(participants));
	}

	private List<Participant> fetchParticipants() {
		ParticipantRequest participantRequest = this.inputView.inputParticipants();
		ParticipantRegister participantRegister = new ParticipantRegister(participantRequest);
		return participantRegister.registerParticipants();
	}

	private void firstDrawCards(List<Participant> participants) {
		this.outputView.firstDistributeCard(participants);
		for (Participant participant : participants) {
			IntStream.range(0, FIRST_CARD_COUNT).forEach(it -> {
				participant.addCard(this.cardDeck.pickCard());
			});
		}
		this.outputView.printParticipantsCard(participants);
	}

	private void drawCardsWithoutDealer(List<Participant> participants) {
		for (Participant participant : participants.stream()
			.filter(participant -> !participant.isDealer())
			.toList()) {
			choiceDrawCard(participant);
		}
	}

	private void choiceDrawCard(Participant participant) {
		while (true) {
			DrawCardRequest drawCardRequest = this.inputView.inputDrawCard(participant);
			if (drawCardRequest.isNotDrawCard()) break;

			participant.addCard(this.cardDeck.pickCard());
			this.outputView.printParticipantCard(participant);
		}
	}

	private void drawCardDealer(Participant participant) {
		if (participant.calculateCurrentScore() <= DEALER_DRAW_CARD_SCORE) {
			this.outputView.printDealerDrawCard();
			participant.addCard(this.cardDeck.pickCard());
		}
	}
}
