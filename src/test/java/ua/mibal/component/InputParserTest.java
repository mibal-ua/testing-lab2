package ua.mibal.component;

import org.junit.Test;
import ua.mibal.model.Expression;
import ua.mibal.model.Operation;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class InputParserTest {
    private final FileReader fileReader = mock(FileReader.class);
    private final InputParser inputParser = new InputParser(fileReader);

    @Test
    public void parseFullExpression() {
        when(fileReader.readFile("./someFile.txt")).thenReturn("1 3 5 + 1 3 =");
        Expression result = inputParser.parse("./someFile.txt");
        Expression expected = new Expression(135, Operation.ADD, 13, true);
        assertEquals(expected, result);
    }
}