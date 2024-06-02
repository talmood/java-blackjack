package domain;

import domain.game.BlackjackGame;
import domain.game.BlackjackGameCreator;
import domain.handouter.BlackjackPlayersHandOuter;
import domain.participant.BlackjackPlayer;
import domain.trumpcard.TrumpCardDeck;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import view.input.InputView;
import view.input.dto.HandOutPlayerInput;
import view.input.dto.HandOutPlayerRequest;
import view.input.dto.PlayersInput;
import view.output.OutputView;
import view.output.dto.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;

class BlackjackPlayersHandOuterTest {

    @Test
    void handOut() {
        BlackjackGameCreator blackjackGameCreator = new BlackjackGameCreator(new BlackjackInitialHandOuterTest.FakeInputView("pobi, jason"));
        BlackjackGame blackjackGame = blackjackGameCreator.create();

        BlackjackPlayersHandOuter blackjackPlayersHandOuter =
                new BlackjackPlayersHandOuter(blackjackGame, new FakeInputView("pobi,jason"), new FakeOutputView());

        BlackjackGame handOutGame = blackjackPlayersHandOuter.handOut();
        TrumpCardDeck trumpCardDeck = handOutGame.getTrumpCardDeck();
        List<BlackjackPlayer> blackjackPlayers = handOutGame.fetchBlackjackPlayers();

        assertAll(
                () -> Assertions.assertThat(trumpCardDeck.size()).isEqualTo(50),
                () -> Assertions.assertThat(blackjackPlayers).map(BlackjackPlayer::fetchCardSize).allMatch(size -> size == 1)
        );
    }

    static class FakeInputView implements InputView {

        private final String playerNameInput;
        private int count = 0;

        public FakeInputView(String playerNameInput) {
            this.playerNameInput = playerNameInput;
        }

        @Override
        public PlayersInput viewPlayers() {
            return PlayersInput.from(playerNameInput);
        }

        @Override
        public HandOutPlayerInput viewHandOutCardForPlayer(HandOutPlayerRequest handOutPlayerRequest) {

            if (count % 2 == 0) {
                count++;
                return new HandOutPlayerInput(true);
            }

            if (count % 2 == 1) {
                count++;
                return new HandOutPlayerInput(false);
            }

            return null;
        }

        @Override
        public void viewThresholdCard() {

        }
    }

    static class FakeOutputView implements OutputView {

        @Override
        public void viewInitialHandOut(InitialHandOutOutput initialHandOutOutput) {

        }

        @Override
        public void viewHandOutPlayer(HandOutPlayerOutput handOutPlayerOutput) {

        }

        @Override
        public void viewHandOutDealer(HandOutDealerOutput handOutDealerOutput) {

        }

        @Override
        public void viewBlackjackResult(BlackjackResultOutputs blackjackResultOutput) {

        }

        @Override
        public void viewFinalWinOrLose(FinalWinOrLoseOutput finalWinOrLoseOutput) {

        }
    }

}