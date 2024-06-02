import java.util.List;

public class GameProcessor {
    InputView inputView;
    ResultView resultView;

    static int MAX_DEALER_CARD_NUMBER_SUM = 16;

    public GameProcessor(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public List<Player> playersPlayGame(List<Player> players, CardSet cardSet) {
        for (int i = 0; i < players.size(); i++) {
            Player updatedPlayer = playerAcceptsExtraCardIfChooseTo(players.get(i), cardSet);
            players.set(i, updatedPlayer);
        }
        return players;
    }

    public Player playerAcceptsExtraCardIfChooseTo(Player player, CardSet cardSet) {
        if (inputView.askIfGetOneMoreCard(player.name)) {
            player.pickCard(cardSet);
            resultView.printPlayerCards(player);
            playerAcceptsExtraCardIfChooseTo(player, cardSet);
        }
        return player;
    }

    public Dealer dealerPlayGame(Dealer dealer, CardSet cardSet) {
        List<Card> cards = dealer.getCards();
        int sumOfNumbers = 0;
        for (Card card : cards) {
            sumOfNumbers += card.number.getValue();
        }
        if (sumOfNumbers <= MAX_DEALER_CARD_NUMBER_SUM) {
            dealer.pickCard(cardSet);
            resultView.printDealerCard();
            dealerPlayGame(dealer, cardSet);
        }
        return dealer;
    }
}
