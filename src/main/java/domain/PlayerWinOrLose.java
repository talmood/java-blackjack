package domain;

import java.util.Objects;

public class PlayerWinOrLose {

    private final BlackjackPlayerName blackjackPlayerName;

    private final WinOrLose winOrLose;

    public PlayerWinOrLose(BlackjackPlayerName blackjackPlayerName, WinOrLose winOrLose) {
        this.blackjackPlayerName = blackjackPlayerName;
        this.winOrLose = winOrLose;
    }

    public String fetchPlayerName() {
        return this.blackjackPlayerName.name();
    }

    public String fetchWinOrLoseKoreanName() {
        return this.winOrLose.getKoreanName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerWinOrLose that = (PlayerWinOrLose) o;
        return Objects.equals(blackjackPlayerName, that.blackjackPlayerName) && winOrLose == that.winOrLose;
    }

    @Override
    public int hashCode() {
        return Objects.hash(blackjackPlayerName, winOrLose);
    }
}
