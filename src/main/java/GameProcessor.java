import java.util.ArrayList;
import java.util.List;

public class GameProcessor {
    InputView inputView;
    ResultView resultView;

    static int MAX_DEALER_CARD_NUMBER_SUM = 16;
    static int GAME_STANDARD_WINNING_NUMBER = 21;

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
            resultView.printDealerGetsAdditionalCard();
            dealerPlayGame(dealer, cardSet);
        }
        return dealer;
    }

    public List<WinningStatusPlayer> decideWinner(GameStatus gameStatus) {

        List<Player> players = gameStatus.getPlayers();
        Dealer dealer = gameStatus.getDealer();

        int dealerTotalScore = dealer.getTotalScore();
        int dealerAbsolute = Math.abs(GAME_STANDARD_WINNING_NUMBER - dealerTotalScore);

        List<WinningStatusPlayer> winningStatusPlayers = new ArrayList<>();
        for (Player player : players) {
            int playerTotalScore = player.getTotalScore();
            int playerAbsolute = Math.abs(GAME_STANDARD_WINNING_NUMBER - playerTotalScore);

            WinningStatusPlayer winningStatusPlayer = null;
            if (playerAbsolute < dealerAbsolute) {
                winningStatusPlayer = new WinningStatusPlayer(player, true);
            }
            if (playerAbsolute == dealerAbsolute) {
                winningStatusPlayer = new WinningStatusPlayer(player, null);
            }
            if (playerAbsolute > dealerAbsolute) {
                winningStatusPlayer = new WinningStatusPlayer(player, false);
            }
            winningStatusPlayers.add(winningStatusPlayer);

        }
        return winningStatusPlayers;

    }

}
