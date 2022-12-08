package org.siit.homework.week6;

import java.util.ArrayList;
import java.util.List;

public class ExpressionCalculator {

    public String calculate(String expression) {

        List<String> additionList = new ArrayList<>();
        List<String> subtractionList = new ArrayList<>();
        int checkPoint = 0;
        boolean op = true;

        for (int i = 1; i < expression.length(); i++) {
            String s = expression.substring(i, i + 1);
            if (MathematicOperator.PLUS.getMathematicOperator().equals(s)) {
                checkMathematicOperator(additionList, subtractionList, op, expression.substring(checkPoint, i).trim());
                checkPoint = i + 1;
                op = true;
            }
            if (MathematicOperator.MINUS.getMathematicOperator().equals(s)) {
                checkMathematicOperator(additionList, subtractionList, op, expression.substring(checkPoint, i).trim());
                checkPoint = i + 1;
                op = false;
            }
        }
        // Add last string
        checkMathematicOperator(additionList, subtractionList, op, expression.substring(checkPoint).trim());
        // Get sum each list
        int sumAdd = sumList(additionList);
        int sumMinus = sumList(subtractionList);

        int result = sumAdd - sumMinus;

        return result + " mm";
    }

    public int sumList(List<String> aList) {
        int sum = 0;
        for (String s : aList) {
            String[] arr = s.split(" ");
            int value = Integer.parseInt(arr[0]);
            int unit = UnitConverter.valueOf(arr[1]).getUnit();
            sum += value * unit;
        }
        return sum;
    }

    void checkMathematicOperator(List<String> additionList, List<String> subtractionList, boolean op, String substring) {
        if (op) {
            additionList.add(substring);
        } else {
            subtractionList.add(substring);
        }
    }
}
