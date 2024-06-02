package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import view.output.OutputView;
import view.output.dto.*;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BlackjackDealerHandOuterTest {
    
    static Stream<Arguments> blackjackDealerParameter() {
        return Stream.of(
                Arguments.arguments(
                        new BlackjackDealer(
                                new TrumpCards(
                                        List.of(
                                                new TrumpCard(TrumpCardRank.JACK, TrumpCardSuit.DIAMONDS),
                                                new TrumpCard(TrumpCardRank.SEVEN, TrumpCardSuit.DIAMONDS)
                                        )
                                )
                        ), 2, 52
                ),
                Arguments.arguments(
                        new BlackjackDealer(
                                new TrumpCards(
                                        List.of(
                                                new TrumpCard(TrumpCardRank.JACK, TrumpCardSuit.DIAMONDS),
                                                new TrumpCard(TrumpCardRank.SIX, TrumpCardSuit.DIAMONDS)
                                        )
                                )
                        ), 3, 51
                )
        );
    }

    @DisplayName("블랙잭 점수가 임계값보다 작으면 딜러는 한장 받는다.")
    @ParameterizedTest
    @MethodSource(value = "blackjackDealerParameter")
    void handOut(BlackjackDealer blackjackDealer, int expectCardCount, int expectDeckCount) {
        BlackjackPlayers blackjackPlayers = new BlackjackPlayers(List.of(
                new BlackjackPlayer(new BlackjackPlayerName("pobi"), TrumpCards.createEmptyCards()),
                new BlackjackPlayer(new BlackjackPlayerName("jason"), TrumpCards.createEmptyCards())
        )
        );

        BlackjackGame blackjackGame =
                new BlackjackGame(BlackjackParticipants.of(blackjackDealer, blackjackPlayers), new TrumpCardDeck());
        BlackjackDealerHandOuter blackjackDealerHandOuter = new BlackjackDealerHandOuter(blackjackGame, new FakeOutputView());
        BlackjackGame actualBlackjackGame = blackjackDealerHandOuter.handOut();

        TrumpCardDeck trumpCardDeck = actualBlackjackGame.getTrumpCardDeck();
        BlackjackDealer dealer = actualBlackjackGame.findDealer();
        assertAll(
                () -> assertEquals(expectCardCount, dealer.fetchCardSize()),
                () -> assertEquals(expectDeckCount, trumpCardDeck.size())
        );
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