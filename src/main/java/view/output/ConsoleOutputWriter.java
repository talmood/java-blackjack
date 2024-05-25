package view.output;

public class ConsoleOutputWriter implements OutputWriter {
    @Override
    public void writeLine(String message) {
        System.out.println(message);
    }
}
