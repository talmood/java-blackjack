package view;

import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public abstract class IOTest {
	private ByteArrayOutputStream byteArrayOutputStream;

	protected void systemIn(final String input) {
		System.setIn(new ByteArrayInputStream(input.getBytes()));
	}

	@BeforeEach
	void setUp() {
		byteArrayOutputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(byteArrayOutputStream));
	}

	protected String fetchOutput() {
		return byteArrayOutputStream.toString();
	}
}
