import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView(new InputValidator());
        ResultView resultView = new ResultView();

        GameStarter gameStarter = new GameStarter();
        //cardSet, dealer, players 생성
        CardSet cardSet = gameStarter.generateCardSet();
        List<Player> players = gameStarter.createPlayers(inputView);
        Dealer dealer = gameStarter.createDealer();
        GameStatus gameStatus = new GameStatus(players, dealer, cardSet);

        //firstDeal
        gameStarter.dealFirstTurn(gameStatus);
        resultView.printFirstDeal(gameStatus);

        GameProcessor gameProcessor = new GameProcessor(inputView, resultView);
        List<Player> playersFinishedGame = gameProcessor.playersPlayGame(players, cardSet);

    }
}
