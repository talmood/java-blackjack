package domain.game;

import domain.participant.BlackjackDealer;
import domain.participant.BlackjackParticipants;
import domain.participant.BlackjackPlayerName;
import domain.participant.BlackjackPlayers;
import domain.trumpcard.TrumpCardDeck;
import domain.validator.ObjectsValidator;
import view.input.InputView;
import view.input.dto.PlayersInput;

import java.util.List;

public class BlackjackGameCreator {

    private final InputView inputView;

    public BlackjackGameCreator(InputView inputView) {
        ObjectsValidator.validateNotNull(inputView);
        this.inputView = inputView;
    }

    public BlackjackGame create() {
        PlayersInput playersInput = inputView.viewPlayers();
        List<BlackjackPlayerName> blackjackPlayerNames = playersInput.toBlackjackPlayerNames();
        BlackjackPlayers blackjackPlayers = BlackjackPlayers.fromNamesWithEmptyCards(blackjackPlayerNames);
        BlackjackDealer blackjackDealer = BlackjackDealer.createWithEmptyCards();
        TrumpCardDeck trumpCardDeck = new TrumpCardDeck();

        return new BlackjackGame(BlackjackParticipants.of(blackjackDealer, blackjackPlayers), trumpCardDeck);
    }
}
