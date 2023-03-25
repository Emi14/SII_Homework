package org.siit.homework.week6;

public enum MathematicOperator {

    PLUS("+"),
    MINUS("-");

    private final String mathematicOperator;

    MathematicOperator(String operator) {
        this.mathematicOperator = operator;
    }

    public String getMathematicOperator() {
        return mathematicOperator;
    }
}
