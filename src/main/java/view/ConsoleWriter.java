package view;

public class ConsoleWriter {

    private static final ConsoleWriter INSTANCE = new ConsoleWriter();

    private ConsoleWriter() {
    }

    public static ConsoleWriter getInstance() {
        return INSTANCE;
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

}
