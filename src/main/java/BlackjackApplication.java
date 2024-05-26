import Controller.BlackjackSimulator;
import view.input.ConsoleInputReader;
import view.input.ConsoleInputView;
import view.input.InputReader;
import view.input.InputView;
import view.output.ConsoleOutputView;
import view.output.ConsoleOutputWriter;
import view.output.OutputView;
import view.output.OutputWriter;

public class BlackjackApplication {

    public static void main(String[] args) {
        InputReader inputReader = new ConsoleInputReader();
        OutputWriter outputWriter = new ConsoleOutputWriter();
        InputView inputView = new ConsoleInputView(inputReader, outputWriter);
        OutputView outputView = new ConsoleOutputView(outputWriter);

        BlackjackSimulator blackjackSimulator = new BlackjackSimulator(inputView, outputView);
        blackjackSimulator.run();
    }
}
