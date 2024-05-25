package Controller;

import domain.BlackjackPlayers;
import view.input.InputView;
import view.input.dto.PlayersInput;
import view.output.OutputView;

public class BlackjackSimulator {

    private final InputView inputView;
    private final OutputView outputView;

    public BlackjackSimulator(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        PlayersInput playersInput = inputView.viewPlayers();
        BlackjackPlayers blackjackPlayers = playersInput.toBlackjackPlayers();
        
    }
}
