package org.siit.projects.metricDistanceCalculator;

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
