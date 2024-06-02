import java.util.List;

public class Player {
    String name;
    List<Card> cards;

    public Player(String name, List<Card> cards) {
        this.name = name;
        this.cards = cards;
    }

//    public Player acceptsExtraCard(final Player player) {
//        List<Card> playerCards = player.cards;
//        playerCards.add(playerCards.size(), new Card().generateCards(1).get(0));
//        return new Player(player.name, playerCards);
//    }
}
