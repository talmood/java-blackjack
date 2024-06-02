import java.util.ArrayList;
import java.util.List;

public class GameStarter {

    static final int DEALING_CARD_NUMBERS = 2;
    public List<Player> createPlayers(InputView inputView) {
        List<String> playerNames = inputView.getPlayerNames();
        return createPlayersByNames(playerNames);
    }

    private List<Player> createPlayersByNames(List<String> playerNames) {
        List<Player> players = new ArrayList<>();
        for (String playerName : playerNames) {
            Player player = new Player(playerName);
            players.add(player);
        }
        return players;
    }

    public Dealer createDealer(){
        return new Dealer();
    }

    //resultView.printFirstDeal(playerNames);

    public CardSet generateCardSet() {
       return new Card().generateCardSet();
    }
//
//    public Dealer pickDealerCards(ResultView resultView) {
//        Card card = new Card();
//        List<Card> dealerCards = card.generateCards(DEALING_CARD_NUMBERS);
//        Dealer dealer = new Dealer(dealerCards);
//        resultView.printInitialDealerCards(dealer);
//
//        return dealer;
//    }
//
//    public List<Player> pickPlayerCards(List<String> playerNames, ResultView resultView) {
//        Card card = new Card();
//        List<Player> players = new ArrayList<>();
//        for (String playerName : playerNames) {
//            Player player = new Player(playerName, card.generateCards(DEALING_CARD_NUMBERS));
//            players.add(player);
//        }
//        resultView.printInitialPlayerCards(players);
//
//        return players;
//    }
    
    public GameStatus dealFirstTurn(GameStatus gameStatus) {

        CardSet cardSet = gameStatus.getCardSet();
        List<Player> players = gameStatus.getPlayers();
        Dealer dealer = gameStatus.getDealer();

        for (Player player : gameStatus.getPlayers()) {
            player.pickCard(cardSet);
            player.pickCard(cardSet);
        }
        dealer.pickCard(cardSet);
        dealer.pickCard(cardSet);

        return new GameStatus(players,dealer,cardSet);
    }
}
