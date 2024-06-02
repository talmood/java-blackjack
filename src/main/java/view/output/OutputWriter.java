package view.output;

public interface OutputWriter {

    void writeLine(String message);

    void write(String message);

    void writeFormat(String message, Object... args);
}
