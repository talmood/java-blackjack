package view.reader;

import java.util.Scanner;

public class InputReader {

    private static final InputReader INSTANCE = new InputReader();

    private final Scanner scanner = new Scanner(System.in);

    private InputReader() {
    }

    public static InputReader getInstance() {
        return INSTANCE;
    }

    public String readLine() {
        return scanner.nextLine().trim();
    }

}
