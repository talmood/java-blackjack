import java.util.List;
import java.util.Scanner;

public class InputView {

    InputValidator inputValidator;

    public InputView(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    Scanner scanner = new Scanner(System.in);

    public List<String> getPlayerNames() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");

        return inputValidator.validatePlayerNames(acceptInput());
    }
    private String acceptInput() {
        return scanner.nextLine();
    }


    public boolean askIfGetOneMoreCard(String name) {

        System.out.println(name + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");

        return inputValidator.validateAnswerForOneMoreCard(acceptInput());
    }
}
