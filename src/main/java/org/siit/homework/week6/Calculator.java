package org.siit.homework.week6;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    String calculateExpression(String expression) {

        List<String> additionList = new ArrayList<>();
        List<String> subtractionList = new ArrayList<>();
        int checkPoint = 0;
        boolean op = true;

        for (int i = 1; i < expression.length(); i++) {
            String s = expression.substring(i, i + 1);
            if (Operator.PLUS.getOperator().equals(s)) {
                checkOperator(additionList, subtractionList, op, expression.substring(checkPoint, i).trim());
                checkPoint = i + 1;
                op = true;
            }
            if (Operator.MINUS.getOperator().equals(s)) {
                checkOperator(additionList, subtractionList, op, expression.substring(checkPoint, i).trim());
                checkPoint = i + 1;
                op = false;
            }
        }
        // Add last string
        checkOperator(additionList, subtractionList, op, expression.substring(checkPoint).trim());
        // Get sum each list
        int sumAdd = sumList(additionList);
        int sumMinus = sumList(subtractionList);

        int finalResult = sumAdd - sumMinus;

        return finalResult + " mm";
    }
    int sumList(List<String> aList) {
        int sum = 0;
        for (String s: aList) {
            String[] arr = s.split(" ");
            int value = Integer.parseInt(arr[0]);
            int scale = MetricConvertor.valueOf(arr[1]).getScale();
            sum += value * scale;
        }
        return sum;
    }
     void checkOperator(List<String> additionList, List<String> subtractionList, boolean op, String substring) {
        if (op) {
            additionList.add(substring);
        } else {
            subtractionList.add(substring);
        }
    }

}
