package domain;

import domain.validator.ObjectsValidator;

import java.util.List;

public class BlackjackGame {

    private final BlackjackParticipants blackjackParticipants;
    private final TrumpCardDeck trumpCardDeck;

    public BlackjackGame(BlackjackParticipants blackjackParticipants, TrumpCardDeck trumpCardDeck) {
        ObjectsValidator.validateNotNull(blackjackParticipants, trumpCardDeck);
        this.blackjackParticipants = blackjackParticipants;
        this.trumpCardDeck = trumpCardDeck;
    }

    public BlackjackGame(BlackjackGame blackjackGame) {
        ObjectsValidator.validateNotNull(blackjackGame);
        this.blackjackParticipants = blackjackGame.blackjackParticipants;
        this.trumpCardDeck = blackjackGame.trumpCardDeck;
    }

    public List<BlackjackParticipant> fetchBlackjackParticipants() {
        return this.blackjackParticipants.fetchBlackjackParticipants();
    }

    public List<BlackjackPlayer> fetchBlackjackPlayers() {
        return this.blackjackParticipants.findPlayers().fetchBlackjackPlayers();
    }

    public BlackjackDealer findDealer() {
        return this.blackjackParticipants.findDealer();
    }

    public BlackjackPlayers findPlayers() {
        return this.blackjackParticipants.findPlayers();
    }

    public TrumpCardDeck getTrumpCardDeck() {
        return trumpCardDeck;
    }
}
