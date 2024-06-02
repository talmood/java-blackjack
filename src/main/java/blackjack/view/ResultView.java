package blackjack.view;

import blackjack.domain.participant.Dealer;
import blackjack.domain.participant.Participant;
import blackjack.domain.participant.Players;

import java.util.List;

public class ResultView {
    private static final String SHARE_INITIAL_CARDS = "딜러와 %s에게 2장을 나누었습니다.";
    private static final String PLAYER_DRAW_CARD = "%s는 카드를 더 받겠습니까? (예는 y, 아니오는 n)";
    private static final String DEALER_DRAW_CARD = "딜러는 16이하라 한장의 카드를 더 받았습니다.";
    private static final String CARD_INFO = "%s 카드: %s";

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
            final String cardsInfo = String.join(", ", player.getCards().showCardsInfo());
            System.out.println(String.format(CARD_INFO, player.getName(), cardsInfo));
        }
    }

    public static void printPlayerDrawCard(final String playerName) {
        System.out.println(String.format(PLAYER_DRAW_CARD, playerName));
    }

    public static void printDealerDrawCard() {
        System.out.println(DEALER_DRAW_CARD);
    }

    public static void printResult(final List<Participant> participants) {
        System.out.println("## 최종 승패");
        for (Participant participant : participants) {
            System.out.println(participant);
        }

    }
}
