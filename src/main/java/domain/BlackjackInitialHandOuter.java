package domain;

import domain.validator.ObjectsValidator;

import java.util.ArrayList;
import java.util.List;

public class BlackjackInitialHandOuter implements BlackjackHandOuter {

    private final BlackjackGame blackjackGame;

    private final HandOutCount handOutCount;

    public BlackjackInitialHandOuter(BlackjackGame blackjackGame, HandOutCount handOutCount) {
        ObjectsValidator.validateNotNull(blackjackGame, handOutCount);
        this.blackjackGame = blackjackGame;
        this.handOutCount = handOutCount;
    }

    @Override
    public BlackjackGame handOut() {
        BlackjackGame blackjackGame = new BlackjackGame(this.blackjackGame);

        for (int i = 0; i < handOutCount.handOutCount(); i++) {
            blackjackGame = this.handOutAllParticipants(blackjackGame);
        }

        return blackjackGame;
    }

    private BlackjackGame handOutAllParticipants(BlackjackGame blackjackGame) {
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
}
