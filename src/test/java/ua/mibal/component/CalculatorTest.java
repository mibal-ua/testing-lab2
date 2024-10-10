package ua.mibal.component;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import ua.mibal.model.Expression;
import ua.mibal.model.Operation;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {
    private Calculator calculator = new Calculator();

    @Test
    public void calculateEmpty() {
        int result = calculator.calculate(Expression.empty());
        assertEquals(0, result);
    }

    @Test
    public void calculateLeftSide() {
        int result = calculator.calculate(new Expression(5, null, null, false));
        assertEquals(5, result);
    }

    @ParameterizedTest
    @EnumSource(value = Operation.class)
    public void calculateLeftSideWithSign(Operation sign) {
        int result = calculator.calculate(new Expression(12, sign, null, false));
        assertEquals(12, result);
    }

    @ParameterizedTest
    @EnumSource(value = Operation.class)
    public void calculateBothSides(Operation sign) {
        int result = calculator.calculate(new Expression(12, sign, 133, false));
        assertEquals(133, result);
    }

    @ParameterizedTest
    @CsvSource({
            "100,   -,    99,   1",
            "9,     /,    3,    3",
            "5,     *,    2,    10",
            "135,   +,    123,  258",
    })
    public void calculateFullExpression(int left, String operation, int right, int expected) {
        int result = calculator.calculate(new Expression(left, Operation.valueOfSign(operation), right, true));
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({
            "100,   /,  3,  33",
            "9,     /,  10, 0",
    })
    public void calculateRounding(int left, String operation, int right, int expected) {
        int result = calculator.calculate(new Expression(left, Operation.valueOfSign(operation), right, true));
        assertEquals(expected, result);
    }
}
