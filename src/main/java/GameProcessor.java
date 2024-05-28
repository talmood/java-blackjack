import java.util.List;

public class GameProcessor {
    InputView inputView;
    ResultView resultView;

    public GameProcessor(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public List<Player> playersPlayGame(List<Player> players) {
        for (int i = 0; i < players.size(); i++) {
            Player updatedPlayer = playerAcceptsExtraCardIfChooseTo(players.get(i));
            players.set(i, updatedPlayer);
        }
        return players;
    }

    public Player playerAcceptsExtraCardIfChooseTo(Player player) {
        if (inputView.askIfGetOneMoreCard(player.name)) {
            player = player.acceptsExtraCard(player);
            resultView.printPlayerCards(player);
            playerAcceptsExtraCardIfChooseTo(player);
        }
        return player;
    }


}
