package domain;

import domain.validator.CollectionValidator;
import domain.validator.ObjectsValidator;

import java.util.List;

public class FinalWinOrLose {

    private final DealerWinOrLose dealerWinOrLose;

    private final List<PlayerWinOrLose> playerWinOrLose;

    public FinalWinOrLose(DealerWinOrLose dealerWinOrLose, List<PlayerWinOrLose> playerWinOrLose) {
        ObjectsValidator.validateNotNull(dealerWinOrLose);
        CollectionValidator.validateNotEmpty(playerWinOrLose);
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
