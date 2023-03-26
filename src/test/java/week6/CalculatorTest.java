package week6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.siit.homework.week6.Calculator;
import org.siit.homework.week6.CalculatorInterface;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {
    private CalculatorInterface calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testComputeString_WhenOutputIsMm_ThenResultIsTrue() {
        String input = "15 mm + 8 m + 15 cm = 8165 mm";
        calculator.computeString(input);
        assertEquals(calculator.getResultType(), "mm");
    }

    @Test
    public void testComputeString_WhenOutputIsCm_ThenResultIsTrue() {
        String input = "8 m + 15 cm = 815 cm";
        calculator.computeString(input);
        assertEquals(calculator.getResultType(), "cm");
    }

    @Test
    public void testComputeString_WhenOutputIsDm_ThenResultIsTrue() {
        String input = "28 m - 15 dm + 2 dm + 1 m = 277 dm";
        calculator.computeString(input);
        assertEquals(calculator.getResultType(), "dm");
    }

    @Test
    public void testComputeString_WhenOutputIsM_ThenResultIsTrue() {
        String input = "10 m + 2 km = 2010 m";
        calculator.computeString(input);
        assertEquals(calculator.getResultType(), "m");
    }

    @Test
    public void testComputeString_WhenOutputIsKm_ThenResultIsTrue() {
        String input = "2 km + 3 km = 5 km";
        calculator.computeString(input);
        assertEquals(calculator.getResultType(), "km");
    }

    @Test
    public void testComputeString_WhenInputIsInvalid_ThenResultIsTrue() {
        calculator.computeString("10 cm * 1 m - 10 mm = 1090 mm");
        assertEquals(calculator.getResultType(), "null");
    }
}