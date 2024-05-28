import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public void printFirstDeal(List<String> playerNames) {
        System.out.println("딜러와" + playerNames + "에게 2장을 나누었습니다.");
    }

    public void printInitialDealerCards(Dealer dealer) {
        Card firstCard = dealer.getCards().get(0);
        System.out.println("딜러: " + firstCard.number + firstCard.suits.title );
    }

    public void printInitialPlayerCards(List<Player> players) {
        for (Player player : players) {
            String message = player.name + " 카드: ";
            List<Card> cards = player.cards;
            String cardsToString = cards.stream()
                    .map(card -> card.number + card.suits.title)
                    .collect(Collectors.joining(", "));
            message += cardsToString;
            System.out.println(message);
        }
    }
}
