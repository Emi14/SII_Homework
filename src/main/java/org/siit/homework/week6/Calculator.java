package org.siit.homework.week6;

public class Calculator {
    public static String splitByEqual(String expression) {
        String[] parts = expression.split("=");
        if (parts.length != 2) {
            return "Invalid expression format. Please use the format: [number and unit] [+/-] [number and unit] ... = [number and unit]";
        }
        return parts[0] + " = " + parts[1];
    }

    public static String checkingUserCalculation(String expression) {
        String[] parts = splitByEqual(expression).split(" = ");
        String leftHandSide = parts[0];
        String rightHandSide = parts[1];
        if (parts[0].contains("*") || parts[0].contains("/")) {
            return "I only work with additions and subtraction";
        }
        if (parts[1].contains("*") || parts[1].contains("/")) {
            return "I only work with additions and subtraction";
        }
        double leftResult = calculateLeftHandSide(leftHandSide);
        double rightResult = calculateRightHandSide(rightHandSide);
        return compareResults(leftResult, rightResult, rightHandSide);
    }

    public static double calculateLeftHandSide(String leftHandSide) {
        String[] leftTerms = leftHandSide.split("(?=[+-])");
        double leftResult = 0;
        String operator = "+";
        for (String term : leftTerms) {
            Distance d = createDistance(term.trim());
            if (term.equals("+")) {
                operator = "+"; // update operator
                continue;
            } else if (term.equals("-")) {
                operator = "-"; // update operator
                continue;
            }
            String currentOperator = operator;
            if (term.startsWith("+") || term.startsWith("-")) {
                currentOperator = term.charAt(0) == '-' ? "-" : "+";
                term = term.substring(1);
            }
            double currentTermValue = createDistance(term.trim()).getValueInMillimeters();
            if (currentOperator.equals("+")) {
                leftResult += currentTermValue;
            } else {
                leftResult -= currentTermValue;
            }
        }
        return leftResult;
    }


    public static double calculateRightHandSide(String rightHandSide) {
        Distance right = createDistance(rightHandSide.trim());
        if (right == null) {
            throw new IllegalArgumentException("Invalid expression format. Please use the format: [number and unit] [+/-] [number and unit] ... = [number and unit]");
        }
        return right.getValueInMillimeters();
    }

    private static String compareResults(double leftResult, double rightResult, String rightHandSide) {
//        System.out.println("leftResult: " + leftResult + ", rightResult: " + rightResult);
        if (Double.isNaN(leftResult)) {
            return "Invalid expression format. Please use the format: [number and unit] [+/-] [number and unit] ... = [number and unit]";
        }
        if (leftResult == rightResult) {
            return "You are correct";
        } else {
            Distance right = createDistance(rightHandSide.trim());
            double correctResult = new Distance(leftResult / 1000, "m")
                    .getValueInMillimeters(); // convert back to original units
            return "You are not correct in your calculation! This is the correct answer: " + (int)correctResult + right.getUnit();
        }
    }

    private static Distance createDistance(String term) {
        String[] parts = term.split(" ");
        if (parts.length != 2) {
            return null;
        }
        try {
            double value = Double.parseDouble(parts[0]);
            return new Distance(value, parts[1]);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
