import controller.BlackjackController;
import view.ConsoleWriter;
import view.InputView;
import view.ResultView;
import view.reader.InputReader;

public class BlackjackApplication {

    private BlackjackApplication() {
    }

    public static void main(String[] args) {
        final InputView inputView = new InputView(InputReader.getInstance(), ConsoleWriter.getInstance());
        final ResultView resultView = new ResultView(ConsoleWriter.getInstance());

        final BlackjackController controller = new BlackjackController(inputView, resultView);
        controller.run();
    }

}
