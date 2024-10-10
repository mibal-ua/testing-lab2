package ua.mibal.component;

import ua.mibal.model.Expression;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
public class InputParser {
    private final FileReader fileReader;

    public InputParser(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public Expression parse(String path) {
        return null;
    }
}
