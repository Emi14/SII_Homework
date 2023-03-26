package week6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.siit.homework.week6.Calculator;
import org.siit.homework.week6.Distance;

public class CalculatorTest {
    @ParameterizedTest
    @CsvSource({
            "1 m + 1 m = 2000 mm, You are correct",
            "1 m + 2 cm = 1020 mm, You are correct",
            "1 m - 10 cm = 900 mm, You are correct",
            "1 m + 1 cm = 1100 mm, You are not correct in your calculation! This is the correct answer: 1010mm",
            "1 m * 2 =, I only work with additions and subtraction",
            "1 m / 2 =, I only work with additions and subtraction"
    })

    void testCheckingUserCalculation(String input, String expectedOutput) {
        String actualOutput = Calculator.checkingUserCalculation(input);
        Assertions.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testSubtractWhenFirstValueIsBigger() {
        Distance d1 = new Distance(5, "cm");
        Distance d2 = new Distance(2, "cm");
        Distance difference = d1.subtract(d2);
        Assertions.assertEquals(30, difference.getValue(), 0.1);
        Assertions.assertEquals("mm", difference.getUnit());
    }

    @Test
    void testSubtractWhenSecondValueIsBigger() {
        Distance d1 = new Distance(2, "cm");
        Distance d2 = new Distance(5, "cm");
        Distance difference = d1.subtract(d2);
        Assertions.assertEquals(-30, difference.getValue(), 0.1);
        Assertions.assertEquals("mm", difference.getUnit());
    }

    @Test
    void testSubtractWhenFirstValueIsBigger_TwoDifferentMetricMValues(){
        Distance d1 = new Distance(1, "m");
        Distance d2 = new Distance(20, "cm");
        Distance difference = d1.subtract(d2);
        Assertions.assertEquals(800, difference.getValue(), 0.1);
        Assertions.assertEquals("mm", difference.getUnit());
    }

    @Test
    void testSubtractWhenSecondValueIsBigger_TwoDifferentMetricMValues(){
        Distance d1 = new Distance(1, "m");
        Distance d2 = new Distance(200, "cm");
        Distance difference = d1.subtract(d2);
        Assertions.assertEquals(-1000, difference.getValue(), 0.1);
        Assertions.assertEquals("mm", difference.getUnit());
    }

    @Test
    void testAddWhenBothValuesAreInMillimeters() {
        Distance d1 = new Distance(250, "mm");
        Distance d2 = new Distance(500, "mm");
        Distance sum = d1.add(d2);
        Assertions.assertEquals(750, sum.getValue(), 0.1);
        Assertions.assertEquals("mm", sum.getUnit());
    }

    @Test
    void testAddWhenBothValuesAreInCentimeters() {
        Distance d1 = new Distance(3, "cm");
        Distance d2 = new Distance(4, "cm");
        Distance sum = d1.add(d2);
        Assertions.assertEquals(70, sum.getValue(), 0.1);
        Assertions.assertEquals("mm", sum.getUnit());
    }

    @Test
    void testAddWhenBothValuesAreInDecimeters() {
        Distance d1 = new Distance(2.5, "dm");
        Distance d2 = new Distance(3.5, "dm");
        Distance sum = d1.add(d2);
        Assertions.assertEquals(600, sum.getValue(), 0.1);
        Assertions.assertEquals("mm", sum.getUnit());
    }

    @Test
    void testAddWhenBothValuesAreInMeters() {
        Distance d1 = new Distance(1.5, "m");
        Distance d2 = new Distance(2.5, "m");
        Distance sum = d1.add(d2);
        Assertions.assertEquals(4000, sum.getValue(), 0.1);
        Assertions.assertEquals("mm", sum.getUnit());
    }

    @Test
    void testAddWhenBothValuesAreInKilometers() {
        Distance d1 = new Distance(1.5, "km");
        Distance d2 = new Distance(2.5, "km");
        Distance sum = d1.add(d2);
        Assertions.assertEquals(4000000, sum.getValue(), 0.1);
        Assertions.assertEquals("mm", sum.getUnit());
    }

    @Test
    void testAddWhenFirstValueIsInKilometersAndSecondValueIsInCentimeters() {
        Distance d1 = new Distance(1.2, "km");
        Distance d2 = new Distance(150, "cm");
        Distance sum = d1.add(d2);
        Assertions.assertEquals(1201500.0, sum.getValue(), 0.1);
        Assertions.assertEquals("mm", sum.getUnit());
    }

    @Test
    void testGetValueInMillimetersForMM() {
        Distance d = new Distance(5, "mm");
        Assertions.assertEquals(5, d.getValueInMillimeters(), 0.1);
    }

    @Test
    void testGetValueInMillimetersForCM() {
        Distance d = new Distance(5, "cm");
        Assertions.assertEquals(50, d.getValueInMillimeters(), 0.1);
    }

    @Test
    void testGetValueInMillimetersForDM() {
        Distance d = new Distance(5, "dm");
        Assertions.assertEquals(500, d.getValueInMillimeters(), 0.1);
    }

    @Test
    void testGetValueInMillimetersForM() {
        Distance d = new Distance(5, "m");
        Assertions.assertEquals(5000, d.getValueInMillimeters(), 0.1);
    }

    @Test
    void testGetValueInMillimetersForKM() {
        Distance d = new Distance(5, "km");
        Assertions.assertEquals(5000000, d.getValueInMillimeters(), 0.1);
    }

    @Test
    void testSplitByEqual() {
        String result = Calculator.splitByEqual("2 m + 5 cm = 200 mm");
        Assertions.assertEquals("2 m + 5 cm  =  200 mm", result);
    }

    @Test
    void testSplitByEqualInvalidFormat() {
        String result = Calculator.splitByEqual("2 m + 5 cm 200 mm");
        Assertions.assertEquals("Invalid expression format. Please use the format: [number and unit] [+/-] [number and unit] ... = [number and unit]", result);
    }

    @Test
    void testCheckingUserCalculationCorrect() {
        String result = Calculator.checkingUserCalculation("2 m + 5 cm = 2000 mm");
        Assertions.assertEquals("You are not correct in your calculation! This is the correct answer: 2050mm", result);
    }

    @Test
    void testCheckingUserCalculationIncorrect() {
        String result = Calculator.checkingUserCalculation("2 m + 5 cm = 1000 mm");
        Assertions.assertEquals("You are not correct in your calculation! This is the correct answer: 2050mm", result);
    }

    @Test
    void testCalculateLeftHandSide() {
        double result = Calculator.calculateLeftHandSide("2 m + 5 cm - 10 mm");
        Assertions.assertEquals(2040, result, 0.1);
    }

    @Test
    void testCalculateRightHandSide() {
        double result = Calculator.calculateRightHandSide("2000 mm");
        Assertions.assertEquals(2000, result, 0.1);
    }
}
