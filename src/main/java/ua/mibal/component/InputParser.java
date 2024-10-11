package ua.mibal.component;

import ua.mibal.model.Expression;
import ua.mibal.model.Operation;

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
        String input = fileReader.readFile(path);
        return parseExpression(input);
    }

    private Expression parseExpression(String input) {
        if (input.isEmpty()) {
            return Expression.empty();
        }
        String[] tokens = input.trim().split(" ");

        StringBuilder number = new StringBuilder();

        Integer left = null;
        Integer right = null;
        String operation = null;
        boolean isEqualsPresent = false;

        for (String token : tokens) {
            if (isNumber(token)) {
                number.append(token);
            }
            if (isOperation(token)) {
                operation = token;
                left = Integer.parseInt(number.toString());
                number = new StringBuilder();
            }
            if (isEquals(token)) {
                isEqualsPresent = true;
            }
        }
        if (!number.isEmpty()) {
            if (operation == null) {
                left = Integer.parseInt(number.toString());
            } else {
                right = Integer.parseInt(number.toString());
            }
        }

        return new Expression(
                left,
                operation == null ? null : Operation.valueOfSign(operation),
                right,
                isEqualsPresent
        );
    }

    private boolean isEquals(String token) {
        return token.equals("=");
    }

    private boolean isOperation(String token) {
        return token.matches("[+\\-*/]");
    }

    private boolean isNumber(String token) {
        return token.matches("\\d+");
    }
}
