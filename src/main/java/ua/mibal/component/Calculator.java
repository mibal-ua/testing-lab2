package ua.mibal.component;

import ua.mibal.model.Expression;

import java.util.Objects;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
public class Calculator {

    public int calculate(Expression expression) {
        if (Objects.equals(expression, Expression.empty())) {
            return 0;
        }
        if (expression.right() == null) {
            return expression.left();
        }
        if (!expression.isEqualsPresent()) {
            return expression.right();
        }
        switch (expression.operation()) {
            case ADD:
                return expression.left() + expression.right();
            case SUBTRACT:
                return expression.left() - expression.right();
            case MULTIPLY:
                return expression.left() * expression.right();
            case DIVIDE:
                return expression.left() / expression.right();
        }
        throw new IllegalArgumentException("Unknown operation: " + expression.operation());
    }
}
