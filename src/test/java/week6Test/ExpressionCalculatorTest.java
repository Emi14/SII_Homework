package week6Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.siit.homework.week6.ExpressionCalculator;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpressionCalculatorTest {

    private ExpressionCalculator calculator;
    private List<String> elements;

    @BeforeEach
    public void setUp() {
        calculator = new ExpressionCalculator();
        elements = new ArrayList<>();
    }

    @Test
    public void testCalculateExpression_when10cmPlus1mMinus10mm_thenResultIs1090mm() {
        String expression = "10 cm + 1 m - 10 mm";
        String expectedResult = "1090 mm";
        assertEquals(expectedResult, calculator.calculate(expression), "Result should be 1090 mm");
    }

    @Test
    public void testSumList() {
        elements.add("10 cm");
        elements.add("1 m");
        int expectedResult = 1100;
        assertEquals(expectedResult, calculator.sumList(elements), "Result should be equal to 1100 mm");

    }
}
