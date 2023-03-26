package org.siit.homework.week6;

import java.util.Arrays;
import java.util.List;

public class Calculator implements CalculatorInterface {
    private int mm, cm, dm, m, km;
    private String resultType;

    @Override
    public String getResultType() {
        return resultType;
    }

    @Override
    public int calculateResult() {
        return switch (this.resultType) {
            case "mm" -> mm + cm * 10 + dm * 100 + m * 1000 + km * 1_000_000;
            case "cm" -> mm / 10 + cm + dm * 10 + m * 100 + km * 100_000;
            case "dm" -> mm / 100 + cm / 10 + dm + m * 10 + km * 10_000;
            case "m" -> mm / 1000 + cm / 100 + dm / 10 + m + km * 1000;
            case "km" -> mm / 1_000_000 + cm / 100_000 + dm / 10_000 + m / 1000 + km;
            default -> 0;
        };
    }

    @Override
    public int applyOperator(int left, String op, int right) {
        return switch (op) {
            case "+" -> left + right;
            case "-" -> left - right;
            default -> 0;
        };
    }

    @Override
    public void addOrSubtractValues(int value, String op, String measureUnit) {
        if (measureUnit.equals("mm")) {
            this.mm = applyOperator(this.mm, op, value);
        }
        if (measureUnit.equals("cm")) {
            this.cm = applyOperator(this.cm, op, value);
        }
        if (measureUnit.equals("dm")) {
            this.dm = applyOperator(this.dm, op, value);
        }
        if (measureUnit.equals("m")) {
            this.m = applyOperator(this.m, op, value);
        }
        if (measureUnit.equals("km")) {
            this.km = applyOperator(this.km, op, value);
        }
    }


    @Override
    public void computeString(String expression) {
        List<String> splitExpression = Arrays.asList(expression.split(" "));
        addOrSubtractValues(Integer.parseInt(splitExpression.get(0)), "+", splitExpression.get(1));
        for (int i = 2; i < splitExpression.size(); i += 3) {
            switch (splitExpression.get(i)) {
                case "+", "-" -> addOrSubtractValues(Integer.parseInt(splitExpression.get(i + 1)), splitExpression.get(i), splitExpression.get(i + 2));
                case "=" -> this.resultType = splitExpression.get(i + 2);
                default -> {
                    this.resultType = "null";
                    System.out.println("Invalid input");
                    i = splitExpression.size();
                }
            }
        }
        System.out.println(this.calculateResult() + " " + this.resultType);
        this.mm = this.cm = this.dm = this.m = this.km = 0;
    }
}
