package ua.mibal.component;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
public class FileReader {

    public String readFile(String path) {
        try {
            return readFileBy(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String readFileBy(String path) throws IOException {
        StringBuilder content = new StringBuilder();
        try (FileInputStream fis = new FileInputStream(path)) {
            int ch;
            while ((ch = fis.read()) != -1) {
                content.append((char) ch);
            }
        }
        return content.toString();
    }
}
