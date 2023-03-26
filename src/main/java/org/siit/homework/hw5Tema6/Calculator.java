package org.siit.homework.hw5Tema6;

public class Calculator {

    public String calculateExpression(String expression) {
        String[] elements = expression.split(" ");

        int tempValue = Integer.parseInt(elements[0]);
        String tempUnit = elements[1];
        int tempConversionFactor = getConversionFactor(tempUnit);
        int result = tempValue * tempConversionFactor;
        String tempOperation = elements[2];

        for (int i = 3; i < elements.length; i += 3) {
            tempValue = Integer.parseInt(elements[i]);
            tempUnit = elements[i + 1];
            tempConversionFactor = getConversionFactor(tempUnit);

            if (tempOperation.equals("+")) {
                result += tempValue * tempConversionFactor;
            } else if (tempOperation.equals("-")) {
                result -= tempValue * tempConversionFactor;
            } else {
                break;
            }
            tempOperation = elements[i + 2];
        }

        return result + " mm";
    }

    public int getConversionFactor(String unit) {
        switch (unit) {
            case "mm":
                return 1;
            case "cm":
                return 10;
            case "dm":
                return 100;
            case "m":
                return 1000;
            case "km":
                return 1000000;
            default:
                return 0;
        }
    }
}
