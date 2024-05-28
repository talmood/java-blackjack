package domain;

import java.util.List;

public class FinalWinOrLose {

    private final DealerWinOrLose dealerWinOrLose;

    private final List<PlayerWinOrLose> playerWinOrLose;

    public FinalWinOrLose(DealerWinOrLose dealerWinOrLose, List<PlayerWinOrLose> playerWinOrLose) {
        this.dealerWinOrLose = dealerWinOrLose;
        this.playerWinOrLose = playerWinOrLose;
    }

    public DealerWinOrLose getDealerWinOrLose() {
        return dealerWinOrLose;
    }

    public List<PlayerWinOrLose> getPlayerWinOrLose() {
        return List.copyOf(this.playerWinOrLose);
    }
}
