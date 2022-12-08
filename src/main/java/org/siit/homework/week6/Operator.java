package org.siit.homework.week6;

public enum Operator {
    PLUS("+"),
    MINUS("-");

    private final String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }
}
