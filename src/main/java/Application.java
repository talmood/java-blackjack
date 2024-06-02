import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView(new InputValidator());
        ResultView resultView = new ResultView();

        GameStarter gameStarter = new GameStarter();
        CardSet cardSet = gameStarter.generateCardSet();

        List<Player> players = gameStarter.createPlayers(inputView);
        Dealer dealer = gameStarter.createDealer();
        GameStatus gameStatus = new GameStatus(players, dealer, cardSet);
        gameStarter.dealFirstTurn(gameStatus);
        resultView.printFirstDeal(gameStatus);


//        Dealer dealer = gameStarter.pickDealerCards(resultView);
        //List<Player> players = gameStarter.pickPlayerCards(playerNames, resultView);

//        List<Player> playersFinishedGame = new GameProcessor(inputView,resultView).playersPlayGame(players);

    }
}
