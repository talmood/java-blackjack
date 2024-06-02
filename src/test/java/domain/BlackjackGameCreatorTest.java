package domain;

import domain.game.BlackjackGame;
import domain.game.BlackjackGameCreator;
import domain.participant.BlackjackPlayer;
import domain.participant.BlackjackPlayers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import view.input.InputView;
import view.input.dto.HandOutPlayerInput;
import view.input.dto.HandOutPlayerRequest;
import view.input.dto.PlayersInput;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BlackjackGameCreatorTest {

    static Stream<Arguments> playerNamesParameter() {
        return Stream.of(
                Arguments.arguments("pobi,jason"),
                Arguments.arguments("pobi, jason")
        );
    }

    @ParameterizedTest
    @MethodSource(value = "playerNamesParameter")
    @DisplayName("플레이어 이름 입력을 받으면 입력한 플레이어들이 참여하는 blackjackGame이 생성된다")
    void createTest(String playerNamesInput) {
        InputView fakeInputView = new FakeInputView(playerNamesInput);

        BlackjackGameCreator blackjackGameCreator = new BlackjackGameCreator(fakeInputView);
        BlackjackGame blackjackGame = blackjackGameCreator.create();

        BlackjackPlayers players = blackjackGame.findPlayers();
        List<BlackjackPlayer> blackjackPlayers = players.fetchBlackjackPlayers();

        assertEquals(blackjackPlayers.size(), playerNamesInput.split(",").length);
        for (BlackjackPlayer blackjackPlayer : blackjackPlayers) {
            String playerName = blackjackPlayer.getPlayerName();

            assertTrue(playerNamesInput.contains(playerName));
        }

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