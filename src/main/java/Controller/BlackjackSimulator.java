package Controller;

import domain.BlackjackPlayerName;
import view.input.InputView;
import view.input.dto.PlayersInput;
import view.output.OutputView;

import java.util.List;

public class BlackjackSimulator {

    private final InputView inputView;
    private final OutputView outputView;

    public BlackjackSimulator(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        PlayersInput playersInput = inputView.viewPlayers();
        List<BlackjackPlayerName> blackjackPlayerNames = playersInput.toBlackjackPlayerNames();


    }
}
