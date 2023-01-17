package org.siit.homework.week6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    public void test1(){

        String expression = "10 cm + 1 m - 10 mm = 1090 mm";
        String expected = expression.substring(expression.lastIndexOf("=") + 2);

        String result = calculator.calculateExpression(expression);

        Assertions.assertEquals(expected, result);

    }

    @Test
    public void test2(){

        String expression = "1 km - 2 m - 10 cm = 997900 mm";
        String expected = expression.substring(expression.lastIndexOf("=") + 2);

        String result = calculator.calculateExpression(expression);

        Assertions.assertEquals(expected, result);

    }

}
