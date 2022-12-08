package week6;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.siit.homework.week6.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest
{
    private Calculator calculator;

    @BeforeEach
    public void setCalculator()
    {
        calculator = new Calculator();
        calculator.expresion("10 cm + 1 m - 10 mm = 1090 mm");
    }

    @Test
    public void test_ResultIsCorrect()
    {
        assertEquals(calculator.getAnswer(), calculator.getResult(), "The result is not correct");
    }
}
