import java.util.ArrayList;
import java.util.List;

public class GameStarter {

    static final int DEALING_CARD_NUMBERS = 2;
    public List<String> getPlayersNames(InputView inputView) {
        return inputView.getPlayerNames();
    }

    public Dealer pickDealerCards(ResultView resultView) {
        Card card = new Card();
        List<Card> dealerCards = card.generateCards(DEALING_CARD_NUMBERS);
        Dealer dealer = new Dealer(dealerCards);
        resultView.printInitialDealerCards(dealer);

        return dealer;
    }

    public List<Player> pickPlayerCards(List<String> playerNames, ResultView resultView) {
        Card card = new Card();
        List<Player> players = new ArrayList<>();
        for (String playerName : playerNames) {
            Player player = new Player(playerName, card.generateCards(DEALING_CARD_NUMBERS));
            players.add(player);
        }
        resultView.printInitialPlayerCards(players);

        return players;
    }

}
