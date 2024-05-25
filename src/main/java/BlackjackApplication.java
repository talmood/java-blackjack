import Controller.BlackjackSimulator;
import view.input.ConsoleInputView;
import view.input.InputView;
import view.output.ConsoleOutputView;
import view.output.OutputView;

public class BlackjackApplication {

    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();

        BlackjackSimulator blackjackSimulator = new BlackjackSimulator(inputView, outputView);
        blackjackSimulator.run();
    }
}
