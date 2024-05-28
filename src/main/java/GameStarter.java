import java.util.ArrayList;
import java.util.List;

public class GameStarter {

    public List<String> getPlayersNames(InputView inputView, InputValidator inputValidator) {
        String unVerifiedPlayerNames = inputView.getPlayerNames();
        return inputValidator.validatePlayerNames(unVerifiedPlayerNames);
    }
    public void dealFirstTurnTwoCards(ResultView resultView, List<String> playerNames) {
        int dealingCardNumbers = 2;
        resultView.printFirstDeal(playerNames);
        Card card = new Card();
        List<Card> dealerCards = card.generateCards(dealingCardNumbers);
        Dealer dealer = new Dealer(dealerCards);
        List<Player> players = new ArrayList<>();

        for (String playerName : playerNames) {
            Player player = new Player(playerName, card.generateCards(dealingCardNumbers));
            players.add(player);
        }
        resultView.printInitialDealerCards(dealer);
        resultView.printInitialPlayerCards(players);
    }

}
