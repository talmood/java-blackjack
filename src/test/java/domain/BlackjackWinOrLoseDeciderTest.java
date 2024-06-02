package domain;

import domain.game.BlackjackGame;
import domain.participant.*;
import domain.trumpcard.*;
import domain.winorlose.BlackjackWinOrLoseDecider;
import domain.winorlose.DealerWinOrLose;
import domain.winorlose.FinalWinOrLose;
import domain.winorlose.PlayerWinOrLose;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BlackjackWinOrLoseDeciderTest {

    static Stream<Arguments> blackjackDealerAndPlayersAndWinOrLoseParameters() {
        return Stream.of(
                Arguments.arguments(
                        new BlackjackDealer(
                                new TrumpCards(
                                        List.of(
                                                new TrumpCard(TrumpCardRank.JACK, TrumpCardSuit.DIAMONDS),
                                                new TrumpCard(TrumpCardRank.NINE, TrumpCardSuit.DIAMONDS)
                                        )
                                )
                        ),
                        new BlackjackPlayers(
                                List.of(
                                        new BlackjackPlayer(
                                                new BlackjackPlayerName("pobi"),
                                                new TrumpCards(
                                                        List.of(
                                                                new TrumpCard(TrumpCardRank.JACK, TrumpCardSuit.CLUBS),
                                                                new TrumpCard(TrumpCardRank.SEVEN, TrumpCardSuit.CLUBS)
                                                        )
                                                )
                                        )
                                )
                        ),
                        new FinalWinOrLose(new DealerWinOrLose(1, 0, 0),
                                List.of(new PlayerWinOrLose(new BlackjackPlayerName("pobi"), WinOrLose.LOSE))
                        )
                ),
                Arguments.arguments(
                        new BlackjackDealer(
                                new TrumpCards(
                                        List.of(
                                                new TrumpCard(TrumpCardRank.JACK, TrumpCardSuit.DIAMONDS),
                                                new TrumpCard(TrumpCardRank.NINE, TrumpCardSuit.DIAMONDS)
                                        )
                                )
                        ),
                        new BlackjackPlayers(
                                List.of(
                                        new BlackjackPlayer(
                                                new BlackjackPlayerName("pobi"),
                                                new TrumpCards(
                                                        List.of(
                                                                new TrumpCard(TrumpCardRank.JACK, TrumpCardSuit.CLUBS),
                                                                new TrumpCard(TrumpCardRank.KING, TrumpCardSuit.CLUBS)
                                                        )
                                                )
                                        )
                                )
                        ),
                        new FinalWinOrLose(new DealerWinOrLose(0, 1, 0),
                                List.of(new PlayerWinOrLose(new BlackjackPlayerName("pobi"), WinOrLose.WIN))
                        )
                )
        );
    }

    @DisplayName("플레이어가 딜러보다 21에 더 가까우면 승리한다.")
    @ParameterizedTest
    @MethodSource(value = "blackjackDealerAndPlayersAndWinOrLoseParameters")
    void decideTest(BlackjackDealer blackjackDealer, BlackjackPlayers blackjackPlayers, FinalWinOrLose finalWinOrLose) {
        BlackjackGame blackjackGame = new BlackjackGame(BlackjackParticipants.of(blackjackDealer, blackjackPlayers), new TrumpCardDeck());
        BlackjackWinOrLoseDecider blackjackWinOrLoseDecider = new BlackjackWinOrLoseDecider(blackjackGame);

        FinalWinOrLose actual = blackjackWinOrLoseDecider.decide();

        assertThat(actual).isEqualTo(finalWinOrLose);
    }
}