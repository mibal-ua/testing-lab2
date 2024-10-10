package ua.mibal.component;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ua.mibal.model.Expression;
import ua.mibal.model.Operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static ua.mibal.model.Expression.empty;

public class InputParserTest {
    private final FileReader fileReader = mock(FileReader.class);
    private final InputParser inputParser = new InputParser(fileReader);

    @Test
    public void parseEmptyExpression() {
        when(fileReader.readFile("./someFile.txt")).thenReturn("");

        Expression actual = inputParser.parse("./someFile.txt");

        assertEquals(empty(), actual);
    }

    @ParameterizedTest
    @CsvSource({
            "1,     1",
            "1 3,   13",
            "1 3 5, 135",
    })
    public void parseOnlyLeftPart(String input, int left) {
        when(fileReader.readFile("./someFile.txt")).thenReturn(input);

        Expression actual = inputParser.parse("./someFile.txt");

        Expression expected = new Expression(left, null, null, false);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "1 0 0 -,   100,    -",
            "9 /,       9,      /",
            "1 3 5 *,   135,    *",
            "1 3 5 +,   135,    +",
    })
    public void parseLeftPartWithOperation(String input, int left, String operation) {
        when(fileReader.readFile("./someFile.txt")).thenReturn(input);

        Expression actual = inputParser.parse("./someFile.txt");

        Expression expected = new Expression(left, Operation.valueOfSign(operation), null, false);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "1 0 0 - 9 9,   100,    -,    99",
            "9 / 3,         9,      /,    3",
            "1 3 5 * 2 3 5, 135,    *,    235",
            "1 3 5 + 1 2 3, 135,    +,    123",
    })
    public void parseBothParts(String input, int left, String operation, int right) {
        when(fileReader.readFile("./someFile.txt")).thenReturn(input);

        Expression actual = inputParser.parse("./someFile.txt");

        Expression expected = new Expression(left, Operation.valueOfSign(operation), right, false);
        assertEquals(expected, actual);
    }

    @Test
    public void parseFullExpression() {
        when(fileReader.readFile("./someFile.txt")).thenReturn("1 3 5 + 1 3 =");

        Expression actual = inputParser.parse("./someFile.txt");

        Expression expected = new Expression(135, Operation.ADD, 13, true);
        assertEquals(expected, actual);
    }
}
