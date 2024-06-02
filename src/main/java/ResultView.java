import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public void printFirstDeal(GameStatus gameStatus) {
        printPlayerNames(gameStatus);
        printInitialDealerCards(gameStatus.getDealer());
        printInitialPlayerCards(gameStatus.getPlayers());
    }

    private void printPlayerNames(GameStatus gameStatus) {
        List<Player> players = gameStatus.getPlayers();
        StringBuilder names = new StringBuilder();
        for (Player player : players) {
            names.append(",").append(player.getName());
        }

        System.out.println("딜러와" + names + "에게 2장을 나누었습니다.");
    }

    public void printInitialDealerCards(Dealer dealer) {
        Card firstCard = dealer.getCards().get(0);
        String denomination = getDenomination(firstCard);
        System.out.println("딜러: " + denomination + firstCard.suit.title);
    }

    private String getDenomination(Card card) {
        String denomination = "";
        if (Denomination.isNumber(card.number)) {
            denomination = String.valueOf(card.number.value);
        }
        if (!Denomination.isNumber(card.number)) {
            denomination = card.number.toString();
        }
        return denomination;
    }

    public void printInitialPlayerCards(List<Player> players) {
        for (Player player : players) {
            printPlayerCards(player);
        }
    }

    public void printPlayerCards(Player player) {
        String message = player.name + " 카드: ";
        List<Card> cards = player.cards;
        String cardsToString = cards.stream()
                .map(card -> getDenomination(card) + card.suit.title)
                .collect(Collectors.joining(", "));
        message += cardsToString;
        System.out.println(message);
    }

    public void printDealerCard() {
        System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
    }
}
