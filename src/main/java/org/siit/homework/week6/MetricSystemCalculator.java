package org.siit.homework.week6;

import lombok.Getter;

@Getter
public class MetricSystemCalculator {

    private int mm;
    private int cm;
    private int dm;
    private int m;
    private int km;
    private String metricResultFormat;

    int metricConversion() {
        int result;
        switch (this.metricResultFormat) {
            case "mm":
                result = mm + (cm * 10) + (dm * 100) + (m * 1000) + (km * 1000000);
                break;
            case "cm":
                result = (mm / 10) + cm + (dm * 10) + (m * 100) + (km * 100000);
                break;
            case "dm":
                result = (mm / 100) + (cm / 10) + dm + (m * 10) + (km * 10000);
                break;
            case "m":
                result = (mm / 1000) + (cm / 100) + (dm / 10) + m + (km * 1000);
                break;
            case "km":
                result = (mm / 1000000) + (cm / 100000) + (dm / 10000) + (m / 1000) + km;
                break;
            default:
                result = 0;
                break;
        }
        return result;
    }

    void addElements(int element, String metricUnit) {
        switch (metricUnit) {
            case "mm":
                this.mm += element;
                break;
            case "cm":
                this.cm += element;
                break;
            case "dm":
                this.dm += element;
                break;
            case "m":
                this.m += element;
                break;
            case "km":
                this.km += element;
                break;
            default:
                break;
        }
    }

    void subtractValues(int element, String metricUnit) {
        switch (metricUnit) {
            case "mm":
                this.mm -= element;
                break;
            case "cm":
                this.cm -= element;
                break;
            case "dm":
                this.dm -= element;
                break;
            case "m":
                this.m -= element;
                break;
            case "km":
                this.km -= element;
                break;
            default:
                break;
        }
    }

    public void evaluateMetricExpression(String expression) {
        String[] splitExpression = expression.split(" ");

        addElements(Integer.parseInt(splitExpression[0]), splitExpression[1]);
        label:
        for (int i = 2; i < splitExpression.length; i += 3) {
            switch (splitExpression[i]) {
                case "+":
                    addElements(Integer.parseInt(splitExpression[i + 1]), splitExpression[i + 2]);
                    break;
                case "-":
                    subtractValues(Integer.parseInt(splitExpression[i + 1]), splitExpression[i + 2]);
                    break;
                case "=":
                    this.metricResultFormat = splitExpression[i + 2];
                    break;
                default:
                    this.metricResultFormat = "null";
                    System.out.println("Invalid input. Please make sure to input the correct expression format, as per below: \n 10 cm + 1 m - 10 mm = 1090 mm");
                    break label;
            }
        }

        System.out.println(metricConversion() + " " + metricResultFormat);
    }
}
