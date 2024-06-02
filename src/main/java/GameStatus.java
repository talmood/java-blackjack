import java.util.List;

public class GameStatus {

    public GameStatus(List<Player> players, Dealer dealer, CardSet cardSet) {
        this.players = players;
        this.dealer = dealer;
        this.cardSet = cardSet;
    }

    List<Player> players;
    Dealer dealer;
    CardSet cardSet;

    public List<Player> getPlayers() {
        return players;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public CardSet getCardSet() {
        return cardSet;
    }

}
