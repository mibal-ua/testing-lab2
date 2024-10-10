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
        return expression.operation().evaluate(
                expression.left(),
                expression.right()
        );
    }
}
