package ua.mibal.component;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
class FileReaderTest {
    private static final String PATH = "src/test/resources/input.txt";
    private final FileReader reader = new FileReader();

    @Test
    void readFileExists() {
        assertDoesNotThrow(() -> reader.readFile(PATH));
    }

    @Test
    void readFile() {
        String actual = reader.readFile(PATH);

        assertEquals("Michael Jackson alive!\n", actual);
    }
}
