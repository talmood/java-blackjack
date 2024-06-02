package domain.handouter;

import domain.game.BlackjackGame;
import domain.participant.BlackjackParticipant;
import domain.participant.BlackjackParticipants;
import domain.participant.BlackjackPlayer;
import domain.participant.BlackjackPlayerName;
import domain.trumpcard.TrumpCard;
import domain.trumpcard.TrumpCardDeck;
import domain.validator.ObjectsValidator;
import view.input.InputView;
import view.input.dto.HandOutPlayerInput;
import view.input.dto.HandOutPlayerRequest;
import view.output.OutputView;
import view.output.dto.HandOutPlayerOutput;

import java.util.ArrayList;
import java.util.List;

public class BlackjackPlayersHandOuter implements BlackjackHandOuter {

    private final BlackjackGame blackjackGame;

    private final InputView inputView;

    private final OutputView outputView;

    public BlackjackPlayersHandOuter(BlackjackGame blackjackGame, InputView inputView, OutputView outputView) {
        ObjectsValidator.validateNotNull(blackjackGame, inputView, outputView);
        this.blackjackGame = blackjackGame;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public BlackjackGame handOut() {
        List<BlackjackParticipant> receivedParticipants = new ArrayList<>();
        TrumpCardDeck trumpCardDeck = this.blackjackGame.getTrumpCardDeck();
        List<BlackjackPlayer> blackjackPlayers = this.blackjackGame.fetchBlackjackPlayers();

        for (BlackjackPlayer blackjackPlayer : blackjackPlayers) {
            BlackjackPlayerName blackjackPlayerName = blackjackPlayer.getBlackjackPlayerName();

            while (this.isHandOut(blackjackPlayerName, this.inputView)) {
                TrumpCard trumpCard = trumpCardDeck.fetchTopOne();
                trumpCardDeck = trumpCardDeck.takeOutTopOne();
                blackjackPlayer = blackjackPlayer.receiveCard(trumpCard);
                this.outputView.viewHandOutPlayer(HandOutPlayerOutput.of(blackjackPlayerName, blackjackPlayer));
            }
            receivedParticipants.add(blackjackPlayer);
        }

        receivedParticipants.add(this.blackjackGame.findDealer());

        return new BlackjackGame(new BlackjackParticipants(receivedParticipants), trumpCardDeck);
    }

    private boolean isHandOut(BlackjackPlayerName blackjackPlayerName, InputView inputView) {
        HandOutPlayerInput handOutPlayerInput = inputView.viewHandOutCardForPlayer(HandOutPlayerRequest.from(blackjackPlayerName));
        return handOutPlayerInput.isHandOut();
    }
}
