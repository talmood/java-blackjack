package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import view.input.InputView;
import view.input.dto.HandOutPlayerInput;
import view.input.dto.HandOutPlayerRequest;
import view.input.dto.PlayersInput;

import java.util.List;

class BlackjackInitialHandOuterTest {

    @Test
    void handOut() {
        BlackjackGameCreator blackjackGameCreator = new BlackjackGameCreator(new FakeInputView("pobi, jason"));
        BlackjackGame blackjackGame = blackjackGameCreator.create();

        BlackjackInitialHandOuter blackjackInitialHandOuter = new BlackjackInitialHandOuter(blackjackGame, new HandOutCount(2));
        BlackjackGame handOutGame = blackjackInitialHandOuter.handOut();

        List<BlackjackParticipant> participants = handOutGame.fetchBlackjackParticipants();
        Assertions.assertThat(participants).map(BlackjackParticipant::fetchCardSize).allMatch(size -> size == 2);
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

        @Override
        public void viewThresholdCard() {

        }
    }
}