package view.output.dto;

import domain.FinalWinOrLose;

import java.util.List;
import java.util.stream.Collectors;

public class FinalWinOrLoseOutput {

    private final DealerWinOrLoseOutput dealerWinOrLoseOutput;

    private final List<PlayerWinOrLoseOutput> playerWinOrLoses;

    public FinalWinOrLoseOutput(DealerWinOrLoseOutput dealerWinOrLoseOutput, List<PlayerWinOrLoseOutput> playerWinOrLoses) {
        this.dealerWinOrLoseOutput = dealerWinOrLoseOutput;
        this.playerWinOrLoses = playerWinOrLoses;
    }

    public static FinalWinOrLoseOutput from(FinalWinOrLose finalWinOrLose) {
        return new FinalWinOrLoseOutput(
                DealerWinOrLoseOutput.from(finalWinOrLose.getDealerWinOrLose()),
                finalWinOrLose.fetchPlayerWinOrLose().stream()
                        .map(PlayerWinOrLoseOutput::from)
                        .collect(Collectors.toList())
        );
    }

    public DealerWinOrLoseOutput getDealerWinOrLoseOutput() {
        return dealerWinOrLoseOutput;
    }

    public List<PlayerWinOrLoseOutput> getPlayerWinOrLoses() {
        return List.copyOf(this.playerWinOrLoses);
    }
}
