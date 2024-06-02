package domain;

import domain.game.BlackjackGame;
import domain.game.BlackjackGameCreator;
import domain.handouter.BlackjackInitialHandOuter;
import domain.handouter.HandOutCount;
import domain.participant.BlackjackParticipant;
import domain.trumpcard.TrumpCardDeck;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import view.input.InputView;
import view.input.dto.HandOutPlayerInput;
import view.input.dto.HandOutPlayerRequest;
import view.input.dto.PlayersInput;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;

class BlackjackInitialHandOuterTest {

    @Test
    void handOut() {
        BlackjackGameCreator blackjackGameCreator = new BlackjackGameCreator(new FakeInputView("pobi, jason"));
        BlackjackGame blackjackGame = blackjackGameCreator.create();

        BlackjackInitialHandOuter blackjackInitialHandOuter = new BlackjackInitialHandOuter(blackjackGame, new HandOutCount(2));
        BlackjackGame handOutGame = blackjackInitialHandOuter.handOut();

        List<BlackjackParticipant> participants = handOutGame.fetchBlackjackParticipants();
        TrumpCardDeck trumpCardDeck = handOutGame.getTrumpCardDeck();

        assertAll(
                () -> Assertions.assertThat(trumpCardDeck.size()).isEqualTo(46),
                () -> Assertions.assertThat(participants).map(BlackjackParticipant::fetchCardSize).allMatch(size -> size == 2)
        );
    }

    static class FakeInputView implements InputView {

        private final String playerNameInput;

        public FakeInputView(String playerNameInput) {
            this.playerNameInput = playerNameInput;
        }

        @Override
        public PlayersInput viewPlayers() {
            return PlayersInput.from(playerNameInput);
        }

        @Override
        public HandOutPlayerInput viewHandOutCardForPlayer(HandOutPlayerRequest handOutPlayerRequest) {
            return null;
        }
    }
}