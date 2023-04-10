package org.siit.projects.metricDistanceCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private Calculator calculator;
    private List<String> elem;

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
        elem = new ArrayList<>();
    }

    @Test
    public void testCalculateExpression_when10cmPlus1mMinus10mm_thenResultIs1090mm() {
        String expression = "10 cm + 1 m - 10 mm";
        String expectedResult = "1090 mm";
        assertEquals(expectedResult, calculator.calculateExpression(expression), "Result needs to be 1090 mm");
    }

    @Test
    public void testSumList() {
        elem.add("10 cm");
        elem.add("1 m");
        int expectedResult = 1100;
        assertEquals(expectedResult, calculator.sumList(elem), "Result must be equal to 1100 mm" );

    }
}
