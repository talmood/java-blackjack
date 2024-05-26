package domain;

import java.util.ArrayList;

public class BlackjackGame {

    private final BlackjackParticipants blackjackParticipants;
    private final TrumpCardDeck trumpCardDeck;

    public BlackjackGame(BlackjackParticipants blackjackParticipants, TrumpCardDeck trumpCardDeck) {
        this.blackjackParticipants = blackjackParticipants;
        this.trumpCardDeck = trumpCardDeck;
    }

    public BlackjackGame initialHandOut(HandOutCount handOutCount) {
        BlackjackGame blackjackGame = this;
        TrumpCardDeck trumpCardDeck = this.trumpCardDeck;

        for (int i = 0; i < handOutCount.getHandOutCount(); i++) {
            ArrayList<TrumpCard> trumpCards = new ArrayList<>();

            for (int j = 0; j < blackjackParticipants.size(); j++) {
                TrumpCard trumpCard = trumpCardDeck.fetchTopOne();
                trumpCardDeck = trumpCardDeck.takeOutTopOne();
                trumpCards.add(trumpCard);
            }

            BlackjackParticipants handOutParticipants = blackjackGame.getBlackjackParticipants().handOutOneCardForAll(new TrumpCards(trumpCards));
            blackjackGame = new BlackjackGame(handOutParticipants, trumpCardDeck);
        }

        return blackjackGame;
    }

    public BlackjackParticipants getBlackjackParticipants() {
        return this.blackjackParticipants;
    }
}
