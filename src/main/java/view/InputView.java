package view;

import model.participant.PlayerName;
import view.reader.InputReader;

import java.util.List;

public class InputView {

    private final InputReader reader;
    private final ConsoleWriter writer;

    public InputView(final InputReader reader, ConsoleWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public List<PlayerName> inputPlayerNames() {
        this.writer.printMessage("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        final InputPlayerNames names = InputPlayerNames.from(reader.readLine());
        return names.toPlayerNames();
    }

}
