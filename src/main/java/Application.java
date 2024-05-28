import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView(new InputValidator());
        ResultView resultView = new ResultView();

        GameStarter gameStarter = new GameStarter();
        List<String> playerNames = new GameStarter().getPlayersNames(inputView);
        resultView.printFirstDeal(playerNames);
        Dealer dealer = gameStarter.pickDealerCards(resultView);
        List<Player> players = gameStarter.pickPlayerCards(playerNames, resultView);

        List<Player> playersFinishedGame = new GameProcessor(inputView,resultView).playersPlayGame(players);

    }
}
