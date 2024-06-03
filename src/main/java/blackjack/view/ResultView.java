package blackjack.view;

import blackjack.domain.participant.Dealer;
import blackjack.domain.participant.Participant;
import blackjack.domain.participant.Players;
import blackjack.domain.result.DealerResult;
import blackjack.domain.result.PlayerResult;
import blackjack.domain.result.Result;

import java.util.List;
import java.util.Map;

public class ResultView {
    private static final String SHARE_INITIAL_CARDS = "딜러와 %s에게 2장을 나누었습니다.";
    private static final String DEALER_DRAW_CARD = "딜러는 16이하라 한장의 카드를 더 받았습니다.";
    private static final String CARD_INFO = "%s 카드: %s";
    private static final String CARD_INFO_WITH_SCORE = "%s 카드: %s - 결과: %d";
    private static final String FINAL_RESULT = "## 최종 승패";
    private static final String PARTICIPANT_RESULT = "%s: %s";


    public static void printShareInitialCards(final Players players, final Dealer dealer) {
        final String playerNames = String.join(", ", players.getPlayerNames());
        System.out.println(String.format(SHARE_INITIAL_CARDS, playerNames));

        printDealerInitialCards(dealer);
        printPlayerInitialCards(players);
    }
    private static void printDealerInitialCards(final Dealer dealer) {
        final String cardsInfo = dealer.getCards().showCardsInfo().get(0);
        System.out.println(String.format(CARD_INFO, dealer.getName(), cardsInfo));
    }

    private static void printPlayerInitialCards(final Players players) {
        for (Participant player : players.getPlayers()) {
            printCardInfo(player);
        }
    }

    public static void printDealerDrawCard() {
        System.out.println(DEALER_DRAW_CARD);
    }

    public static void printCardInfo(final Participant participant) {
        final String cardsInfo = String.join(", ", participant.getCards().showCardsInfo());
        System.out.println(String.format(CARD_INFO, participant.getName(), cardsInfo));
    }

    public static void printCardInfoWithScore(final Participant participant) {
        final String cardsInfo = String.join(", ", participant.getCards().showCardsInfo());
        System.out.println(String.format(CARD_INFO_WITH_SCORE, participant.getName(), cardsInfo, participant.getCards().calculateScore()));
    }

    public static void printResult(final List<PlayerResult> playerResults, final DealerResult dealerResult) {
        printBlankLine();
        System.out.println(FINAL_RESULT);
        printDealerResult(dealerResult);
        printPlayerResults(playerResults);
    }

    private static void printDealerResult(final DealerResult dealerResult) {
        final Map<Result, Integer> result = dealerResult.getResult();
        final StringBuilder resultString = new StringBuilder();

        int winCount = result.getOrDefault(Result.WIN, 0);
        int loseCount = result.getOrDefault(Result.LOSE, 0);
        int drawCount = result.getOrDefault(Result.DRAW, 0);

        if (winCount > 0) {
            resultString.append(winCount).append("승 ");
        }
        if (loseCount > 0) {
            resultString.append(loseCount).append("패 ");
        }
        if (drawCount > 0) {
            resultString.append(drawCount).append("무");
        }

        System.out.println(String.format(PARTICIPANT_RESULT, "딜러", resultString));
    }

   private static void printPlayerResults(final List<PlayerResult> playerResults) {
        for (final PlayerResult playerResult : playerResults) {
            System.out.println(String.format(PARTICIPANT_RESULT, playerResult.getName(), playerResult.getResult().getName()));
        }
    }


    public static void printBlankLine() {
        System.out.println();
    }
}
