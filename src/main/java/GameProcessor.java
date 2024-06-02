import java.util.List;

public class GameProcessor {
    InputView inputView;
    ResultView resultView;

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


}
