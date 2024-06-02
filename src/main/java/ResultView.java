import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public void printFirstDeal(GameStatus gameStatus) {
        printPlayerNames(gameStatus);
        printInitialDealerCards(gameStatus.getDealer());
        printInitialPlayerCards(gameStatus.getPlayers());
    }

    private void printPlayerNames(GameStatus gameStatus) {
        List<Player> players = gameStatus.getPlayers();
        StringBuilder names = new StringBuilder();
        for (Player player : players) {
            names.append(",").append(player.getName());
        }

        System.out.println("딜러와" + names + "에게 2장을 나누었습니다.");
    }

    public void printInitialDealerCards(Dealer dealer) {
        Card firstCard = dealer.getCards().get(0);
        String denomination = getDenomination(firstCard);
        System.out.println("딜러: " + denomination + firstCard.suit.title);
    }

    private String getDenomination(Card card) {
        String denomination = "";
        if (Denomination.isNumber(card.number)) {
            denomination = String.valueOf(card.number.value);
        }
        if (!Denomination.isNumber(card.number)) {
            denomination = card.number.toString();
        }
        return denomination;
    }

    public void printInitialPlayerCards(List<Player> players) {
        for (Player player : players) {
            printPlayerCards(player);
        }
    }

    public void printPlayerCards(Player player) {
        String message = player.name + " 카드: ";
        List<Card> cards = player.cards;
        String cardsToString = cards.stream()
                .map(card -> getDenomination(card) + card.suit.title)
                .collect(Collectors.joining(", "));
        message += cardsToString;
        System.out.println(message);
    }

    public void printDealerGetsAdditionalCard() {
        System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
    }

    public GameStatus printGameResult(List<Player> playersFinishedGame, Dealer dealerFinishedGame) {
        List<Player> players = (List<Player>) printResult(playersFinishedGame);
        Dealer dealer = (Dealer) printResult(List.of(dealerFinishedGame)).get(0);
        return new GameStatus(players, dealer, null);
    }

    public List<? extends CardHolder> printResult(List<? extends CardHolder> cardHolders) {

        StringBuilder printContent = new StringBuilder();
        for (CardHolder holder : cardHolders) {
            printContent = new StringBuilder(addMessageIfDealer(holder, printContent.toString()));
            List<Card> cards = holder.cards;
            int totalValue = 0;
            StringBuilder cardString = new StringBuilder();
            for (Card card : cards) {
                cardString.append(getDenomination(card)).append(card.suit.title).append(",");
                totalValue += card.number.getValue();
            }
            cardString.deleteCharAt(cardString.length() - 1);
            printContent.append(cardString).append(" - 결과: ").append(totalValue).append("\n");
            holder.setTotalScore(totalValue);
        }
        System.out.println(printContent);
        return cardHolders;
    }

    private String addMessageIfDealer(CardHolder cardHolder, String printContent) {
        if (cardHolder instanceof Dealer) {
            printContent += "딜러 카드: ";
        }
        if (cardHolder instanceof Player) {
            printContent += ((Player) cardHolder).getName() + "카드: ";
        }
        return printContent;
    }

    public void printWinner(List<WinningStatusPlayer> winningStatusPlayers) {
        System.out.println("## 최종 승패");
        long playerWinCount = winningStatusPlayers.stream().filter(winningStatusPlayer -> winningStatusPlayer.winner).count();
        long playerLooseCount = winningStatusPlayers.stream().filter(winningStatusPlayer -> !winningStatusPlayer.winner).count();
        long playerTieCount = winningStatusPlayers.stream().filter(winningStatusPlayer -> winningStatusPlayer.winner == null).count();
        System.out.println("딜러: " + playerLooseCount + "승 " + playerWinCount + "패 " + playerTieCount + "무");
        winningStatusPlayers.forEach(winningStatusPlayer -> {
            String name = winningStatusPlayer.player.getName();
            System.out.print(name + ": ");
            printWinOrLoose(winningStatusPlayer.winner);
        });
    }

    private void printWinOrLoose(Boolean isWin) {
        if (isWin == null) {
            System.out.println("무");
        }
        if (Boolean.TRUE.equals(isWin)) {
            System.out.println("승");
        }
        if (Boolean.FALSE.equals(isWin)) {
            System.out.println("패");
        }
    }
}
