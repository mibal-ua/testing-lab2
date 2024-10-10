package ua.mibal.model;

import java.util.function.IntBinaryOperator;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
public enum Operation {
    ADD("+", (a, b) -> a + b),
    SUBTRACT("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);
    
    private final String sign;
    private final IntBinaryOperator evaluator;

    Operation(String sign, IntBinaryOperator evaluator) {
        this.sign = sign;
        this.evaluator = evaluator;
    }

    public static Operation valueOfSign(String operation) {
        for (Operation value : values()) {
            if (value.sign.equals(operation)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown operation: " + operation);
    }
    
    public int evaluate(int a, int b) {
        return evaluator.applyAsInt(a, b);
    }
}
