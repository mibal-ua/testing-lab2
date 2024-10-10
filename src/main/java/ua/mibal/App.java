package ua.mibal;

import ua.mibal.component.Calculator;
import ua.mibal.component.FileReader;
import ua.mibal.component.FileWriter;
import ua.mibal.component.InputParser;
import ua.mibal.model.Expression;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
public class App {
    private final Calculator calculator = new Calculator();
    private final InputParser inputParser = new InputParser(
            new FileReader()
    );
    private final FileWriter fileWriter = new FileWriter();

    public void run(String[] args) {
        Expression expression = inputParser.parse(args[0]);
        int result = calculator.calculate(expression);
        fileWriter.write(result, args[1]);
    }
}
