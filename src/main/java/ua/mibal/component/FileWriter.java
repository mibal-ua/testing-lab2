package ua.mibal.component;

import java.io.IOException;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
public class FileWriter {

    public void write(int result, String path) {
        try {
            writeBy(result, path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeBy(int result, String path) throws IOException {
        try (java.io.FileWriter writer = new java.io.FileWriter(path)) {
            writer.write(String.valueOf(result));
        }
    }
}
