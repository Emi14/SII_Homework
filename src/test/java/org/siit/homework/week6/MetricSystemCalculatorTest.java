package org.siit.homework.week6;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class MetricSystemCalculatorTest {
    MetricSystemCalculator metricSystemCalculator;

    @BeforeEach
    void setUp() {
        metricSystemCalculator = new MetricSystemCalculator();
    }

    @Nested
    @DisplayName("addElements method")
    class AddElementsTests {

        @Test
        void addElements_addsElementToMillimeters() {
            metricSystemCalculator.addElements(10, "mm");
            Assertions.assertEquals(10, metricSystemCalculator.getMm());
        }

        @Test
        void addElements_addsElementToCentimeters() {
            metricSystemCalculator.addElements(10, "cm");
            Assertions.assertEquals(10, metricSystemCalculator.getCm());
        }

        @Test
        void addElements_addsElementToDecimeters() {
            metricSystemCalculator.addElements(10, "dm");
            Assertions.assertEquals(10, metricSystemCalculator.getDm());
        }

        @Test
        void addElements_addsElementToMeters() {
            metricSystemCalculator.addElements(10, "m");
            Assertions.assertEquals(10, metricSystemCalculator.getM());
        }

        @Test
        void addElements_addsElementToKilometers() {
            metricSystemCalculator.addElements(10, "km");
            Assertions.assertEquals(10, metricSystemCalculator.getKm());
        }

        @Test
        void addElements_doesNotAddElementForInvalidUnit() {
            metricSystemCalculator.addElements(10, "invalid");
            Assertions.assertEquals(0, metricSystemCalculator.getMm());
            Assertions.assertEquals(0, metricSystemCalculator.getCm());
            Assertions.assertEquals(0, metricSystemCalculator.getDm());
            Assertions.assertEquals(0, metricSystemCalculator.getM());
            Assertions.assertEquals(0, metricSystemCalculator.getKm());
        }
    }

    @Nested
    @DisplayName("subtractValues method")
    class SubtractValuesTests {

        @Test
        void subtractValues_subtractsElementFromMillimeters() {
            metricSystemCalculator.addElements(20, "mm");
            metricSystemCalculator.subtractValues(10, "mm");
            Assertions.assertEquals(10, metricSystemCalculator.getMm());
        }

        @Test
        void subtractValues_subtractsElementFromCentimeters() {
            metricSystemCalculator.addElements(20, "cm");
            metricSystemCalculator.subtractValues(10, "cm");
            Assertions.assertEquals(10, metricSystemCalculator.getCm());
        }

        @Test
        void subtractValues_subtractsElementFromDecimeters() {
            metricSystemCalculator.addElements(20, "dm");
            metricSystemCalculator.subtractValues(10, "dm");
            Assertions.assertEquals(10, metricSystemCalculator.getDm());
        }

        @Test
        void subtractValues_subtractsElementFromMeters() {
            metricSystemCalculator.addElements(20, "m");
            metricSystemCalculator.subtractValues(10, "m");
            Assertions.assertEquals(10, metricSystemCalculator.getM());
        }

        @Test
        void subtractValues_subtractsElementFromKilometers() {
            metricSystemCalculator.addElements(20, "km");
            metricSystemCalculator.subtractValues(10, "km");
            Assertions.assertEquals(10, metricSystemCalculator.getKm());
        }

        @Test
        void subtractValues_doesNotSubtractElementForInvalidUnit() {
            metricSystemCalculator.addElements(20, "mm");
            metricSystemCalculator.subtractValues(10, "invalid");
            Assertions.assertEquals(20, metricSystemCalculator.getMm());
        }
    }

    @Nested
    @DisplayName("evaluateMetricExpression method")
    class EvaluateMetricExpressionTests {

        @Test
        void shouldConvertExpressionFromMillimetersToCentimeters() {
            metricSystemCalculator.evaluateMetricExpression("100 mm + 1 m - 1 cm = 109 cm");
            assertEquals(metricSystemCalculator.metricConversion(), 109);
        }
    }
    @Test
    void shouldConvertExpressionFromCentimetersToMillimeters() {
        metricSystemCalculator.evaluateMetricExpression("100 mm + 1 m - 1 cm = 1090 mm");
        assertEquals(metricSystemCalculator.metricConversion(), 1090);
    }

    @Test
    void shouldConvertExpressionFromCentimetersToMeters() {
        metricSystemCalculator.evaluateMetricExpression("10 cm + 1 m - 1 cm = 1.09 m");
        assertEquals(metricSystemCalculator.metricConversion(), 1);
    }

    @Test
    void shouldConvertExpressionFromMetersToMillimeters() {
        metricSystemCalculator.evaluateMetricExpression("1 m - 10 cm + 1 km = 1000900 mm");
        assertEquals(metricSystemCalculator.metricConversion(), 1000900);
    }
}