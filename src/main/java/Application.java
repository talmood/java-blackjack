import java.util.List;

public class Application {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        InputValidator inputValidator = new InputValidator();
        ResultView resultView = new ResultView();

        GameStarter gameStarter = new GameStarter();
        List<String> playerNames = gameStarter.getPlayersNames(inputView, inputValidator);
        gameStarter.dealFirstTurnTwoCards(resultView,playerNames);

    }
}
