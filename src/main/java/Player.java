public class Player extends CardHolder {
    String name;

    public Player(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }
    //    public Player acceptsExtraCard(final Player player) {
//        List<Card> playerCards = player.cards;
//        playerCards.add(playerCards.size(), new Card().generateCards(1).get(0));
//        return new Player(player.name, playerCards);
//    }


    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", cards=" + cards +
                '}';
    }
}
