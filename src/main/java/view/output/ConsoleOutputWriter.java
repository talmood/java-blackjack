package view.output;

public class ConsoleOutputWriter implements OutputWriter {
    @Override
    public void writeLine(String message) {
        System.out.println(message);
    }

    @Override
    public void write(String message) {
        System.out.print(message);
    }

    @Override
    public void writeFormat(String message, Object... args) {
        System.out.printf(message, args);
    }
}
