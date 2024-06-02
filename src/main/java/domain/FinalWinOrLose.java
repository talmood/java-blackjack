package domain;

import domain.validator.CollectionValidator;
import domain.validator.ObjectsValidator;

import java.util.List;
import java.util.Objects;

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

    public List<PlayerWinOrLose> fetchPlayerWinOrLose() {
        return List.copyOf(this.playerWinOrLose);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinalWinOrLose that = (FinalWinOrLose) o;
        return Objects.equals(dealerWinOrLose, that.dealerWinOrLose) && Objects.equals(playerWinOrLose, that.playerWinOrLose);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dealerWinOrLose, playerWinOrLose);
    }
}
