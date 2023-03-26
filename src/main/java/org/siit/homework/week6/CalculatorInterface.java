package org.siit.homework.week6;

public interface CalculatorInterface {
    String getResultType();
    int calculateResult();
    int applyOperator(int left, String op, int right);
    void addOrSubtractValues(int value, String op, String measureUnit);
    void computeString(String expression);
}
