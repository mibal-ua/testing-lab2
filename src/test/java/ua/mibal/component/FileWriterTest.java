package ua.mibal.component;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
class FileWriterTest {
    private static final String PATH = "src/test/resources/output.txt";
    private final FileWriter writer = new FileWriter();

    @Test
    void writeShouldCreateFileInRightPath() {
        writer.write(0, PATH);

        assertTrue(Files.exists(Paths.get(PATH)));
    }

    @Test
    void writeShouldCreateFileWithRightContent() throws IOException {
        String expected = "123456";
        
        writer.write(123456, PATH);

        assertTrue(Files.exists(Paths.get(PATH)));
        String actual = Files.readString(Paths.get(PATH), StandardCharsets.UTF_8);
        assertEquals(expected, actual);
    }
}
