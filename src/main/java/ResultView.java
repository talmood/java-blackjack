import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public void printFirstDeal(List<String> playerNames) {
        System.out.println("딜러와" + playerNames + "에게 2장을 나누었습니다.");
    }

    public void printInitialDealerCards(Dealer dealer) {
        Card firstCard = dealer.getCards().get(0);
        System.out.println("딜러: " + firstCard.number + firstCard.suit.title );
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
                .map(card -> card.number + card.suit.title)
                .collect(Collectors.joining(", "));
        message += cardsToString;
        System.out.println(message);
    }

}
