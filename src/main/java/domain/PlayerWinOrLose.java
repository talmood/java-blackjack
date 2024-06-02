package domain;

public class PlayerWinOrLose {

    private final BlackjackPlayerName blackjackPlayerName;

    private final WinOrLose winOrLose;

    public PlayerWinOrLose(BlackjackPlayerName blackjackPlayerName, WinOrLose winOrLose) {
        this.blackjackPlayerName = blackjackPlayerName;
        this.winOrLose = winOrLose;
    }

    public String fetchPlayerName() {
        return this.blackjackPlayerName.getName();
    }

    public String fetchWinOrLoseKoreanName() {
        return this.winOrLose.getKoreanName();
    }
}
