import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView(new InputValidator());
        ResultView resultView = new ResultView();

        GameStarter gameStarter = new GameStarter();

        //cardSet, dealer, players 생성
        GameStatus gameStatus = startGame(gameStarter, inputView, resultView);

        //게임 진행
        GameProcessor gameProcessor = new GameProcessor(inputView, resultView);
        List<Player> playersFinishedGame = gameProcessor.playersPlayGame(gameStatus.getPlayers(), gameStatus.getCardSet());
        Dealer dealerFinishedGame = gameProcessor.dealerPlayGame(gameStatus.getDealer(), gameStatus.getCardSet());

        GameStatus gameStatusWithResult = resultView.printGameResult(playersFinishedGame, dealerFinishedGame);
        List<WinningStatusPlayer> winningStatusPlayers = gameProcessor.decideWinner(gameStatusWithResult);
        resultView.printWinner(winningStatusPlayers);

    }

    private static GameStatus startGame(GameStarter gameStarter, InputView inputView, ResultView resultView) {
        CardSet cardSet = gameStarter.generateCardSet();
        List<Player> players = gameStarter.createPlayers(inputView);
        Dealer dealer = gameStarter.createDealer();

        GameStatus gameStatus = new GameStatus(players, dealer, cardSet);

        gameStarter.dealFirstTurn(gameStatus);
        resultView.printFirstDeal(gameStatus);

        return gameStatus;
    }

}
