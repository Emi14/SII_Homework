package org.siit.homework.hw5Tema6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @DisplayName("Test expressions")
    @ParameterizedTest(name = "{index} => expression={0}, expected={1}")
    @CsvSource({
            "1 mm + 1 mm = 2 mm",
            "1 cm + 2 mm = 12 mm",
            "1 m - 10 dm = 0 mm",
            "10 km - 100 m = 999990000 mm"
    })
    void testCalculateExpression() {
        String expression = "11 m + 10 cm - 10 mm = 11090 mm";
        String expected = expression.substring(expression.lastIndexOf("=") + 2);

        String result = calculator.calculateExpression(expression);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void testGetConversionFactor() {
        Assertions.assertEquals(1, calculator.getConversionFactor("mm"));
        Assertions.assertEquals(10, calculator.getConversionFactor("cm"));
        Assertions.assertEquals(100, calculator.getConversionFactor("dm"));
        Assertions.assertEquals(1000, calculator.getConversionFactor("m"));
        Assertions.assertEquals(1000000, calculator.getConversionFactor("km"));
        Assertions.assertEquals(0, calculator.getConversionFactor("foo"));
    }

}
