package domain;

import view.input.InputView;
import view.input.dto.HandOutPlayerInput;
import view.input.dto.HandOutPlayerRequest;
import view.output.OutputView;
import view.output.dto.HandOutDealerOutput;
import view.output.dto.HandOutPlayerOutput;

import java.util.ArrayList;
import java.util.List;

public class TrumpCardHandOuter {

    private static final int DEALER_HAND_OUT_THRESHOLD = 17;

    public BlackjackGame handOutAllParticipants(BlackjackGame blackjackGame) {
        ArrayList<BlackjackParticipant> receivedParticipants = new ArrayList<>();
        TrumpCardDeck trumpCardDeck = blackjackGame.getTrumpCardDeck();

        List<BlackjackParticipant> participants = blackjackGame.fetchBlackjackParticipants();

        for (BlackjackParticipant participant : participants) {
            TrumpCard trumpCard = trumpCardDeck.fetchTopOne();
            trumpCardDeck = trumpCardDeck.takeOutTopOne();
            BlackjackParticipant receiveParticipant = participant.receiveCard(trumpCard);
            receivedParticipants.add(receiveParticipant);
        }

        return new BlackjackGame(new BlackjackParticipants(receivedParticipants), trumpCardDeck);
    }

    public BlackjackGame handOutAllPlayers(BlackjackGame blackjackGame, InputView inputView, OutputView outputView) {
        List<BlackjackParticipant> receivedParticipants = new ArrayList<>();
        TrumpCardDeck trumpCardDeck = blackjackGame.getTrumpCardDeck();
        List<BlackjackPlayer> blackjackPlayers = blackjackGame.fetchBlackjackPlayers();

        for (BlackjackPlayer blackjackPlayer : blackjackPlayers) {
            BlackjackPlayerName blackjackPlayerName = blackjackPlayer.getBlackjackPlayerName();

            while (this.isHandOut(blackjackPlayerName, inputView)) {
                TrumpCard trumpCard = trumpCardDeck.fetchTopOne();
                trumpCardDeck = trumpCardDeck.takeOutTopOne();
                blackjackPlayer = blackjackPlayer.receiveCard(trumpCard);
                outputView.viewHandOutPlayer(HandOutPlayerOutput.of(blackjackPlayerName, blackjackPlayer));
            }
            receivedParticipants.add(blackjackPlayer);
        }

        receivedParticipants.add(blackjackGame.findDealer());

        return new BlackjackGame(new BlackjackParticipants(receivedParticipants), trumpCardDeck);
    }

    public BlackjackGame handOutDealer(BlackjackGame blackjackGame, OutputView outputView) {
        List<BlackjackParticipant> receivedParticipants = new ArrayList<>(blackjackGame.fetchBlackjackPlayers());
        BlackjackDealer dealer = blackjackGame.findDealer();
        BlackjackPoint blackjackPoint = dealer.calculatePoint();
        TrumpCardDeck trumpCardDeck = blackjackGame.getTrumpCardDeck();

        if (blackjackPoint.isLossThan(new BlackjackPoint(DEALER_HAND_OUT_THRESHOLD))) {
            TrumpCard trumpCard = trumpCardDeck.fetchTopOne();
            trumpCardDeck = trumpCardDeck.takeOutTopOne();
            dealer = dealer.receiveCard(trumpCard);
            outputView.viewHandOutDealer(new HandOutDealerOutput(DEALER_HAND_OUT_THRESHOLD - 1));
        }

        receivedParticipants.add(dealer);
        return new BlackjackGame(new BlackjackParticipants(receivedParticipants), trumpCardDeck);
    }

    private boolean isHandOut(BlackjackPlayerName blackjackPlayerName, InputView inputView) {
        HandOutPlayerInput handOutPlayerInput = inputView.viewHandOutCardForPlayer(HandOutPlayerRequest.from(blackjackPlayerName));
        return handOutPlayerInput.isHandOut();
    }

}
